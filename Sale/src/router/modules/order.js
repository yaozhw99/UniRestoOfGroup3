/** When your routing table is too long, you can split it into small modules**/

import Layout from '@/layout'
import Order from '../../views/order/index'

const orderRouter = {
  path: '/order',
  component: () => import('@/views/order'),
  hidden: true
}

export default orderRouter
