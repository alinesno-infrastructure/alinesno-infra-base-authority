<template>
   <div class="app-container">
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="应用名称" prop="dbName">
                  <el-input v-model="queryParams.dbName" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item label="应用名称" prop="dbName">
                  <el-input v-model="queryParams['condition[dbName|like]']" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item>
                  <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                  <el-button icon="Refresh" @click="resetQuery">重置</el-button>
               </el-form-item>
            </el-form>

            <el-row :gutter="10" class="mb8">

               <el-col :span="1.5">
                  <el-button type="primary" plain icon="Plus" @click="handleAdd">新增</el-button>
               </el-col>
               <el-col :span="1.5">
                  <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate">修改</el-button>
               </el-col>
               <el-col :span="1.5">
                  <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete">删除</el-button>
               </el-col>

               <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
            </el-row>

            <el-table v-loading="loading" :data="AccountOnlineList" @selection-change="handleSelectionChange">
               <el-table-column type="selection" width="30" align="center" />

               <el-table-column label="头像" align="center" width="60" key="status">
                  <template #default="scope">
                     <div class="role-icon">
                        <img :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((scope.$index + 1)%5 + 40) + '.png'" />
                     </div>
                  </template>
               </el-table-column>

               <!-- 业务字段-->
               <el-table-column label="账号信息" align="left" width="230" key="dbDesc" prop="dbDesc" v-if="columns[1].visible">
                  <template #default="scope">
                     用户名: 平台管理员服务 <br/>
                     <div style="font-size: 13px;color: #a5a5a5;">
                        登陆账号: {{ scope.row.loginName }}
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="账号ID" align="center" key="userId" prop="userId">
                  <template #default="scope">
                     <el-button type="primary" text bg icon="CopyDocument" v-copyText="scope.row.userId">{{ scope.row.userId }}</el-button>
                  </template>
               </el-table-column>

               <el-table-column label="会话创建时间" align="left" key="nickName" prop="nickName" v-if="columns[2].visible" :show-overflow-tooltip="true" >
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.createTime ) }}</span> <br/>
                     <div style="font-size: 13px;color: #a5a5a5;">
                      2天22时16分
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="会话失效时间" align="left" key="dbType" prop="dbType" v-if="columns[3].visible" :show-overflow-tooltip="true" >
                  <template #default="scope">
                     <span>{{ parseTime(scope.row.createTime) }}</span> <br/>
                     <div style="font-size: 13px;color: #a5a5a5;">
                      3天12时16分
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="登陆数量" align="center" key="jdbcUrl" prop="jdbcUrl" v-if="columns[4].visible">
                  <template #default="scope">
                     <el-button type="primary" text bg icon="ChromeFilled"  @click="handleClientList(scope.row)">1个客户端</el-button>
                  </template>
               </el-table-column>
               <el-table-column label="登陆地址" align="left" width="150" key="hasStatus" v-if="columns[5].visible">
                  <template #default="scope">
                     湖南 长沙市
                     <div style="font-size: 13px;color: #a5a5a5;">
                      172.20.200.171
                     </div>
                  </template>
               </el-table-column>

               <!-- 操作字段  -->
               <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width">
                  <template #default="scope">
                     <el-tooltip content="踢下线" placement="top">
                        <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:AccountOnline:edit']">踢下线</el-button>
                     </el-tooltip>
                     <el-tooltip content="强制注销" placement="top">
                        <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:AccountOnline:remove']">强制注销</el-button>
                     </el-tooltip>
                  </template>
               </el-table-column>

            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

      <!-- 添加或修改应用配置对话框 -->
      <el-dialog :title="title" v-model="open" width="1000px" append-to-body>
         
         <el-table :data="tableData" style="width: 100%">

            <el-table-column type="index" label="序号" width="50" align="center" />

            <el-table-column prop="device" label="设备类型" width="150">
                  <template #default="scope">
                     <el-button type="primary" text bg icon="ChromeFilled">{{ scope.row.device }}</el-button>
                  </template>
            </el-table-column>
            <el-table-column prop="value" align="center" label="Token凭证" />

            <el-table-column label="会话失效时间" align="center" key="dbType" width="160" prop="dbType" v-if="columns[3].visible" :show-overflow-tooltip="true" >
               <template #default="scope">
                  <span>{{ parseTime(scope.row.createTime) }}</span> <br/>
               </template>
            </el-table-column>

            <!-- 操作字段  -->
            <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width">
               <template #default="scope">
                  <el-tooltip content="踢下线" placement="top">
                     <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:AccountOnline:edit']">踢下线</el-button>
                  </el-tooltip>
                  <el-tooltip content="强制注销" placement="top">
                     <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:AccountOnline:remove']">强制注销</el-button>
                  </el-tooltip>
               </template>
            </el-table-column>

         </el-table>

         <template #footer>
            <div class="dialog-footer">
               <!-- <el-button type="primary" @click="submitForm">确 定</el-button> -->
               <el-button @click="cancel">取 消</el-button>
            </div>
         </template>

      </el-dialog>

   </div>
</template>

<script setup name="AccountOnline">

import {
   listAccountOnline,
   delAccountOnline,
   getAccountOnline,
   updateAccountOnline,
   addAccountOnline
} from "@/api/monitor/online";

const router = useRouter();
const { proxy } = getCurrentInstance();

// 定义变量
const AccountOnlineList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);

const tableData = ref([
  {
    createTime: '1703826182819',
    device: 'PC',
    value: '3a94e641-d531-4826-8f52-61795a40ea94',
  },
  {
    createTime: '1703826182819',
    device: 'default-device',
    value: '3a94e641-d531-4826-8f52-61795a40ea94',
  },
]);

// 列显隐信息
const columns = ref([
   { key: 0, label: `应用名称`, visible: true },
   { key: 1, label: `应用描述`, visible: true },
   { key: 2, label: `表数据量`, visible: true },
   { key: 3, label: `类型`, visible: true },
   { key: 4, label: `应用地址`, visible: true },
   { key: 5, label: `状态`, visible: true },
   { key: 6, label: `更新时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      dbName: undefined,
      dbDesc: undefined
   },
   rules: {
      dbName: [{ required: true, message: "名称不能为空", trigger: "blur" }] , 
      jdbcUrl: [{ required: true, message: "连接不能为空", trigger: "blur" }],
      dbType: [{ required: true, message: "类型不能为空", trigger: "blur" }] , 
      dbUsername: [{ required: true , message: "用户名不能为空", trigger: "blur"}],
      dbPasswd: [{ required: true, message: "密码不能为空", trigger: "blur" }] , 
      dbDesc: [{ required: true, message: "备注不能为空", trigger: "blur" }] 
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listAccountOnline(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      AccountOnlineList.value = res.rows;
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
   queryParams.value.deptId = undefined;
   proxy.$refs.deptTreeRef.setCurrentKey(null);
   handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
   const AccountOnlineIds = row.id || ids.value;
   proxy.$modal.confirm('是否确认删除应用编号为"' + AccountOnlineIds + '"的数据项？').then(function () {
      return delAccountOnline(AccountOnlineIds);
   }).then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
   }).catch(() => { });
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
      deptId: undefined,
      AccountOnlineName: undefined,
      nickName: undefined,
      password: undefined,
      phonenumber: undefined,
      status: "0",
      remark: undefined,
   };
   proxy.resetForm("databaseRef");
};
/** 取消按钮 */
function cancel() {
   open.value = false;
   reset();
};

/** 新增按钮操作 */
function handleClientList() {
   reset();
   open.value = true;
   title.value = "登陆客户端列表";
};

/** 修改按钮操作 */
function handleUpdate(row) {
   reset();
   const AccountOnlineId = row.id || ids.value;
   getAccountOnline(AccountOnlineId).then(response => {
      form.value = response.data;
      open.value = true;
      title.value = "修改应用";
   });
};

/** 提交按钮 */
function submitForm() {
   proxy.$refs["databaseRef"].validate(valid => {
      if (valid) {
         if (form.value.AccountOnlineId != undefined) {
            updateAccountOnline(form.value).then(response => {
               proxy.$modal.msgSuccess("修改成功");
               open.value = false;
               getList();
            });
         } else {
            addAccountOnline(form.value).then(response => {
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
