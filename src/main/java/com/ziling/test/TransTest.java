package com.ziling.test;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;

/**
 * 尝试用java编写一个转账服务，传入交易流水号、转出账号，转入账号，转账金额，完成转出和转入账号的资金处理，
 * 该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确，能够支撑每天10万笔的个人用户之间转账,
 * 假如数据库使用Oracle，不需要考虑两个账户在不同的数据库。
 * 要求： （1）数据库orm或者jdbc自选 （2）数据库事务控制清晰明确
 */
public class TransTest {

//    private AtomicLong count = new AtomicLong(10000L);
//
//    @Transaction()
//    public boolean Trans (Trans trans) {
//        while (true) {
//            Long current = count.get();
//            if (current - trans.getCount() > 0) {
//                if (count.compareAndSet(current, current - trans.getCount()) ) {
//                    // 1. 入库
//                    // 2. 写流水
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
//
//    }
//
//
//
//@Data
//class Trans {
//    private String reqId;
//    private String outAccout;
//    private String inAccout;
//    private long count;
//}

}
