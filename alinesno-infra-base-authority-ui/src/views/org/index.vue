<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--组织数据-->
      <el-col :span="24" :xs="24">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="组织名称" prop="loginName">
            <el-input
                v-model="queryParams.loginName"
                placeholder="请输入组织名称"
                clearable
                style="width: 240px"
                @keyup.enter="handleQuery"
            />
          </el-form-item>
          <el-form-item label="组织代码" prop="phone">
            <el-input
                v-model="queryParams.phone"
                placeholder="请输入手机号码"
                clearable
                style="width: 240px"
                @keyup.enter="handleQuery"
            />
          </el-form-item>
          <el-form-item label="状态" prop="OrganizationStatus">
            <el-select
                v-model="queryParams.OrganizationStatus"
                placeholder="组织状态"
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
                    <img v-if="scope.row.logoUrl" style="width:40px;height:40px;border-radius:5px;" :src="scope.row.logoUrl" />
                    <img v-else style="width:40px;height:40px;border-radius:5px;" :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((scope.$index + 1)%10 + 5) + '.png'" />
                  </div>
              </template>
          </el-table-column>
          <el-table-column label="组织名称" align="left" key="orgName" prop="orgName" v-if="columns[0].visible">
            <template #default="scope">
                <div>
                  {{ scope.row.orgName }}
                </div>
                <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.id">
                  组织号: {{ scope.row.id }} <el-icon><CopyDocument /></el-icon>
                </div>
            </template>
          </el-table-column>
          <el-table-column label="组织描述" align="left" key="remark" prop="remark" v-if="columns[1].visible" />
          <el-table-column label="成员数量" align="center" width="100" key="remark" prop="remark" v-if="columns[1].visible" >
              <template #default="scope">
                <i class="fa-solid fa-user-tag"></i>&nbsp; {{ scope.row.memberCount }} 人
              </template>
          </el-table-column>
          <el-table-column label="管理员" align="center" key="doorplateNumber" prop="doorplateNumber" v-if="columns[1].visible" >
              <template #default="scope">
                <el-button type="primary" bg link @click="handleOrgAccountList(scope.row)"> 
                  <i class="fa-solid fa-shield-halved"></i>&nbsp;组织成员
                </el-button>
              </template>
          </el-table-column>
        <el-table-column label="状态" width="100" align="center" prop="status">
          <template #default="scope">
              <el-switch
                v-model="scope.row.hasStatus"
                :active-value="0"
                :inactive-value="1"
                @change="handleChangStatusField('hasStatus' , scope.row.hasStatus, scope.row.id)"
              />
          </template>
        </el-table-column>
          <el-table-column label="联系人" align="center" width="200" key="orgPhone" prop="orgPhone" v-if="columns[3].visible" />
          <el-table-column label="创建时间" align="center" prop="addTime" v-if="columns[6].visible" >
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
                    :disabled="scope.row.systemInner === 'Y'"
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

    <!-- 添加或修改组织配置对话框 -->
    <el-dialog :title="title" v-model="open" width="800px" append-to-body>
      <el-form :model="form" :rules="rules" ref="OrganizationRef" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="组织名称" prop="orgName">
              <el-input v-model="form.orgName" placeholder="请输入组织名称" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="联系号码" prop="orgPhone">
              <el-input v-model="form.orgPhone" placeholder="请输入联系号码" maxlength="11" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="组织描述">
              <el-input v-model="form.remark" placeholder="请输入组织描述"></el-input>
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

    <!-- 显示组织成员列表对话框 -->
    <el-dialog title="组织成员列表" v-model="openOrgAccount" width="1024px" append-to-body>
      <OrgAccount ref="orgAccountRef" />
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup name="Organization">
import { 
  changStatusField, 
  listOrganization, 
  delOrganization, 
  getOrganization, 
  updateOrganization, 
  addOrganization } from "@/api/system/org";

import OrgAccount from './orgAccount.vue'

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

const orgAccountRef = ref(null)
const openOrgAccount = ref(false);
const currentOrgId = ref("")

// 列显隐信息
const columns = ref([
  { key: 0, label: `组织编号`, visible: true },
  { key: 1, label: `组织名称`, visible: true },
  { key: 2, label: `组织昵称`, visible: true },
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
    OrganizationStatus: undefined,
    department: undefined
  },
  rules: {
    orgName: [{ required: true, message: "组织名称不能为空", trigger: "blur" }, { min: 2, max: 20, message: "组织名称长度必须介于 2 和 20 之间", trigger: "blur" }],
    name: [{ required: true, message: "组织昵称不能为空", trigger: "blur" }],
    remark: [{ required: true, message: "组织昵称不能为空", trigger: "blur" }],
    orgPhone: [{ pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur" }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询组织列表 */
function getList() {
  loading.value = true;
  listOrganization(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
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
  proxy.$modal.confirm('是否确认删除组织编号为"' + userIds + '"的数据项？').then(function () {
    return delOrganization(userIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
};

/** 选择条数  */
function handleSelectionChange(selection) {

  let sel = false ;

  selection.forEach(item => {
    if (item.systemInner === 'Y') {
      proxy.$modal.msgError("超级管理员不允许删除");
      sel = true ; 
      return;
    }
  });

  if(sel){
    return;
  }

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
    OrganizationStatus: "0",
    remark: undefined,
    postIds: [],
    roleIds: []
  };
  proxy.resetForm("OrganizationRef");
};
/** 取消按钮 */
function cancel() {
  open.value = false;
  openOrgAccount.value = false;
  reset();
};
/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加组织";
  form.value.password = initPassword.value;
};
/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const id = row.id || ids.value;
  getOrganization(id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改组织";
    form.password = "";
  });
};
/** 提交按钮 */
function submitForm() {
  proxy.$refs["OrganizationRef"].validate(valid => {
    if (valid) {
      if (form.value.id != undefined) {
        updateOrganization(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addOrganization(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
};

const handleChangStatusField = async(field , value , id) => {
    // 判断tags值 这样就不会进页面时调用了
      const res = await changStatusField({
         field: field,
         value: value?1:0,
         id: id
      }).catch(() => { })
      if (res && res.code == 200) {
         // 刷新表格
         getList()
      }
}

/** 组织账号管理 */
function handleOrgAccountList(row){
  // currentOrgId.value = row.id ;
  openOrgAccount.value = true ;

  nextTick(() => {
    orgAccountRef.value.searchOrgAccount(row.id);
  })
}

getList();

</script>
