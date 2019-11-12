<template>
  <div>

  <div class="chart-container">
    <Chart height="100%" width="100%"></Chart>
  </div>

      <div class="class-container">
        <pie  height="100%" width="100%"></pie>

      </div>


    <div class="chart-container" >
      <Map></Map>
    </div>
  </div>
</template>

<script>
  import Chart from './Barchart.vue'
  import Pie from './Pie.vue'
  import Map from './Map.vue'

  export default {
    name: 'chart',
    components: { Chart , Pie, Map}
  }
</script>

<style scoped>
  .chart-container{
    position: relative;
    width: 100%;
    height: calc(100vh - 84px);
  }
</style>
