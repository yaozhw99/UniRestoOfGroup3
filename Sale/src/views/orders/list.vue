<template>
  <div>
    <div class="cleft">
      <p>{{msg}}</p>
    </div>
    <div class="cright">
      <p>{{msg}}{{msg}}</p>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Create',
    data() {
      return {
        msg: '面向用户 开户  news create'
      }
    }
  }
</script>

<style scoped>
  .div
  {
    display:flex;
    background-color: #efefef;
  }
  .cleft
  {
    flex:1;
  }

</style>
