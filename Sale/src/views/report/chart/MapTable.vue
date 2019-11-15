<template> 
  <div>
    <p>{{city}}</p>
    <table>
      <tr>
        <th v-for="(value,idx) in columns" :key="idx">{{value}}</th>
      </tr>
      <tr v-for="(p,idx) in filterData" :key="idx">
        <td v-for="(value,key) in columns"  :key="key">
          <label>{{p[key]}}</label>
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
  export default {
    props:['data','columns','city'],
    data() {
      return {
        searchQuery: '',
        filterColumn:'name'
      }
    },
    computed:{
      filterData(){
        let {searchQuery,filterColumn}=this;
        let arr=[...this.data];
        if(searchQuery)
          arr=this.data.filter(
            n=>n[filterColumn].toUpperCase().includes(searchQuery.toUpperCase())
      );
        return arr;

      }
    }
  }
</script>
<style>
  p{
    font-size: 22px;
    color:#fff;
    text-align: center;
    font-weight: bold;
  }
  table{
    width: 100%;
    height: 80%;
    /*border:1px solid orangered;*/
    /*border-collapse: collapse;*/
    color: #fff;
    text-align: center;
  }
  td,th{
    background: #014981;
  }
  th{
    background: #2EC7C9;
    color: white;
  }

</style>
