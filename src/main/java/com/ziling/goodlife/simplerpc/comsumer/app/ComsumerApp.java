package com.ziling.goodlife.simplerpc.comsumer.app;

import com.ziling.goodlife.simplerpc.comsumer.service.CalculatorRemoteImpl;
import com.ziling.goodlife.simplerpc.provider.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComsumerApp {
    private static Logger log = LoggerFactory.getLogger(ComsumerApp.class);

    public static void main(String[] args) {
        Calculator calculator = new CalculatorRemoteImpl();
        int result = calculator.add(1, 2);
        System.out.println(result);
        log.info("result is {}", result);
    }
}
