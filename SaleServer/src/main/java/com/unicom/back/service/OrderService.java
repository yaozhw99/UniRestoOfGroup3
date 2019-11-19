package com.unicom.back.service;

import com.unicom.back.dao.OrderDao;
import com.unicom.back.entity.OrderReport;
import com.unicom.back.entity.TbLogOrder;
import com.unicom.back.entity.TbLogOrderDeal;
import com.unicom.back.entity.TfFOrderinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderDao oo;

    public TbLogOrder findOrder(int id) {
        TbLogOrder tb= oo.findOrder(id);
        return tb;
    }

    @Transactional
    public int addOrder(String serialNumber,String productName,String actionName,String epcode,String userName,
                        String psptId,String postAddress,String linkPhone,String operNo) {
        TbLogOrder to=new TbLogOrder();
        to.setEpcode(epcode);
        to.setLinkPhone(linkPhone);
        to.setOrderActionId(0);
        to.setOrderProductId(0);
        to.setOrderTime(new Date().toString());
        to.setPostAddress(postAddress);
        to.setPsptId(psptId);
        to.setSerialNumber(serialNumber);

        int userId=new Random().nextInt();
        to.setUserId(userId);
        to.setUserName(userName);
        oo.addOrderLog(to);
        int id=to.getId();

        TbLogOrderDeal tod=new  TbLogOrderDeal();
        tod.setInsertTime(new Date());
        tod.setInsertUser(operNo);
        tod.setOrderId(id);
        tod.setOrderState(0);
        oo.addOrderDeal(tod);

        TfFOrderinfo tf=new TfFOrderinfo();
        tf.setOrderId(id);
        tf.setState(0);
        tf.setUpdateTime(new Date());
        tf.setUserId(userId);
        oo.addOrderInfo(tf);

        return id;
    }

    public TfFOrderinfo getOrderInfo(int id) {
        return oo.getOrderInfo(id);
    }

    public List<TbLogOrderDeal> getOrderdeal(int orderId) {
        return oo.getOrderDeal(orderId);
    }


    public List<OrderReport> getOrderReport() {
        return oo.getOrderReport();
    }

    @Transactional
    public void updateOrderDeal(int orderId,int orderState) {
        TfFOrderinfo tf=new TfFOrderinfo();
        tf.setOrderId(orderId);
        tf.setState(orderState);
        tf.setUpdateTime(new Date());

        oo.updateOrderInfo(tf);

        TbLogOrderDeal tb=new TbLogOrderDeal();
        tb.setOrderId(orderId);
        tb.setOrderState(orderState);
        tb.setInsertUser("admin");
        tb.setInsertTime(new Date());
        oo.addOrderDeal(tb);

    }

}
