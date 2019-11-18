package com.unicom.back;

import com.unicom.back.dao.OrderDao;
import com.unicom.back.entity.TbLogOrder;
import com.unicom.back.entity.TbLogOrderDeal;
import com.unicom.back.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class BackApplicationTests {

    @Autowired
    private OrderDao orderDao;

    @Test
    void contextLoads() {

        TbLogOrderDeal tb=new TbLogOrderDeal();
        tb.setOrderId(20006);
        tb.setOrderState(1);
        tb.setInsertUser("admin");
        tb.setInsertTime(new Date());
        orderDao.addOrderDeal(tb);

    }

}
