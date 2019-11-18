package com.unicom.back.dao;

import com.unicom.back.entity.TbLogOrder;
import com.unicom.back.entity.TbLogOrderDeal;
import com.unicom.back.entity.TfFOrderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface OrderDao {

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Update("insert into tb_log_order (serialNumber,userId,orderProductId,orderActionId,orderTime,epcode,userName,psptId,postAddress,linkPhone) values (#{serialNumber},#{userId},#{orderProductId},#{orderActionId},#{orderTime},#{epcode},#{userName},#{psptId},#{postAddress},#{linkPhone})")
    int addOrderLog(TbLogOrder tbLogOrder);

    @Update("insert into tb_log_orderdeal (orderId,orderState,insertUser,insertTime) values (#{orderId},#{orderState},#{insertUser},#{insertTime})")
    int addOrderDeal(TbLogOrderDeal tl);

    @Update("update tb_log_orderdeal set orderState=#{orderState},insertUser=#{insertUser},insertTime=#{insertTime} where orderId=#{orderId}")
    int updateOrderDeal(TbLogOrderDeal tl);

    @Update("update tf_f_orderinfo set state=#{state},update_time=#{updateTime} where orderId=#{orderId}")
    int updateOrderInfo(TfFOrderinfo tf);

    @Update("insert into tf_f_orderinfo values (#{orderId},#{userId},#{state},#{updateTime})")
    int addOrderInfo(TfFOrderinfo tf);

    @Select("select * from tb_log_order where id=#{id}")
    TbLogOrder findOrder(int id);

    @Select("select * from tf_f_orderinfo where orderId=#{id}")
    TfFOrderinfo getOrderInfo(int id);

    @Select("select * from tb_log_orderdeal where orderid=#{orderid} order by insertTime desc")
    List<TbLogOrderDeal> getOrderDeal(int orderId);

}
