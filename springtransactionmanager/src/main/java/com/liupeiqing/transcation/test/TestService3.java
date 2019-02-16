package com.liupeiqing.transcation.test;

import com.liupeiqing.transcation.service.OrdersService3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liupeqing
 * @date 2019/2/16 19:08
 */
public class TestService3 {


    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext_annotation.xml");

        OrdersService3 ordersService3 = (OrdersService3) context.getBean("ordersService3");

        ordersService3.accountMoney();
    }
}
