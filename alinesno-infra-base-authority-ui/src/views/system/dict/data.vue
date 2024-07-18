<template>
  <div class="app-container">
    <el-page-header @back="goBack" content="字典管理"></el-page-header>
    <br/>
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="字典名称" prop="codeTypeValue">
        <el-select v-model="queryParams.codeTypeValue">
          <el-option
              v-for="item in typeOptions"
              :key="item.id"
              :label="item.codeTypeName"
              :value="item.codeTypeValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="字典标签" prop="codeDesc">
        <el-input
            v-model="queryParams.codeDesc"
            placeholder="请输入字典标签"
            clearable
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="数据状态" clearable>
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
            v-hasPermi="['system:dict:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate"
            v-hasPermi="['system:dict:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['system:dict:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['system:dict:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Close"
            @click="handleClose"
        >关闭</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column type="index" label="序号" width="55" align="center" />
      <el-table-column label="字典名称" align="center" prop="codeName" />
      <el-table-column label="字典描述" align="center" prop="codeDesc">
        <template #default="scope">
          <span v-if="scope.row.listClass == '' || scope.row.listClass == 'default'">{{ scope.row.codeDesc }}</span>
          <el-tag v-else :type="scope.row.listClass == 'primary' ? '' : scope.row.listClass">{{ scope.row.codeDesc }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="字典键值" align="center" prop="codeValue" />
      <el-table-column label="字典排序" align="center" prop="dictSort" />
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
      <el-table-column label="备注" align="center" prop="remark" :show-overflow-tooltip="true" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
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
              v-hasPermi="['system:dict:edit']"
          >修改</el-button>
          <el-button
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['system:dict:remove']"
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

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="dataRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="字典类型">
          <el-input v-model="form.codeTypeValue" :disabled="true" />
        </el-form-item>
        <el-form-item label="字典名称" prop="codeDesc">
          <el-input v-model="form.codeName" placeholder="请输入字典名称" />
        </el-form-item>
        <el-form-item label="字典描述" prop="codeDesc">
          <el-input v-model="form.codeDesc" placeholder="请输入字典描述" />
        </el-form-item>
        <el-form-item label="数据键值" prop="codeValue">
          <el-input v-model="form.codeValue" placeholder="请输入数据键值" />
        </el-form-item>
        <el-form-item label="样式属性" prop="cssClass">
          <el-input v-model="form.cssClass" placeholder="请输入样式属性" />
        </el-form-item>
        <el-form-item label="显示排序" prop="dictSort">
          <el-input-number v-model="form.dictSort" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item label="回显样式" prop="listClass">
          <el-select v-model="form.listClass">
            <el-option
                v-for="item in listClassOptions"
                :key="item.value"
                :label="item.label + '(' + item.value + ')'"
                :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
                v-for="dict in sys_normal_disable"
                :key="dict.value"
                :label="dict.value"
            >{{ dict.label }}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"></el-input>
        </el-form-item>
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

<script setup name="Data">
import useDictStore from '@/store/modules/dict'
import { optionselect as getDictOptionselect, getType } from "@/api/system/dict/type";
import { listData, getData, delData, addData, updateData ,changStatusField } from "@/api/system/dict/data";

const router = useRouter();
const { proxy } = getCurrentInstance();
const { sys_normal_disable } = proxy.useDict("sys_normal_disable");

const dataList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const defaultDictType = ref("");
const defaultDictTypeId = ref("");
const typeOptions = ref([]);
const route = useRoute();
// 数据标签回显样式
const listClassOptions = ref([
  { value: "default", label: "默认" },
  { value: "primary", label: "主要" },
  { value: "success", label: "成功" },
  { value: "info", label: "信息" },
  { value: "warning", label: "警告" },
  { value: "danger", label: "危险" }
]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    dictName: undefined,
    codeTypeValue: undefined,
    codeTypeId: undefined,
    status: undefined
  },
  rules: {
    codeDesc: [{ required: true, message: "数据标签不能为空", trigger: "blur" }],
    codeValue: [{ required: true, message: "数据键值不能为空", trigger: "blur" }],
    dictSort: [{ required: true, message: "数据顺序不能为空", trigger: "blur" }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询字典类型详细 */
function getTypes(dictId) {
  getType(dictId).then(response => {

    queryParams.value.codeTypeValue = response.data.codeTypeValue;
    queryParams.value.codeTypeId = response.data.id;

    defaultDictType.value = response.data.codeTypeValue;
    defaultDictTypeId.value = response.data.id;

    getList();
  });
}

/** 查询字典类型列表 */
function getTypeList() {
  getDictOptionselect().then(response => {
    typeOptions.value = response.data;
  });
}
/** 查询字典数据列表 */
function getList() {
  loading.value = true;
  listData(queryParams.value).then(response => {
    dataList.value = response.data;
    total.value = response.total;
    loading.value = false;
  });
}
/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
}
/** 返回上一页 */
function goBack() {
  router.back();
}
/** 表单重置 */
function reset() {
  form.value = {
    codeName: undefined,
    codeDesc: undefined,
    codeValue: undefined,
    cssClass: undefined,
    listClass: "default",
    dictSort: 0,
    status: "0",
    remark: undefined
  };
  proxy.resetForm("dataRef");
}
/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}
/** 返回按钮操作 */
function handleClose() {
  const obj = { path: "/system/dict" };
  proxy.$tab.closeOpenPage(obj);
}
/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  queryParams.value.codeTypeValue = defaultDictType;
  handleQuery();
}
/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加字典数据";

  form.value.codeTypeValue = queryParams.value.codeTypeValue;
  form.value.codeTypeId = queryParams.value.codeTypeId ;
}
/** 多选框选中数据 */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}
/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const codeName = row.id || ids.value;
  getData(codeName).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改字典数据";
  });
}
/** 提交按钮 */
function submitForm() {
  proxy.$refs["dataRef"].validate(valid => {
    if (valid) {
      if (form.value.id != undefined) {
        updateData(form.value).then(response => {
          useDictStore().removeDict(queryParams.value.codeTypeValue);
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addData(form.value).then(response => {
          useDictStore().removeDict(queryParams.value.codeTypeValue);
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}
/** 删除按钮操作 */
function handleDelete(row) {
  const codeNames = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除字典编码为"' + codeNames + '"的数据项？').then(function() {
    return delData(codeNames);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
    useDictStore().removeDict(queryParams.value.codeTypeValue);
  }).catch(() => {});
}
/** 导出按钮操作 */
function handleExport() {
  proxy.download("system/dict/data/export", {
    ...queryParams.value
  }, `dict_data_${new Date().getTime()}.xlsx`);
}

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


getTypes(route.params && route.params.dictId);
getTypeList();
</script>
