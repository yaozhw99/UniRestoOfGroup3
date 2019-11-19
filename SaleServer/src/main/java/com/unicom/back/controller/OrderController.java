package com.unicom.back.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicom.back.entity.TbLogOrder;
import com.unicom.back.entity.TfFOrderinfo;
import com.unicom.back.service.OrderService;
import com.unicom.back.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value="addOrder")
    public JSONObject addOrder(@RequestBody JSONObject json) {
        String serialNumber=json.getString("serialNumber");
        String productName=json.getString("productName");
        String actionName=json.getString("actionName");
        String epcode=json.getString("epcode");
        String userName=json.getString("userName");
        String psptId=json.getString("psptId");
        String postAddress=json.getString("postAddress");
        String linkPhone=json.getString("linkPhone");
        String operNo="admin";
        int orderId=orderService.addOrder(serialNumber,productName,actionName,epcode,userName,psptId,postAddress,linkPhone,operNo);

        return Util.getJsonObject("20000","新增成功！",String.valueOf(orderId));
    }

    @RequestMapping(value="getOrder")
    public TbLogOrder findOrder(@RequestParam int id){
        return orderService.findOrder(id);
    }

    @RequestMapping(value="getOrderInfo",method = RequestMethod.GET)
    public JSONObject getOrderInfo(@RequestParam int id) {
        return Util.getJsonObject(orderService.getOrderInfo(id).toString());
    }

    @RequestMapping(value = "getOrderdealLog",method = RequestMethod.GET)
    public JSONObject getOrderDealLog(@RequestParam int orderId) {
        return Util.getJsonObject(orderService.getOrderdeal(orderId));
    }

    @PostMapping(value = "updateOrder")
    public JSONObject updateOrder(@RequestParam int orderId,
                                  @RequestParam int orderState) {
        orderService.updateOrderDeal(orderId,orderState);
        return Util.getJsonObject("{}");

    }






}
