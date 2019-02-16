package com.liupeiqing.transcation.service;

import com.liupeiqing.transcation.dao.OrdersDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * （3）基于注解的方式
 * 对应的application_annotation.xml 配置文件
 * @author liupeqing
 * @date 2019/2/16 18:55
 */
public class OrdersService3 {

    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    /**
     * 如果放在方法上，则只是改方法处于事务中，如果放在类上，则是该类上所有的方法都是处在事务中
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
    public void accountMoney(){
        // 小马多1000
        ordersDao.addMoney();
        // 加入出现异常如下面int i=10/0（银行中可能为突然停电等。。。）；结果：小马账户多了1000而小王账户没有少钱
        // 解决办法是出现异常后进行事务回滚
         int i = 10 / 0;// 事务管理配置后异常已经解决
        // 小王 少1000
        ordersDao.reduceMoney();
    }
}
