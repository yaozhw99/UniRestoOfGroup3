import Mock from 'mockjs'

const  List=Mock.mock({
  "result":1,
  "data|4":[
    {
      "Brand|1":['冰激凌','沃派','低消','流量王'],
      "saleBy|9600-10000":9900,
      "saleLj|190000-250000":200000,
      "activeBy|9000-9600":9200,
      "activeLj|160000-190000":180000
    }
  ]
});

export default [
  {
    url: '/report',
    type: 'get',
    response: config => {

    return {
      code: 20000,
      data: List.data
    }
  }
}
]

