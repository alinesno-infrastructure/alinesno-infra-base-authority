<template>
   <el-form ref="userRef" :model="user" :rules="rules" label-width="80px" size="large">
      <el-form-item label="用户昵称" prop="name">
         <el-input v-model="user.name" maxlength="30" />
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
         <el-input v-model="user.phone" maxlength="11" />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
         <el-input v-model="user.email" maxlength="50" />
      </el-form-item>
      <el-form-item label="性别">
         <el-radio-group v-model="user.sex">
            <el-radio label="0">男</el-radio>
            <el-radio label="1">女</el-radio>
         </el-radio-group>
      </el-form-item>
      <el-form-item>
      <el-button type="primary" @click="submit">保存</el-button>
      <el-button type="danger" @click="close">关闭</el-button>
      </el-form-item>
   </el-form>
</template>

<script setup>
import { updateUserProfile } from "@/api/system/user";

const props = defineProps({
  user: {
    type: Object
  }
});

const { proxy } = getCurrentInstance();

const rules = ref({
  name: [{ required: true, message: "用户昵称不能为空", trigger: "blur" }],
  email: [{ required: true, message: "邮箱地址不能为空", trigger: "blur" }, { type: "email", message: "请输入正确的邮箱地址", trigger: ["blur", "change"] }],
  phone: [{ required: true, message: "手机号码不能为空", trigger: "blur" }, { pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur" }],
});

/** 提交按钮 */
function submit() {
  proxy.$refs.userRef.validate(valid => {
    if (valid) {
      props.user.avatarPath = '';
      updateUserProfile(props.user).then(response => {
        proxy.$modal.msgSuccess("修改成功");
      });
    }
  });
};
/** 关闭按钮 */
function close() {
  proxy.$tab.closePage();
};
</script>
