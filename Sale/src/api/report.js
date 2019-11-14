import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/report',
    method: 'get',
    params: query
  })
}

