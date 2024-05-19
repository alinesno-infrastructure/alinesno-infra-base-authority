<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--机构数据-->
      <el-col :span="24" :xs="24">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="机构名称" prop="loginName">
            <el-input
                v-model="queryParams.loginName"
                placeholder="请输入机构名称"
                clearable
                style="width: 240px"
                @keyup.enter="handleQuery"
            />
          </el-form-item>
          <el-form-item label="机构代码" prop="phone">
            <el-input
                v-model="queryParams.phone"
                placeholder="请输入手机号码"
                clearable
                style="width: 240px"
                @keyup.enter="handleQuery"
            />
          </el-form-item>
          <el-form-item label="状态" prop="groupStatus">
            <el-select
                v-model="queryParams.groupStatus"
                placeholder="机构状态"
                clearable
                style="width: 240px"
            >
              <el-option
                  v-for="dict in sys_normal_disable"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
              />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
            <el-button icon="Refresh" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
                type="primary"
                plain
                icon="Plus"
                @click="handleAdd"
                v-hasPermi="['system:user:add']"
            >新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
                type="success"
                plain
                icon="Edit"
                :disabled="single"
                @click="handleUpdate"
                v-hasPermi="['system:user:edit']"
            >修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
                type="danger"
                plain
                icon="Delete"
                :disabled="multiple"
                @click="handleDelete"
                v-hasPermi="['system:user:remove']"
            >删除</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="图标" align="center" width="70" key="icon" >
              <template #default="scope">
                  <div class="role-icon">
                    <img style="width:40px;height:40px;border-radius:5px;" :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((scope.$index + 1)%10 + 5) + '.png'" />
                  </div>
              </template>
          </el-table-column>
          <el-table-column label="机构名称" align="left" key="groupName" prop="groupName" v-if="columns[0].visible">
            <template #default="scope">
                <div>
                  {{ scope.row.groupName }}
                </div>
                <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.promptId">
                  调用码: {{ scope.row.groupCode }} <el-icon><CopyDocument /></el-icon>
                </div>
            </template>
          </el-table-column>
          <el-table-column label="机构描述" align="left" key="remark" prop="remark" v-if="columns[1].visible" :show-overflow-tooltip="true" />
          <el-table-column label="状态" width="100" align="center" prop="groupStatus">
            <template #default="scope">
                <el-switch
                  v-model="scope.row.groupStatus"
                  active-value="0"
                  inactive-value="1"
                />
            </template>
          </el-table-column>
          <el-table-column label="手机号" align="center" width="200" key="groupPhone" prop="groupPhone" v-if="columns[3].visible" :show-overflow-tooltip="true" />
          <el-table-column label="创建时间" align="center" prop="addTime" v-if="columns[6].visible" width="160">
            <template #default="scope">
              <span>{{ parseTime(scope.row.addTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
            <template #default="scope">
              <el-tooltip content="修改" placement="top" v-if="scope.row.id !== 1">
                <el-button
                    type="text"
                    icon="Edit"
                    @click="handleUpdate(scope.row)"
                    v-hasPermi="['system:user:edit']"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                <el-button
                    type="text"
                    icon="Delete"
                    @click="handleDelete(scope.row)"
                    v-hasPermi="['system:user:remove']"
                ></el-button>
              </el-tooltip>
              <el-tooltip content="团队人员" placement="top" v-if="scope.row.id !== 1">
                <el-button
                    type="text"
                    icon="CircleCheck"
                    @click="handleAuthRole(scope.row)"
                    v-hasPermi="['system:user:edit']"
                ></el-button>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
        <pagination
            v-show="total > 0"
            :total="total"
            v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize"
            @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改机构配置对话框 -->
    <el-dialog :title="title" v-model="open" width="800px" append-to-body>
      <el-form :model="form" :rules="rules" ref="groupRef" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="机构名称" prop="groupName">
              <el-input v-model="form.groupName" placeholder="请输入机构名称" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="联系号码" prop="groupPhone">
              <el-input v-model="form.groupPhone" placeholder="请输入联系号码" maxlength="11" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="机构描述">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入机构描述"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup name="Group">
import { changeGroupStatus, listGroup, delGroup, getGroup, updateGroup, addGroup } from "@/api/system/group";

const router = useRouter();
const { proxy } = getCurrentInstance();

const userList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const initPassword = ref(undefined);

// 列显隐信息
const columns = ref([
  { key: 0, label: `机构编号`, visible: true },
  { key: 1, label: `机构名称`, visible: true },
  { key: 2, label: `机构昵称`, visible: true },
  { key: 3, label: `部门`, visible: true },
  { key: 4, label: `手机号码`, visible: true },
  { key: 5, label: `状态`, visible: true },
  { key: 6, label: `创建时间`, visible: true }
]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    loginName: undefined,
    phone: undefined,
    groupStatus: undefined,
    department: undefined
  },
  rules: {
    groupName: [{ required: true, message: "机构名称不能为空", trigger: "blur" }, { min: 2, max: 20, message: "机构名称长度必须介于 2 和 20 之间", trigger: "blur" }],
    name: [{ required: true, message: "机构昵称不能为空", trigger: "blur" }],
    remark: [{ required: true, message: "机构昵称不能为空", trigger: "blur" }],
    groupPhone: [{ pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur" }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询机构列表 */
function getList() {
  loading.value = true;
  listGroup(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
    loading.value = false;
    userList.value = res.rows;
    total.value = res.total;
  });
};

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
};
/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
  const userIds = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除机构编号为"' + userIds + '"的数据项？').then(function () {
    return delGroup(userIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
};

/** 选择条数  */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
  form.value = {
    id: undefined,
    department: undefined,
    loginName: undefined,
    name: undefined,
    password: undefined,
    phone: undefined,
    email: undefined,
    sex: undefined,
    groupStatus: "0",
    remark: undefined,
    postIds: [],
    roleIds: []
  };
  proxy.resetForm("groupRef");
};
/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
};
/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加机构";
  form.value.password = initPassword.value;
};
/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const id = row.id || ids.value;
  getGroup(id).then(response => {
    form.value = response.rows;
    open.value = true;
    title.value = "修改机构";
    form.password = "";
  });
};
/** 提交按钮 */
function submitForm() {
  proxy.$refs["groupRef"].validate(valid => {
    if (valid) {
      if (form.value.id != undefined) {
        updateGroup(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addGroup(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
};

getList();

</script>
