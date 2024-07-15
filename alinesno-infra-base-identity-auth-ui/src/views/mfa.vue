<template>
  <div class="totp-container">
    <img src="https://portal.infra.linesno.com/logo.png" alt="Brand Logo" class="brand-logo">
    <h2>你好，<span style="font-size:1rem;color:#3b5998"><i class="fa-solid fa-user-shield"></i> {{ loginName }}</span>
        <br>AIP MFA 登陆确认
    </h2>
    <div class="totp-input">
      <input type="number" maxlength="1" v-for="n in 6" :key="n" v-model="totp[n-1]" @input="moveFocus($event, n-1)">
    </div>
    <button size="large" @click="confirmLogin" class="confirm-button">确认登陆</button>
  </div>
</template>

<script setup>

import { mfaVerify } from "@/api/login";

import { reactive , ref } from 'vue';

const router = useRouter();

const totp = ref(Array(6).fill(''));

// TODO 从微信登陆中获取手机号
const loginName = reactive(router.currentRoute.value.query.loginName) 

const moveFocus = (event, index) => {
  const input = event.target;
  if (input.value.length === input.maxLength && index < 5) {
    input.nextElementSibling.focus();
  }
};

const confirmLogin = () => {
  // 确认登录逻辑
  const totpCode = totp.value.join('');
  alert(`TOTP Code: ${totpCode}`);

  mfaVerify({
    mfaCode: totpCode ,
    loginName: loginName
  }).then(res => {

    // TODO 待处理逻辑
  })

};
</script>

<style scoped lang="scss">
.totp-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: top;
  height: 100vh;
  font-family: Arial, sans-serif;
  text-align: center;
  padding-top: 10%;
}

.brand-logo {
  width: 80px;
  height: 80px;
  margin-bottom: 20px;
}

h2 {
  margin-bottom: 00px;
  text-align: left;
  width: 100%;
  font-size: 1.3rem;
  line-height: 2.5rem;
  max-width: 90%;
}

.totp-input {
  display: flex;
  gap: 10px;
  margin-top: 40px;
  margin-bottom: 40px;
}

.totp-input input {
  width: 50px;
  height: 50px;
  font-size: 24px;
  text-align: center;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.confirm-button {
  width: 100%;
  max-width: 90%;
  padding: 13px;
  font-size: 16px;
  background-color: #3b5998 ;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.confirm-button:hover {
  background-color: #3b5998 ;
}
</style>
