import Layout from '@/layout'

const rtableRouter = {
  path: '/report/table',
  component: Layout,
  redirect: 'noRedirect',
  name: 'RTable',
  meta: {
    title: '报表管理',
    icon: 'chart'
  },
  children: [
    {
      path: 'list',
      component:()=> import('@/views/report/table/ProductTable'),
      name: 'ProductTable',
      meta: { title: '产品报表', noCache: true }
},
{
      path: 'chart',
      component: () => import('@/views/report/table/SaleTable'),
      name: 'SaleTable',
      meta: { title: '销售报表', noCache: true }
}
]
}

export default rtableRouter
