import request from '@/utils/request'

export function Numpool(){
  return request({
    url:'/numpool/list',
    method:'get'
  })
}
