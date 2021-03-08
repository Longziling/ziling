package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain3;

public class Handler3 implements MessageHandler {
    @Override
    public void handler(Message message) {
        System.out.println(message.getCount());
        message.setCount(message.getCount() + 1);
    }
}
