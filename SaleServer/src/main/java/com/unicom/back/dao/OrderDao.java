package com.unicom.back.dao;

import com.unicom.back.entity.TbLogOrder;
import com.unicom.back.entity.TbLogOrderDeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface OrderDao {

    @Update("insert into tb_log_order (serialNumber,userId,orderProductId,orderActionId,orderTime,epcode,userName,psptId,postAddress,linkAddress) values (#{to.serialNumber},#{to.userId},#{to.orderProductId},#{to.orderActionId},#{orderTime},#{epcode},#{userName},#{psptId},#{postAddress},#{linkAddress})")
    int addOrderLog(TbLogOrder to);

    @Update("insert into tb_log_orderdeal (orderId,orderState,insertUser,insertTime) values (#{tl.orderId},#{tl.orderState},#{tl.insertUser},#{tl.insertTime})")
    int addOrderDeal(TbLogOrderDeal tl);

    @Update("update tb_log_orderdeal set orderState=#{orderState},insertUser=#{insertUser},insertTime=#{insertTime} where orderId=#{orderId}")
    int updateOrderDeal(int orderId, int orderState, String insertUser, Date insertTime);

    @Update("update tf_f_orderinfo set state=#{state},updateTime=#{updateTime} where orderId=#{orderId}")
    int updateOrderInfo(int orderId,int state,Date updateTime);

}
