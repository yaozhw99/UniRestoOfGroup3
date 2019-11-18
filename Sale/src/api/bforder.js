import request from '@/utils/request'
import getServerDomain from '@/utils/comm'

export function createUser(data) {
  return request({
    url: 'http://localhost:8080/order/addOrder',
    method: 'post',
    data
  })
}

export function getOrderInfo(id) {
  return request({
    url: 'http://localhost:8080/order/getOrderInfo',
    method: 'get',
    params: { id }
  })
}

export function getOrderdealLog(orderId) {
  return request({
    url: 'http://localhost:8080/order/getOrderdealLog',
    method: 'get',
    params: { orderId }
  })
}
