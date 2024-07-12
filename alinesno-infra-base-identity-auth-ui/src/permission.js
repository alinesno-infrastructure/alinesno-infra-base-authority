import router from './router'
import NProgress from 'nprogress'
import { getSaToken } from '@/utils/auth'
import 'nprogress/nprogress.css'

NProgress.configure({ showSpinner: false });

const whiteList = ['/login', '/register'];

router.beforeEach((to, from, next) => {
  NProgress.start()

  if (!getSaToken()) {
    // 没有token
    if (whiteList.indexOf(to.path) !== -1) {
      // 在免登录白名单，直接进入
      next()
    } else {
      next(`/login?redirect=${to.fullPath}`) // 否则全部重定向到登录页
      NProgress.done()
    }
  }else{
    next()
  }
})

router.afterEach(() => {
  NProgress.done()
})
