package com.liupeiqing.transcation.test;

import com.liupeiqing.transcation.service.OrdersService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于aop的模式事务管理 进行测试
 * @author liupeqing
 * @date 2019/2/16 18:43
 */
public class TestService2 {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext_aop.xml");

        OrdersService2 ordersService2 = (OrdersService2) context.getBean("ordersService2");

        ordersService2.accountMoney();
    }
}
