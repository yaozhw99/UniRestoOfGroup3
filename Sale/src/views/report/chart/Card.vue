<template>
  <el-row :gutter="40" class="panel-group">
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('newVisitis')">
        <div class="card-panel-icon-wrapper icon-people">
          <svg-icon icon-class="education" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
           订单量
          </div>
          <!--<count-to  :start-val="0" :end-val="totaldata" :duration="2600" class="card-panel-num" />-->
          <p style="color: white;font-size: 20px">{{totaldata}}</p>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('messages')">
        <div class="card-panel-icon-wrapper icon-message">
          <svg-icon icon-class="message" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            发货量
          </div>
          <!--<count-to :start-val="0" :end-val="datafahuo" :duration="3000" class="card-panel-num" />-->
          <p style="color: white;font-size: 20px">{{datafahuo}}</p>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('purchases')">
        <div class="card-panel-icon-wrapper icon-money">
          <svg-icon icon-class="email" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            签收量
          </div>
          <!--<count-to :start-val="0" :end-val="9280" :duration="3200" class="card-panel-num" />-->
          <p style="color: white;font-size: 20px">{{dataqianshou}}</p>
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('shoppings')">
        <div class="card-panel-icon-wrapper icon-shopping">
          <!--<svg-icon icon-class="shopping" class-name="card-panel-icon" />-->
          <i class="el-icon-phone card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            激活量
          </div>
          <!--<count-to :start-val="0" :end-val="13600" :duration="3600" class="card-panel-num" />-->
          <p style="color: white;font-size: 20px">{{dataactive}}</p>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
  import CountTo from 'vue-count-to'

  export default {
    prop:['Sale'],
    data(){
      return {
//        datatotal:4500,
        datafahuo:81212,
        dataqianshou:9280,
        dataactive:13600
      }
    },
    components: {
      CountTo
    },
    methods: {
      handleSetLineChartData(type) {
        this.$emit('handleSetLineChartData', type)
      }
    },
    mounted(){

      var flag=81212;
      var timer = setInterval(()=>{
        flag++;
        this.datafahuo=flag;
        console.log(this.datafahuo)
      },2000);

      var timer_qianshou = setInterval(()=>{
      this.datafahuo=this.datafahuo-1;
      this.dataqianshou+=1;
    },3000);
      var timer_active = setInterval(()=>{
        this.dataactive=this.dataactive+1;
    },4000);
    },
    computed:{
      totaldata(){
        return this.datafahuo+this.dataqianshou;
      }
    }
  }
</script>

<style lang="scss" scoped>
  .panel-group {
    margin-top: 18px;

  .card-panel-col {
    margin-bottom: 0px;
  }

  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #044161;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);

  &:hover {
  .card-panel-icon-wrapper {
    color: #fff;
  }

  .icon-people {
    background: #40c9c6;
  }

  .icon-message {
    background: #36a3f7;
  }

  .icon-money {
    background: #f4516c;
  }

  .icon-shopping {
    background: #34bfa3
  }
  }

  .icon-people {
    color: #40c9c6;
  }

  .icon-message {
    color: #36a3f7;
  }

  .icon-money {
    color: #f4516c;
  }

  .icon-shopping {
    color: #34bfa3
  }

  .card-panel-icon-wrapper {
    float: left;
    margin: 14px 0 0 14px;
    padding: 16px;
    transition: all 0.38s ease-out;
    border-radius: 6px;
  }

  .card-panel-icon {
    float: left;
    font-size: 48px;
  }

  .card-panel-description {
    float: right;
    font-weight: bold;
    margin: 26px;
    margin-left: 0px;

  .card-panel-text {
    line-height: 18px;
    color: rgba(255, 255, 255, 1);
    font-size: 16px;
    margin-bottom: 12px;
  }

  .card-panel-num {
    color: rgba(255, 255, 255, 1);
    font-size: 20px;
  }
  }
  }
  }

  @media (max-width:550px) {
    .card-panel-description {
      display: none;
    }

    .card-panel-icon-wrapper {
      float: none !important;
      width: 100%;
      height: 100%;
      margin: 0 !important;

    .svg-icon {
      display: block;
      margin: 14px auto !important;
      float: none !important;
    }
  }
  }
</style>
