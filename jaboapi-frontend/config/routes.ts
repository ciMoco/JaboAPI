export default [
  { name: '主页', icon: 'smile', path: '/', component: './Index' },
  {
    name: '查看接口',
    path: '/interface_info/:id',
    component: './InterfaceInfo',
    hideInMenu: true,
  },
  {
    name: '个人中心',
    path: '/user/center',
    component: './User/Center',
    hideInMenu: true,
  },
  {
    path: '/user',
    layout: false,
    routes: [
      { name: '登录', path: '/user/login', component: './User/Login' },
      { name: '注册', path: '/user/register', component: './User/Register' },
    ],
  },
  {
    path: '/admin',
    icon: 'crown',
    name: '管理页',
    access: 'canAdmin',
    routes: [
      { path: '/admin', redirect: '/admin/interface_analysis' },
      { name: '用户管理', path: '/admin/user', component: './Admin/User' },
      {
        name: '接口管理',
        path: '/admin/interface_info',
        component: './Admin/InterfaceInfo',
      },
      {
        name: '接口分析',
        path: '/admin/interface_analysis',
        component: './Admin/InterfaceAnalysis',
      },
    ],
  },
  { path: '*', layout: false, component: './404' },
];
