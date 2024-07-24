<template>
   <div class="app-container">
    <div class="label-title">
      <div class="tip">向外广播用户数据</div>
      <div class="sub-tip">向外服务同步数据，发送到指定的URL地址</div>
    </div>
    <div class="form-container" >
      <el-form
        :model="form"
        :rules="rules"
        v-loading="loading"
        ref="form"
        label-width="180px"
        class="demo-form"
      >

        <el-form-item label="向外广播服务" prop="themeCode">
          <el-input type="input" show-word-limit v-model="form.themeCode" readonly placeholder="请输入主题代码">
            <el-button slot="append" @click="configTheme()" icon="el-icon-edit">配置品牌</el-button>
          </el-input>
        </el-form-item>

        <el-form-item label="允许向外广播数据">
          <el-switch v-model="form.enableSociety"
            :active-value="1"
            :inactive-value="0"
          ></el-switch>
        </el-form-item>

        <el-form-item label="广播规则" prop="status">
            <el-radio-group v-model="form.status">
              <el-radio
                  v-for="dict in sys_normal_disable"
                  :key="dict.value"
                  :label="dict.value"
              >{{ dict.label }}</el-radio>
            </el-radio-group>
        </el-form-item>

        <el-form-item label="同步广播地址" prop="defaultIndex">
          <el-input type="input" maxlength="500" show-word-limit v-model="form.defaultIndex" placeholder="请输入默认首页"></el-input>
        </el-form-item>

        <el-form-item label="异步广播地址" prop="defaultIndex">
          <el-input type="input" maxlength="500" show-word-limit v-model="form.defaultIndex" placeholder="请输入默认首页"></el-input>
        </el-form-item>

        <el-form-item label="加密数据">
          <el-switch v-model="form.enableValidate"
            :active-value="1"
            :inactive-value="0"
          > 使用SM4算法加密广播的数据 </el-switch>
        </el-form-item>

        <br/>

        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">
            保存
          </el-button>
          <el-button @click="resetForm">
            重置
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>

const { proxy } = getCurrentInstance();
const { sys_normal_disable } = proxy.useDict("sys_normal_disable") ; 

const theme = ref(null) ;
const form = ref({
    themeCode: null , 
    loginStyle:'1' ,
    enableSociety: '1' ,
    enableFindPwd: '1' ,
    logoImg: '' ,
    lockTime: 250 ,
    errorCount: 5,
    defaultIndex: '' , 
    enableValidate: '1',
  }) ;

// 表单参数
const rules = ref({
    logoTitle: [
      { required: true, message: "请输入登陆标题", trigger: "blur" },
    ],
    logoTitle: [
      { required: true, message: "请输入登陆标题", trigger: "blur" },
    ],
    loginDescription: [
      { required: true, message: "请输入登陆描述", trigger: "blur" },
    ],
    loginLogo: [
      { required: true, message: "请至少上传一张Logo图", trigger: "blur" },
    ],
    logoBackgroun: [
      { required: true, message: "请至少上传一张背景图", trigger: "blur" },
    ],
    defaultIndex: [
      { required: true, message: "请输入默认主页", trigger: "blur" },
      { type: 'url',message: "请输入正确的链接地址",trigger: 'blur'},
    ],
  }) ;

// 遮罩层
const loading = ref(false);

</script>

<style scoped lang="scss">
  .form-container {
    max-width: 960px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 20px;
  }

  .label-title {
    text-align: center;
    max-width: 960px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 10px;

    .tip {
      padding-bottom: 10px;
      font-size: 26px;
      font-weight: bold;
    }

    .sub-tip {
      font-size: 13px;
      text-align: center;
      padding: 10px;
    }
  }

  .image{
    width:100%;
    height: 120px ;
  }

  .select-card {
    border: 1px solid rgb(0, 91, 212) ;
  }
</style>


