<template>
     
  <div class="app-container">
    <!--查询项-->

    <el-select v-model="saleQuery.months">
      <el-option v-for="item in months" :key="item.key" :value="item.key" :label="item.value"></el-option>
    </el-select>
    <el-select v-model="saleQuery.city">
      <el-option v-for="item in city" :key="item.key" :value="item.key" :label="item.value"></el-option>
    </el-select>
    <el-button @click="getPageData">
      查询
    </el-button>

    <!--表数据-->
    <el-table :data="pageData">
      <el-table-column prop="cycleid" label="月份"></el-table-column>
      <el-table-column prop="epname" label="地市"></el-table-column>
      <el-table-column prop="saleBy" label="当月销售量"></el-table-column>
      <el-table-column prop="saleLj" label="累计销售量"></el-table-column>
      <el-table-column prop="activeBy" label="当月激活量"></el-table-column>
      <el-table-column prop="activeLj" label="累计激活量"></el-table-column>
      <el-table-column prop="activeHb" label="激活环比"></el-table-column>
      <el-table-column prop="activeZb" label="激活占比"></el-table-column>
    </el-table>
  </div>
</template>
<script>
  import mock from 'mockjs'

  export default {
    data() {
      return {
//        selectMonth: '',
        months: [
          {key: '',value:"<-选择全部->"},
          {key: '201911', value: "201911"},
          {key: '201910', value: "201910"},
          {key: '201909', value: "201909"},
          {key: '201908', value: "201908"},
          {key: '201907', value: "201907"},
          {key: '201906', value: "201906"},
          {key: '201905', value: "201905"},
          {key: '201904', value: "201904"},
          {key: '201903', value: "201903"},
          {key: '201902', value: "201902"},
          {key: '201901', value: "201901"}
        ],
        city: [
          {key: '',value:"<-选择全部->"},
          {key: '广州市', value: "广州市"},
          {key: '深圳市', value: "深圳市"},
          {key: '东莞市', value: "东莞市"},
          {key: '佛山市', value: "佛山市"},
          {key: '珠海市', value: "珠海市"},
          {key: '中山市', value: "中山市"},
          {key: '江门市', value: "江门市"},
          {key: '惠州市', value: "惠州市"},
          {key: '揭阳市', value: "揭阳市"},
          {key: '汕头市', value: "汕头市"},
          {key: '湛江市', value: "湛江市"},
          {key: '清远市', value: "清远市"},
          {key: '肇庆市', value: "肇庆市"},
          {key: '云浮市', value: "云浮市"},
          {key: '韶关市', value: "韶关市"},
          {key: '梅州市', value: "梅州市"},
          {key: '河源市', value: "河源市"},
          {key: '茂名市', value: "茂名市"},
          {key: '阳江市', value: "阳江市"},
          {key: '汕尾市', value: "汕尾市"},
          {key: '潮州市', value: "潮州市"}
        ],
        //查询条件
        saleQuery: {
          months: '201911',
          city: ''
        },
        //当前页的部门数据
        pageData: [],
        //全部部门数据
        saleData: [],
        saleData1: []
      }
    },
    mounted() {
//      let rs = [];
      let citys = ["广州市", "深圳市", "东莞市", "佛山市", "珠海市", "中山市", "江门市", "惠州市", "揭阳市", "汕头市", "湛江市", "清远市", "肇庆市", "云浮市", "韶关市", "梅州市", "河源市", "茂名市", "阳江市", "汕尾市", "潮州市"];
      for (let i = 1; i < 12; i++) {
        for (let j = 0; j < citys.length; j++) {
          let mdata = mock.mock({
            "epname": citys[j],
            "saleBy|9600-10000": 9900,
            "saleLj|190000-250000": 200000,
            "activeBy|9000-9600": 9200,
            "activeSy|8000-12000": 9000,
            "activeLj|160000-190000": 180000
          });
          if (i <= 9)
            mdata.cycleid = "20190" + i;
          else
            mdata.cycleid = "2019" + i;
          mdata.activeHb = Math.round((mdata.activeBy - mdata.activeSy) / mdata.activeSy * 100, 2) + '%';
          mdata.activeZb = Math.round(mdata.activeBy / mdata.saleBy * 100, 2) + '%';
          this.saleData1.push(mdata)
        }
      }
//      this.saleQuery.months='201911';
      this.getPageData();
    },
    methods: {
      getPageData: function () {
        let {cycleid, epname} = this.saleData1;
        let filterData = [];
        filterData = this.saleData1.filter((item) => {
          if ((this.saleQuery.months&&this.saleQuery.city))
          {
            if (item.cycleid == this.saleQuery.months&&item.epname == this.saleQuery.city)
              return true
          }
          else if(this.saleQuery.months||this.saleQuery.city)
          {
            if (item.cycleid == this.saleQuery.months)
              return true
            if  (item.epname == this.saleQuery.city)
              return true
          }
          else  if ((this.saleQuery.months&&this.saleQuery.city)==0)
          {
            return true
          }
        })
        this.pageData = filterData
      }
    }
  }
</script>
<style>

</style>
