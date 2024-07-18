<template>
  <div>
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="title">
        <el-input
            v-model="queryParams.title"
            placeholder="请输入项目名称"
            clearable
            style="width: 240px;"
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目代码" prop="operName">
        <el-input
            v-model="queryParams.operName"
            placeholder="请输入操作人员"
            clearable
            style="width: 240px;"
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table ref="operlogRef" v-loading="loading" :data="operlogList" @selection-change="handleSelectionChange" :default-sort="defaultSort" @sort-change="handleSortChange">
      <el-table-column type="index" width="55" label="序号" align="center" />
      <el-table-column label="图标" align="center" width="70" key="icon" >
          <!-- <template #default="scope">
              <span style="font-size:25px;color:#3b5998">
                <i :class="scope.row.icon" />
              </span>
          </template> -->
          <template #default="scope">
              <div class="role-icon">
                <img style="width:40px;height:40px;border-radius:5px;" :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((scope.$index + 1)%10 + 5) + '.png'" />
              </div>
          </template>
      </el-table-column>
      <el-table-column label="项目名称" width="250" align="left" prop="projectName">
        <template #default="scope">
          <div>
            {{ scope.row.projectName }}
          </div>
          <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.promptId">
            调用码: {{ scope.row.projectCode }} <el-icon><CopyDocument /></el-icon>
          </div>
      </template>
      </el-table-column>
      <el-table-column label="项目描述" align="left" prop="projectDesc" />
      <el-table-column label="状态" width="100" align="center" prop="status">
        <!-- <template #default="scope">
          <dict-tag :options="sys_common_status" :value="scope.row.status" />
        </template> -->
        <template #default="scope">
            <el-switch
              v-model="scope.row.hasStatus"
              active-value="0"
              inactive-value="1"
            />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="100" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              type="primary"
              bg 
              link
              @click="handlechoiceProject(scope.row)"
              v-hasPermi="['system:menu:edit']">
              <i class="fa-solid fa-pen-nib"></i> 选择
          </el-button>
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
            <el-form-item label="菜单图标" prop="projectIcons">
              <el-popover
                  placement="bottom-start"
                  :width="540"
                  trigger="click"
                  @show="showSelectIcon">
                <template #reference>
                  <el-input v-model="form.projectIcons" placeholder="点击选择图标" @click="showSelectIcon" v-click-outside="hideSelectIcon" readonly>
                    <template #prefix>
                      <svg-icon
                          v-if="form.projectIcons"
                          :icon-class="form.projectIcons"
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
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目描述" prop="projectDesc">
          <el-input v-model="form.projectDesc" placeholder="请输入项目描述" />
        </el-form-item>
        <el-form-item label="项目代码" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入项目代码" />
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

<script setup name="Project">
import { 
  listProject, 
  delProject , 
  updateProject , 
  addProject , 
  choiceProject
} from "@/api/system/project";

import SvgIcon from "@/components/SvgIcon";
import IconSelect from "@/components/IconSelect";
import { ClickOutside as vClickOutside } from 'element-plus'

const { proxy } = getCurrentInstance();
const { sys_oper_type, sys_common_status } = proxy.useDict("sys_oper_type","sys_common_status");

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
  form: {},
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
  listProject(proxy.addDateRange(queryParams.value, dateRange.value)).then(response => {
    operlogList.value = response.data;
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

/** 选择项目 */
function handlechoiceProject(row){
  choiceProject(row.id).then(res => {
    location.reload();
  })
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
    return delProject(operIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}
/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加项目";
}
/** 修改按钮操作 */
async function handleUpdate(row) {
  reset();
  await getTreeselect();
  getProject(row.id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改项目";
  });
}

/** 清空按钮操作 */
// function handleClean() {
//   proxy.$modal.confirm("是否确认清空所有操作日志数据项?").then(function () {
//     return cleanProject();
//   }).then(() => {
//     getList();
//     proxy.$modal.msgSuccess("清空成功");
//   }).catch(() => {});
// }

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
      if (form.value.menuId != undefined) {
        updateProject(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addProject(form.value).then(response => {
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