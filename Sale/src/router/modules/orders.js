/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'

const ordersRouter = {
  path: '/orders',
  component: Layout,
  redirect: 'noRedirect',
  name: 'orders',
  meta: {
    title: '订单管理',
    icon: 'table'
  },
  children: [
    {
      path: 'orderslist',
      name:'orderslist',
      component: () => import('@/views/orders/orderlist'),
    // name: '订单列表',
      meta: { title: '订单列表', icon: 'list'}
    },
    {
      path: 'newOrder',
        component: () => import('@/views/orders/newOrder'),
      name: 'CreateOrder',
      meta: { title: '订单新建',icon: 'edit' }
    },
    {
      path: 'orderlist2',
      component: () => import('@/views/orders/OrderList2'),
      name: 'OrderList2',
      meta: { title: '订单处理', icon: 'edit'}
    }
    ]
}

export default ordersRouter
