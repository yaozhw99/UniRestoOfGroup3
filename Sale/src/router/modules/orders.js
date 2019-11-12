/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const ordersRouter = {
  path: '/orders',
  component: Layout,
  redirect: 'noRedirect',
  name: 'orders',
  meta: {
    title: '订单管理',
    icon: 'chart'
  },
  children: [
    {
      path: 'list',
      component: () => import('@/views/orders/list'),
    name: '订单列表',
  meta: { title: '部门列表', noCache: true }
},
{
  path: 'chart',
    component: () => import('@/views/orders/create'),
  name: 'DeptChart',
  meta: { title: '图标展示', noCache: true }
}
]
}

export default ordersRouter
