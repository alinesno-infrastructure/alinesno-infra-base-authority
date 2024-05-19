<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="应用名称" prop="title">
        <el-input
            v-model="queryParams.title"
            placeholder="请输入应用名称"
            clearable
            style="width: 240px;"
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应用代码" prop="operName">
        <el-input
            v-model="queryParams.operName"
            placeholder="请输入操作人员"
            clearable
            style="width: 240px;"
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select
            v-model="queryParams.status"
            placeholder="操作状态"
            clearable
            style="width: 240px"
        >
          <el-option
              v-for="dict in sys_common_status"
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
              plain
              type="primary"
              icon="Plus"
              @click="handleAdd()"
              v-hasPermi="['system:dept:add']"
          >新增</el-button>
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['monitor:operlog:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['monitor:operlog:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table ref="operlogRef" v-loading="loading" :data="operlogList" @selection-change="handleSelectionChange" :default-sort="defaultSort" @sort-change="handleSortChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="图标" align="center" width="70" key="icon" >
          <template #default="scope">
              <div class="role-icon">
                <img style="width:40px;height:40px;border-radius:5px;" :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((scope.$index + 1)%10 + 5) + '.png'" />
              </div>
          </template>
      </el-table-column>
      <el-table-column label="应用名称" align="left" prop="applicationName">
        <template #default="scope">
          <div>
            {{ scope.row.applicationName }}
          </div>
          <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.promptId">
            调用码: {{ scope.row.applicationCode }} <el-icon><CopyDocument /></el-icon>
          </div>
      </template>
      </el-table-column>
      <el-table-column label="应用描述" align="left" prop="applicationDesc" />
      <el-table-column label="应用链接" align="center" width="150" prop="businessType">
        <template #default="scope">
          <el-button type="primary" bg link @click="enterAppHome(scope.row)"> <i class="fa-solid fa-link"></i> 打开配置</el-button>
        </template>
      </el-table-column>
      <el-table-column label="状态" width="100" align="center" prop="status">
        <template #default="scope">
            <el-switch
              v-model="scope.row.hasStatus"
              active-value="0"
              inactive-value="1"
            />
        </template>
      </el-table-column>
      <el-table-column label="菜单配置" align="center" width="200" key="requestCount" prop="requestCount" :show-overflow-tooltip="true">
          <template #default="scope">
                <el-button type="danger" bg link @click="openMenu(scope.row)"> <i class="fa-solid fa-link"></i> 配置</el-button>
          </template>
      </el-table-column>
      <el-table-column label="添加日期" align="center" prop="operTime" sortable="custom" :sort-orders="['descending', 'ascending']" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.addTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              type="text"
              icon="Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['system:menu:edit']"
          >修改</el-button>
          <el-button
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['system:menu:remove']"
          >删除</el-button>
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

    <!-- 操作日志详细 -->
    <el-dialog :title="title" v-model="open" width="700px" append-to-body>
      <el-form ref="applicationFormRef" :model="form" :rules="rules" label-width="80px">
          <el-col :span="24">
            <el-form-item label="菜单图标" prop="applicationIcons">
              <el-popover
                  placement="bottom-start"
                  :width="540"
                  trigger="click"
                  @show="showSelectIcon">
                <template #reference>
                  <el-input v-model="form.applicationIcons" placeholder="点击选择图标" @click="showSelectIcon" v-click-outside="hideSelectIcon" readonly>
                    <template #prefix>
                      <svg-icon
                          v-if="form.applicationIcons"
                          :icon-class="form.applicationIcons"
                          class="el-input__icon"
                          style="height: 32px;width: 16px;"
                      />
                      <el-icon v-else style="height: 32px;width: 16px;"><search /></el-icon>
                    </template>
                  </el-input>
                </template>
                <icon-select ref="iconSelectRef" @selected="selected" />
              </el-popover>
            </el-form-item>
          </el-col>
        <el-form-item label="应用名称" prop="applicationName">
          <el-input v-model="form.applicationName" placeholder="请输入应用名称" />
        </el-form-item>
        <el-form-item label="应用描述" prop="applicationDesc">
          <el-input v-model="form.applicationDesc" placeholder="请输入应用描述" />
        </el-form-item>
        <el-form-item label="应用代码" prop="applicationCode">
          <el-input v-model="form.applicationCode" placeholder="请输入应用代码" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Application">

import { 
  listApplication, 
  delApplication , 
  getApplication ,
  updateApplication , 
  addApplication
} from "@/api/system/application";

import SvgIcon from "@/components/SvgIcon";
import IconSelect from "@/components/IconSelect";
import { ClickOutside as vClickOutside } from 'element-plus'

const { proxy } = getCurrentInstance();
const { sys_oper_type, sys_common_status } = proxy.useDict("sys_oper_type","sys_common_status");

const router = useRouter();
const operlogList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const showChooseIcon = ref(false);
const iconSelectRef = ref(null);
const dateRange = ref([]);
const defaultSort = ref({ prop: "operTime", order: "descending" });

const data = reactive({
  form: {
    applicationIcons: ''
  },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    title: undefined,
    operName: undefined,
    businessType: undefined,
    status: undefined
  }
});

const { queryParams, form } = toRefs(data);

/** 表单重置 */
function reset() {
  form.value = {
    id: undefined,
    parentId: undefined,
    deptName: undefined,
    orderNum: 0,
    leader: undefined,
    phone: undefined,
    email: undefined,
    status: "0"
  };
  proxy.resetForm("deptRef");
}

/** 查询登录日志 */
function getList() {
  loading.value = true;
  listApplication(proxy.addDateRange(queryParams.value, dateRange.value)).then(response => {
    operlogList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}
/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
}
/** 展示下拉图标 */
function showSelectIcon() {
  iconSelectRef.value.reset();
  showChooseIcon.value = true;
}
/** 打开菜单 */
function openMenu(row){
  let path =  '/application/system/menu/'
  router.push({ path: path + row.id });
}
/** 选择图标 */
function selected(name) {
  form.value.icon = name;
  showChooseIcon.value = false;
}
/** 图标外层点击隐藏下拉列表 */
function hideSelectIcon(event) {
  var elem = event.relatedTarget || event.srcElement || event.target || event.currentTarget;
  var className = elem.className;
  if (className !== "el-input__inner") {
    showChooseIcon.value = false;
  }
}
/** 操作日志类型字典翻译 */
function typeFormat(row, column) {
  return proxy.selectDictLabel(sys_oper_type.value, row.businessType);
}
/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}
/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  proxy.$refs["operlogRef"].sort(defaultSort.value.prop, defaultSort.value.order);
  handleQuery();
}
/** 多选框选中数据 */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  multiple.value = !selection.length;
}
/** 排序触发事件 */
function handleSortChange(column, prop, order) {
  queryParams.value.orderByColumn = column.prop;
  queryParams.value.isAsc = column.order;
  getList();
}
/** 详细按钮操作 */
function handleView(row) {
  open.value = true;
  form.value = row;
}
/** 删除按钮操作 */
function handleDelete(row) {
  const operIds = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除日志编号为"' + operIds + '"的数据项?').then(function () {
    return delApplication(operIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}
/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加应用";
}
/** 修改按钮操作 */
async function handleUpdate(row) {
  reset();
  getApplication(row.id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改应用";
  });
}
/** 导出按钮操作 */
function handleExport() {
  proxy.download("monitor/operlog/export",{
    ...queryParams.value,
  }, `config_${new Date().getTime()}.xlsx`);
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["applicationFormRef"].validate(valid => {
    if (valid) {
      if (form.value.id != undefined) {
        updateApplication(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addApplication(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

getList();
</script>
