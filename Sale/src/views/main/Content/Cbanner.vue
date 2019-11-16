<template>
    <div id="app">
      <div class="left"><img src="@/icons/image/icon-unicom.png" alt=""></div>
      <div class="right">
        <div class="search">
          <input type="text" placeholder="5G畅爽冰激淋">
          <div><span>Search</span></div>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Cbanner",
        data() {
            return {
                msg: "vue template"
            }
        }
    }
</script>

<style scoped>
#app{
  height: 140px;
  width: 1200px;
  background-color: white;
  margin: 0 auto;
  display: flex;
}
.left img {
  width: 130px;
  height: 130px;
  margin-top: 5px;
  border-radius: 80px 80px;
}
  .search{
    width: 550px;
    height: 38px;
    border: 2px solid orange;
    display: flex;
    border-radius: 3px;
    margin-left: 10px;
    margin-top: 50px;
  }
  .search input{
    border: none;
    height: 34px;
    width: 480px;
    display: block;
  }
  .search div:nth-child(2) {
    height: 100%;
    width: 70px;
    background-color: orange;
    color: white;
    font-weight: bold;
    font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
    line-height: 38px;
    text-align: center;
  }
</style>
