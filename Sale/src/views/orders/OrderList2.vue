<template>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      width="120"
      sortable>
    </el-table-column>
    <el-table-column
      prop="serialNumber"
      label="号码"
      width="120"
      sortable>
    </el-table-column>
    <el-table-column
      prop="stateName"
      label="订单状态"
      width="120"
      sortable
      :filters="[{text: '已提交', value: '已提交'}, {text: '已开户', value: '已开户'}, {text: '物流派送', value: '物流派送'}, {text: '已签收', value: '已签收'}, {text: '已激活', value: '已激活'}]"
      :filter-method="filterHandler">
    </el-table-column>
    <el-table-column
      prop="userName"
      label="用户姓名"
      width="100"
      sortable>
    </el-table-column>
    <el-table-column
      prop="postAddress"
      label="邮寄地址"
      width="140">
    </el-table-column>
    <el-table-column
      prop="linkPhone"
      label="联系电话"
      width="120">
    </el-table-column>
    <el-table-column
      prop="psptId"
      label="证件号码"
      width="120">
    </el-table-column>
    <el-table-column
      prop="orderTime"
      label="订单日期"
      width="120"
      sortable>
    </el-table-column>
    <el-table-column>
      <template slot-scope="scope">
        <el-button
          size="mini"
          :type="bclass[scope.row.state]"
          @click="handleEdit(scope.$index, scope.row)">{{state[scope.row.state]}}</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  import {getOrderReport,updateOrder} from '@/api/bforder'

    export default {
        name: "OrderList2",
        data() {
            return {
                //state:{0：订单提交，1:"已开户",2:"已发货",3:"已签收",4:"已激活"},
                state:{0:"开户",1:"发货",2:"签收",3:"激活",4:"完成"},
                bclass:{0:"primary",1:"success",2:"warning",3:"danger",4:"info"},
                msg: "vue template",
                tableData: []
            }
        },
        mounted() {
            getOrderReport().then((res)=>{
                this.tableData=res.data.items;
            })
        },methods:{
            handleEdit(index,row) {
                if(row.state<4) {

                    this.$confirm('确定要操作吗?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        updateOrder(row.id,parseInt(row.state)+1).then((res)=>{
                            this.$message({
                                type: 'success',
                                message: '处理成功!'
                            });

                            getOrderReport().then((res)=>{
                                this.tableData=res.data.items;
                            })
                        })
                })
            }
        },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
            }
    }
    }
</script>

<style scoped>
.el-table{
  margin-left: 20px;
}
</style>
