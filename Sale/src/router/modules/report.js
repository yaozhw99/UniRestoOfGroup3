/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout';

const reportRouter = {
path: '/report',
  component: Layout,
  redirect: 'noRedirect',
  name: 'Report',
  meta: {
  title: '图表',
    icon: 'chart'
},
  children: [
    {
      path: 'reportchart',
      component: () => import('@/views/report/chart'),
    name: 'ReportChart',
  meta: { title: '看板图表', noCache: true }
}
]
}

export default reportRouter
