<template>
    <el-container class="login-container" v-loading="initLoading">
        <!-- 头部 -->
        <HeaderPanel :identityInfoPanel="identityInfoPanel" />

        <el-main class="main-box">
            <div class="register-box">
                <div class="register-info">
                    <div class="title">
                        <img :src="identityInfoPanel.logo" alt="">
                        注册AIP平台账号
                    </div>
                    <div class="description">
                        <span>欢迎进入</span>
                        <span>创建你的账户</span>
                    </div>
                </div>

                <div class="register-container">
                    <el-form :model="registerForm" 
                        ref="registerFormRef" 
                        class="register-form" 
                        size="large"
                        :label-position="'right'"
                        label-width="0px" 
                        :rules="rules">

                        <el-form-item prop="phone">
                            <el-input v-model="registerForm.phone" placeholder="请输入手机号"></el-input>
                        </el-form-item>
                        <el-form-item prop="password">
                            <el-input v-model="registerForm.password" type="password" show-password placeholder="请输入密码"></el-input>
                        </el-form-item>
                        <el-form-item prop="confirmPassword">
                            <el-input v-model="registerForm.confirmPassword" type="password"
                                show-password
                                placeholder="请再次输入密码"></el-input>
                        </el-form-item>

                        <!-- 注册协议勾选-->
                         <el-form-item label="">
                            <el-checkbox v-model="registerForm.agree" name="agree" required>我已阅读并同意<a href="">《用户注册协议》</a></el-checkbox>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" size="large" style="width:100%" @click="handleRegister">注册</el-button>
                        </el-form-item>

                    </el-form>

                    <div class="return-login">
                        <router-link :to="'/login?redirect=' + route.query.redirect">
                            返回登陆系统？
                        </router-link>
                    </div>

                </div>
            </div>
        </el-main>

        <el-footer class="footer">
            <div class="copyright-text">© {{ identityInfoPanel.copyrightYear }} {{ identityInfoPanel.copyrightLabel }}
            </div>
        </el-footer>
    </el-container>
</template>

<script setup>
import { ref, onMounted, reactive } from 'vue';
import { ElMessage, ElForm } from 'element-plus';
import { useRoute, useRouter } from 'vue-router';

import HeaderPanel from '@/views/common/header';
import useIdentityInfoStore from '@/store/modules/info';

import { register } from '@/api/login';

const initLoading = ref(false);
const identityInfoStore = useIdentityInfoStore();

const route = useRoute();
const router = useRouter();

// 系统信息
const identityInfoPanel = ref({
    systemName: "",
    bannerInfo: "",
    logo: "http://data.linesno.com/logo_2.png",
    version: "",
    copyrightYear: "",
    copyrightLabel: "",
    portalSite: ""
});

// 注册表单
const registerForm = reactive({
    phone: '',
    password: '',
    confirmPassword: ''
});

const registerFormRef = ref();

// 表单验证规则
const rules = {
    phone: [
        {
            required: true,
            message: '请输入手机号',
            trigger: 'blur'
        },
        {
            pattern: /^1[3-9]\d{9}$/,
            message: '请输入有效的手机号',
            trigger: 'blur'
        }
    ],
    password: [
        {
            required: true,
            message: '请输入密码',
            trigger: 'blur'
        }
    ],
    confirmPassword: [
        {
            required: true,
            message: '请再次输入密码',
            trigger: 'blur'
        },
        {
            validator: (rule, value, callback) => {
                if (value !== registerForm.password) {
                    callback(new Error('两次输入的密码不一致'));
                } else {
                    callback();
                }
            },
            trigger: 'blur'
        }
    ]
};

// 获取到系统信息，即当前登陆界面信息
function getIdentityInfo() {
    initLoading.value = true;
    identityInfoStore.getIdentityInfo().then(res => {
        initLoading.value = false;
        identityInfoPanel.value = res.data;
        console.log('identityInfoPanel = ' + identityInfoPanel.value.systemName);
    }).catch((err) => {
        initLoading.value = false;
    });
}

// 注册处理
function handleRegister() {
    registerFormRef.value.validate((valid) => {
        if (valid) {
            register(registerForm).then(response => {
                ElMessage.success('注册成功');
                router.push({ 
                    path: '/login' , 
                    query: { redirect: route.query.redirect }
                });
            })
        } 
    });
}

onMounted(() => {
    initLoading.value = true;
    getIdentityInfo();
});
</script>

<style scoped lang="scss">
.login-container {
    .main-box {
        background-color: #fafafa;
        padding: 40px 0;

       .register-box {
            border-radius: 8px;
            max-height: 700px;
            border: 1px solid #e4e7ed;
            background-color: #fff;
            padding: 20px;
            padding-top: 60px;
            width: 500px;
            margin: 0 auto;

           .register-info {
                display: flex;
                flex-direction: column;
                gap: 15px;
                margin-bottom: 20px;
                padding: 10px;
                text-align: left;

               .title {
                    font-size: 25px;
                    display: flex;
                    gap: 10px;
                    align-items: center;
                    margin-bottom: 15px;

                    img {
                        width: 35px;
                    }
                }

               .description {
                    font-size: 14px;
                    display: flex;
                    flex-direction: column;
                    gap: 10px;
                    color: #555;
                }
            }
        }
    }

   .footer {
        background: rgb(250, 250, 250);
        bottom: 0px;
        width: 100%;
        height: 45px;

       .copyright-text {
            text-align: center;
        }
    }

   .register-container {
       .register-form {
            margin: 0 auto;
            width: 100%;
        }
    }

   .return-login {
        font-size: 13px;
        text-align: right;
        color: #666;
    }
}
</style>