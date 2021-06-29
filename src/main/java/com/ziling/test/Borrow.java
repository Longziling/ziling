package com.ziling.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 小明向【蚂蚁借呗】申请了一笔现金借款用于装修，该笔借款由网商银行和X银行一起提供资金，其中网商银行出资金额：A元，某银行出资金额：B元；贷款总共N期，小明看到的还款计划如下表格(等额本金，每期还X本金)，编写一段代码计算出两家银行视角的还款计划（A1A2A3…,B1B2B3…）：
 * 期次号	分期开始时间	分期结束时间	客户视角还款本金	网商银行视角还款本金	X银行视角还款本金
 * 1	2017-01-01	2017-02-01	     X	        A1	        B1
 * 2	2017-02-01	2017-03-01	     X	        A2	        B2
 * 3	2017-03-01	2017-04-01	     X	        A3	        B3
 */
public class Borrow {

    public List<Plan> showPlan(Double aCount, Double bCount, int period) {
        if (aCount <= 0 || bCount <= 0) {
            return null;
        }
        List<Plan> planList = new ArrayList<>(period);
        LocalDate localDate = LocalDate.now();
        Double sumCount = aCount + bCount;
        Double xCount = format(sumCount / period);
        Double percent = aCount / sumCount;
        Double currentACount = format(xCount * percent);
        Double currentBCount = format(xCount - currentACount);

        for (int i = 0; i < period - 1; i++) {
            Plan plan = new Plan();
            plan.startDate = localDate.toString();
            localDate = localDate.plusMonths(1);
            plan.endDate = localDate.toString();
            plan.xAmount = xCount;
            plan.aAmount = currentACount;
            plan.bAmount = currentBCount;
            aCount -= currentACount;
            bCount -= currentBCount;
            planList.add(plan);
        }

        Plan plan = new Plan();
        plan.startDate = localDate.toString();
        localDate = localDate.plusMonths(1);
        plan.endDate = localDate.toString();
        plan.aAmount = format(aCount);
        plan.bAmount = format(bCount);
        plan.xAmount = format(plan.aAmount + plan.bAmount);
        planList.add(plan);
        return planList;
    }

    public static Double format(double value) {
        return Double.parseDouble(new DecimalFormat("0.00").format(value)); // 保留两位小数
    }

    public static String formatDouble(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return nf.format(d);
    }

    public static void main(String[] args) {
        Borrow borrow = new Borrow();
        List<Plan> planList = borrow.showPlan(100.00, 100.00, 24);
        for (Plan plan : planList) {
            System.out.println(plan.startDate + "  " + plan.endDate + " " + plan.xAmount + " " + plan.aAmount + " " +  plan.bAmount + " ");
        }
    }

}

class Plan {
    String startDate;
    String endDate;
    Double xAmount;
    Double aAmount;
    Double bAmount;

}
