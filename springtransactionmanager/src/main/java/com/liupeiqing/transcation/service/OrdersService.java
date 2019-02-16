package com.liupeiqing.transcation.service;

import com.liupeiqing.transcation.dao.OrdersDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 1.编程式事务管理
 * 对应的application.xml
 * @author liupeqing
 * @date 2019/2/16 17:04
 */
public class OrdersService {

    // 注入Dao层对象
    private OrdersDao ordersDao;

    // 注入TransactionTemplate对象
    private TransactionTemplate transactionTemplate;

    public void setOrdersDao(OrdersDao ordersDao){
        this.ordersDao = ordersDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * （1）编程式事务管理   通过TransactionTemplate手动管理事务，实际应用中很少使用，
     * 此处需要手动捕获异常
     */
    //调用dao方法
    // 业务逻辑，写转账业务
    public void accountMoney(){
        transactionTemplate.execute(new TransactionCallback<Object>(){
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Object result = null;
                try{
                    // 小马多1000
                    ordersDao.addMoney();
                    // 加入出现异常如下面int
                    // i=10/0（银行中可能为突然停电等。。。）；结果：小马账户多了1000而小王账户没有少钱
                    // 解决办法是出现异常后进行事务回滚
                    int i = 10 / 0;// 事务管理配置后异常已经解决,双方的数据一直 都是3000，去掉则数据变为2000，4000
                    // 小王 少1000
                    ordersDao.reduceMoney();

                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    result = false;
                    System.out.println("Transfer Error!");
                }
                return result;
            }
        });
    }
}
