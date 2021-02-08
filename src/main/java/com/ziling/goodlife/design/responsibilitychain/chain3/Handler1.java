package com.ziling.goodlife.design.responsibilitychain.chain3;

public class Handler1 implements MessageHandler {
    @Override
    public void handler(Message message) {
        System.out.println(message.getCount());
        message.setCount(message.getCount() + 1);
    }
}
