import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/orders/list',
    method: 'get',
    params: query
  })
}

export function fetchNews(id) {
  return request({
    url: '/orders/detail',
    method: 'get',
    params: { id }
  })
}

export function fetchPv(pv) {
  return request({
    url: '/orders/pv',
    method: 'get',
    params: { pv }
  })
}

export function createNews(data) {
  return request({
    url: '/orders/create',
    method: 'post',
    data
  })
}

export function updateNews(data) {
  return request({
    url: '/orders/update',
    method: 'post',
    data
  })
}
