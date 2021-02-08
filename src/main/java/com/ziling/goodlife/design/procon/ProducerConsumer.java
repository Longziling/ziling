package com.ziling.goodlife.design.procon;

public class ProducerConsumer {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
        Thread producer = new Thread(new Producer(wareHouse));
        Thread consumer = new Thread(new Consumer(wareHouse));
        Thread producer1 = new Thread(new Producer(wareHouse));
        Thread consumer1 = new Thread(new Consumer(wareHouse));
        producer.setName("producer");
        consumer.setName("consumer");
        producer1.setName("producer1");
        consumer1.setName("consumer1");
        producer.start();
        consumer.start();
        producer1.start();
        consumer1.start();

    }
}

class WareHouse{
    private int data=0;

    //生产商品
    public synchronized void pro(){
        while (data != 0){   //使用if会产生虚假唤醒现象
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data++;
        System.out.println(Thread.currentThread().getName()+"---->"+data);
        this.notifyAll();
    }

    //消费商品
    public synchronized void con(){
        while (data==0){  //使用if会产生虚假唤醒现象
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data--;
        System.out.println(Thread.currentThread().getName()+"---->"+data);
        this.notifyAll();
    }
}

//生产者线程
class Producer implements Runnable{
    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        //模拟一直生产
        while(true){
            wareHouse.pro();
        }
    }
}

//消费者线程
class Consumer implements Runnable{
    private WareHouse wareHouse;

    public Consumer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }
    @Override
    public void run() {
        //模拟一直消费
        while(true){
            wareHouse.con();
        }
    }
}

