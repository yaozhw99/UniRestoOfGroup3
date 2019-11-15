<template>   
  <div class="card">
    <div class="hotdecration" v-if="ifshowhot"><i class="el-icon-star-off"></i><i class="el-icon-star-off"></i>{{HOT}}<i class="el-icon-star-off"></i><i class="el-icon-star-off"></i></div>
    <div  @click="linkorder([item.name,,])" v-for="(item,idx) in card" :key="idx" :class="item.ifhot?'hot':'normal'">
      <img :src="item.src">
    </div>
  </div>

</template>


<script>

    export default {

        data() {

            return {

            }

        },
        props:['ifshowhot']

    }

</script>


<style>


</style>
