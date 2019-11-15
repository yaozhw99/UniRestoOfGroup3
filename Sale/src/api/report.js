import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/report',
    method: 'get',
    params: query
  })
}

export function getList(query) {
  return request({
    url: '/report1',
    method: 'get',
    params: query
  })
}
