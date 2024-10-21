import { createWebHistory, createRouter } from 'vue-router'
/* Layout */
//import Layout from '@/layout/SaaSLayout'
import Layout from '@/layout'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * roles: ['admin', 'common']       // 访问路由的角色权限
 * permissions: ['a:a:a', 'b:b:b']  // 访问路由的菜单权限
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },
  {
    path: '/sso/login',
    component: () => import('@/views/loginSso'),
    hidden: true
  },
  {
    path: "/:pathMatch(.*)*",
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/createOrg',
    component: () => import('@/views/createOrg'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: '/index',
    hidden: true,
    children: [
      {
        path: '/index',
        component: () => import('@/views/index'),
        name: '/index',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      },
      {
        path: '/dashboard/smartService',
        component: () => import('@/views/smartService'),
        name: '/dashboard/smartService',
        meta: { title: '智能客服', icon: 'dashboard', affix: true }
      },
      // {
      //   path: '/dashboard/serviceList',
      //   component: () => import('@/views/serviceList'),
      //   name: '/dashboard/serviceList',
      //   meta: { title: '服务列表', icon: 'dashboard', affix: true }
      // },
      {
        path: '/dashboard/suportTechnique',
        component: () => import('@/views/suportTechnique'),
        name: '/dashboard/suportTechnique',
        meta: { title: '支持管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/dashboard/learnPanel',
        component: () => import('@/views/learnPanel'),
        name: '/dashboard/learnPanel',
        meta: { title: '学习手册', icon: 'dashboard', affix: true }
      },

      // ->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      // 这是动态路由 加上：/:id
      {
        path: "/application/system/menu/:projectId",
        name: "/application/system/menu",
        meta: { title: "菜单管理" },
        component: () => import('@/views/system/menu/index'),
      },
      {
        path: "/system/dict-data/index/:dictId",
        name: "/system/dict-data/index",
        meta: { title: "字典管理" },
        component: () => import('@/views/system/dict/data'),
      },
      // {
      //   path: '/createGateway',
      //   name: 'createGateway',
      //   hidden: true,
      //   component: () => import('@/views/gateway/createGateway'),
      //   meta: { title: '创建网关服务', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/gatewayTopology',
      //   name: 'gatewayTopology',
      //   hidden: true,
      //   component: () => import('@/views/gateway/gatewayTopology'),
      //   meta: { title: '网关路由拓扑结构', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/createClient',
      //   name: 'createClient',
      //   hidden: true,
      //   component: () => import('@/views/gateway/createClient'),
      //   meta: { title: '创建客户端', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/addGatewayClient',
      //   name: 'addGatewayClient',
      //   hidden: true,
      //   component: () => import('@/views/gateway/addGatewayClient'),
      //   meta: { title: '添加网关客户端', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/addClientGateway',
      //   name: 'addClientGateway',
      //   hidden: true,
      //   component: () => import('@/views/gateway/addClientGateway'),
      //   meta: { title: '添加客户端网关', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/addGroovyScript',
      //   name: 'addGroovyScript',
      //   hidden: true,
      //   component: () => import('@/views/gateway/addGroovyScript'),
      //   meta: { title: '添加规则组件', icon: 'dashboard', affix: true }
      // },
      // {
      //   path: '/createBalanced',
      //   name: 'createBalanced',
      //   hidden: true,
      //   component: () => import('@/views/gateway/createBalanced'),
      //   meta: { title: '创建负载均衡', icon: 'dashboard', affix: true }
      // },
      {
        path: '/system/dept/index',
        name: 'system/dept/index',
        hidden: true,
        component: () => import('@/views/system/dept'),
        meta: { title: '部门管理', icon: 'dashboard', affix: true }
      },
      // {
      // path: '/system/group/index',
      // name: 'system/group/index',
      // hidden: true,
      // component: () => import('@/views/system/group'),
      // meta: { title: '机构管理', icon: 'dashboard', affix: true }
      // },
      {
        path: '/system/user/index',
        name: 'system/user/index',
        hidden: true,
        component: () => import('@/views/system/user'),
        meta: { title: '用户管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/system/role/index',
        name: 'system/role/index',
        hidden: true,
        component: () => import('@/views/system/role'),
        meta: { title: '角色管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/system/post/index',
        name: 'system/post/index',
        hidden: true,
        component: () => import('@/views/system/post'),
        meta: { title: '岗位管理', icon: 'dashboard', affix: true }
      },
      // {
      // path: '/system/group/index',
      // name: 'system/group/index',
      // hidden: true,
      // component: () => import('@/views/system/group'),
      // meta: { title: '机构管理', icon: 'dashboard', affix: true }
      // },
      {
        path: '/system/menu/index',
        name: 'system/menu/index',
        hidden: true,
        component: () => import('@/views/system/menu'),
        meta: { title: '菜单管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/system/dict/index',
        name: 'system/dict/index',
        hidden: true,
        component: () => import('@/views/system/dict'),
        meta: { title: '字典管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/system/config/index',
        name: 'system/config/index',
        hidden: true,
        component: () => import('@/views/system/config'),
        meta: { title: '参数设置', icon: 'dashboard', affix: true }
      },
      {
        path: '/system/notice/index',
        name: 'system/notice/index',
        hidden: true,
        component: () => import('@/views/system/notice'),
        meta: { title: '通知公告', icon: 'dashboard', affix: true }
      },
      {
        path: '/log/operlog/index',
        name: 'log/operlog/index',
        hidden: true,
        component: () => import('@/views/monitor/operlog'),
        meta: { title: '操作日志', icon: 'dashboard', affix: true }
      },
      {
        path: '/log/logininfor/index',
        name: 'log/logininfor/index',
        hidden: true,
        component: () => import('@/views/monitor/logininfor'),
        meta: { title: '登录日志', icon: 'dashboard', affix: true }
      },
      {
        path: '/monitor/online/index',
        name: 'monitor/online/index',
        hidden: true,
        component: () => import('@/views/monitor/online'),
        meta: { title: '在线用户', icon: 'dashboard', affix: true }
      },
      {
        path: '/monitor/cache/index',
        name: 'monitor/cache/index',
        hidden: true,
        component: () => import('@/views/monitor/cache'),
        meta: { title: '缓存监控', icon: 'dashboard', affix: true }
      },
      {
        path: '/log/apilog/index',
        name: 'log/apilog/index',
        hidden: true,
        component: () => import('@/views/monitor/apilog'),
        meta: { title: '接口日志', icon: 'dashboard', affix: true }
      },
      // {
      // path: '/monitor/job/index',
      // name: 'monitor/job/index',
      // hidden: true,
      // component: () => import('@/views/monitor/job'),
      // meta: { title: '定时任务', icon: 'dashboard', affix: true }
      // },
      {
        path: '/monitor/server/index',
        name: 'monitor/server/index',
        hidden: true,
        component: () => import('@/views/monitor/server'),
        meta: { title: '服务监控', icon: 'dashboard', affix: true }
      },
      {
        path: '/monitor/cache/list',
        name: 'monitor/cache/list',
        hidden: true,
        component: () => import('@/views/monitor/cachelist'),
        meta: { title: '缓存列表', icon: 'dashboard', affix: true }
      },
      // {
      // path: '/tool/build/index',
      // name: 'tool/build/index',
      // hidden: true,
      // component: () => import('@/views/tool/build'),
      // meta: { title: '系统主题', icon: 'dashboard', affix: true }
      // },
      // {
      // path: '/tool/swagger/index',
      // name: 'tool/swagger/index',
      // hidden: true,
      // component: () => import('@/views/tool/swagger'),
      // meta: { title: '登陆主题', icon: 'dashboard', affix: true }
      // },

    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'profile',
        component: () => import('@/views/system/user/profile/index'),
        name: 'Profile',
        meta: { title: '个人中心', icon: 'user' }
      }
    ]
  }
]

// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  },
});

export default router;
