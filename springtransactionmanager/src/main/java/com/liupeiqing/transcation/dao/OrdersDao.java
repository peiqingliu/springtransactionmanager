package com.liupeiqing.transcation.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author liupeqing
 * @date 2019/2/16 16:55
 */
public class OrdersDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 对数据操作的方法不包含业务操作

    /**
     * 小王少钱的方法
     */
    public void reduceMoney(){

        String sql = "update account set money=money-? where name=?";
        jdbcTemplate.update(sql,1000,"小王");
    }

    /**
     * 小王多钱的方法
     */
    public void addMoney(){
        String sql = "update account set money=money+? where name=?";
        jdbcTemplate.update(sql,1000,"小马");
    }
}
