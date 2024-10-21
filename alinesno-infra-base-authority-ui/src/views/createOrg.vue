<template>
  <div class="org-management">
    <el-container style="height: 100vh;">
      <el-main>
        <el-form :model="orgForm" label-position="top" ref="orgFormRef" label-width="80px" class="form-container join-form">
          <h2>组织信息设置</h2>
          <el-form-item label="Logo">
            <el-upload
              class="avatar-uploader"
              action="#"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="orgForm.logo" :src="orgForm.logo" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="名称" prop="name">
            <el-input v-model="orgForm.name" placeholder="请输入组织名称"></el-input>
          </el-form-item>
          <el-form-item label="描述" prop="description">
            <el-input type="textarea" v-model="orgForm.description" placeholder="请输入组织描述"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitOrgInfo">提交</el-button>
          </el-form-item>
        </el-form>

        <!-- <el-divider></el-divider> -->

        <!--
        <el-form :model="joinForm" label-position="top" ref="joinFormRef" label-width="80px" class="form-container">
          <h2>加入现有组织</h2>
          <el-form-item label="组织ID" prop="id">
            <el-input v-model="joinForm.id" placeholder="请输入组织ID"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="joinExistingOrg">加入</el-button>
          </el-form-item>
        </el-form>
        -->

      </el-main>
    </el-container>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus';

const orgForm = ref({
  logo: '',
  name: '',
  description: ''
});

const joinForm = ref({
  id: ''
});

const handleAvatarSuccess = (res, file) => {
  orgForm.value.logo = URL.createObjectURL(file.raw);
};

const beforeAvatarUpload = (file) => {
  const isJPG = file.type === 'image/jpeg';
  const isLt2M = file.size / 1024 / 1024 < 2;

  if (!isJPG) {
    ElMessage.error('上传头像图片只能是 JPG 格式!');
  }
  if (!isLt2M) {
    ElMessage.error('上传头像图片大小不能超过 2MB!');
  }

  return isJPG && isLt2M;
};

const submitOrgInfo = () => {
  // 这里添加处理组织信息的逻辑
  console.log(orgForm.value);
  ElMessage.success('组织信息提交成功！');
};

const joinExistingOrg = () => {
  // 这里添加处理加入现有组织的逻辑
  console.log(joinForm.value);
  ElMessage.success(`正在尝试加入组织 ID: ${joinForm.value.id}`);
};
</script>

<style scoped lang="scss">
.org-management {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: url('https://example.com/your-background-image.jpg') no-repeat center center fixed; /* 替换为您的背景图片 */
  background-size: cover;
}

.form-container {
  width: 400px; /* 调整宽度以适应您的需求 */
  padding: 20px;
  margin:auto;
  background-color: rgba(255, 255, 255, 0.9); /* 半透明背景 */
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.join-form {
  margin-top: 100px;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>