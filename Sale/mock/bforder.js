import Mock from 'mockjs'

export default [
  {
    url: '/order/create',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success',
        orderId: Mock.mock({ 'orderId|100000-299999': 123456 }).orderId
      }
    }
  }
]

