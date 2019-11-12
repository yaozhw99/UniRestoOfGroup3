<template>   
    <div>
      <div class="shift">
        <template>
          <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in shift" :key="item.id">
              <img :src="item.src">
            </el-carousel-item>
          </el-carousel>
        </template>
      </div>
      <el-row :gutter="20">
        <el-col :span="3" v-for="(item,idx) in menu" :key="idx" :class="item.property?'complex':'normal'">{{item.name}}
          <el-col :span="3" v-show="item.property" v-for="p in item.subMenu" class="complex">{{p.name}}</el-col>
        </el-col>
      </el-row>
    </div>
</template>


<script>

    export default {

        data() {

            return {
                shift: [
                    {id:0,
                    src:require("../../../icons/MainPageImg/shift.jpg")},
                    {id:1,
                        src:require("../../../icons/MainPageImg/shift1.jpg")},
                    {id:2,
                        src:require("../../../icons/MainPageImg/shift2.jpg")}
                ],
                menu:[{
                    name:"特色号码"
                      },
                    {
                        name:'火爆卡品',
                        property:1,
                        subMenu:[{name:"腾讯王卡"},{name:"冰淇淋卡"},{name:"流量王卡"}]
                    },{}]
            }

        }

    }

</script>


<style>
.el-carousel img{
  width: 100%;
}
</style>
