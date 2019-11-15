<template>
     
  <div class="app-container">
    <!--查询项-->

    <el-select v-model="saleQuery.months">
      <el-option v-for="item in nomths" :key="item.key" :value="item.key" :label="item.value"></el-option>
    </el-select>
    <el-select v-model="saleQuery.city">
      <el-option v-for="item in city" :key="item.key" :value="item.key" :label="item.value"></el-option>
    </el-select>
    <el-button @click="getPageData">
      Search
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
        selectMonth:'',
        nomths: [
          {key: 201910, value: "201910"},
          {key: 201909, value: "201909"},
          {key: 201908, value: "201908"},
          {key: 201907, value: "201907"},
          {key: 201906, value: "201906"},
          {key: 201905, value: "201905"},
          {key: 201904, value: "201904"},
          {key: 201903, value: "201903"},
          {key: 201902, value: "201902"},
          {key: 201901, value: "201901"},
          {key: 201812, value: "201812"},
          {key: 201811, value: "201811"}
        ],
        city: [
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
          nomths: 201910,
          city: ''
        },
        //当前页的部门数据
        pageData: [],
        //全部部门数据
        saleData: []
      }
    },
    mounted() {
      let mdata = mock.mock({
        "result": 1,
        "data|21": [{
          "cycleid|+1": ['201811', '201812', '201901', '201902', '201903', '201904', '201905', '201906', '201907', '201908', '201909', '201910'],
          "epname|+1": ["广州市", "深圳市", "东莞市", "佛山市", "珠海市", "中山市", "江门市", "惠州市", "揭阳市", "汕头市", "湛江市", "清远市", "肇庆市", "云浮市", "韶关市", "梅州市", "河源市", "茂名市", "阳江市", "汕尾市", "潮州市"],
          "saleBy|9600-10000": 9900,
          "saleLj|190000-250000": 200000,
          "activeBy|9000-9600": 9200,
          "activeSy|8000-12000": 9000,
          "activeLj|160000-190000": 180000
        }
        ]
      });
      for (let i = 0; i < mdata.data.length; i++) {
        let res = mdata.data[i];
        res.activeHb = Math.round((res.activeBy - res.activeSy) / res.activeSy * 100, 2) + '%';
        res.activeZb = Math.round(res.activeBy / res.saleBy * 100, 2) + '%';
      }
      this.saleData = mdata.data;
      this.getPageData();
    },

    methods: {
      getPageData: function () {
        let {cycleid} = this.saleData;
        let filterData = [];
        filterData = this.saleData.filter((item )=> {
          if(item.cycleid = this.saleQuery.months )
            return true;
        })
        this.pageData = filterData
      }

    }
  }

</script>
<style>

</style>
