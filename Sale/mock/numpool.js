import Mock from "mockjs";


export default [{
  url: '/numpool/list',
  method: 'get',
  response: _ => {
    return {
      code: 20000,
      data: Mock.mock({
        "num|16": [
          {
            "id|+1": 0,
            "phonenum": /[1][8][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]/,
          }
        ]
      })
    }
  }
}]
