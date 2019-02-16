package com.liupeiqing.transcation.test;

import com.liupeiqing.transcation.service.OrdersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试方法
 * @author liupeqing
 * @date 2019/2/16 17:24
 */
public class TestService {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        OrdersService ordersService = (OrdersService) context.getBean("ordersService");
        ordersService.accountMoney();
    }
}
