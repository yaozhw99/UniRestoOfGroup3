import request from '@/utils/request'

export function createUser(data) {
  return request({
    url: '/order/create',
    method: 'post',
    data
  })
}
