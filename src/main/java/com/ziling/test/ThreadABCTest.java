package com.ziling.test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

// ABCD顺序打印十遍
public class ThreadABCTest {

    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        Thread t_d = new Thread(new Thread_ABC(maj , 'D'));
        t_a.start();
        t_b.start();
        t_c.start();
        t_d.start();
    }
}

@Data
class MajusculeABC {
    LinkedList<Character> list = new LinkedList();
    int idx = 0;
    int loopCountMax = 100000;
    int currentLoop = 0;

    ReentrantLock lock = new ReentrantLock();
    public Character currentChart() {
        int i = idx % list.size();
        if (i == 0 && idx != 0) {
            currentLoop++;
            idx = 0;
            if (currentLoop >= loopCountMax) {
                currentLoop = -1;
                System.out.println();
                return null;
            }
            System.out.println();
        }
        return list.get(i);
    }

    public void add(Character character) {
        list.add(character);
    }



}

@Data
class Thread_ABC implements Runnable {
    private MajusculeABC majusculeABC;
    private Character msg;

    public Thread_ABC(MajusculeABC majusculeABC, Character msg) {
        majusculeABC.add(msg);
        this.majusculeABC = majusculeABC;
        this.msg = msg;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        while (true) {
            synchronized (majusculeABC) {
                if (majusculeABC.currentLoop < 0) {
                    break;
                } else {
                    if (Objects.equals(majusculeABC.currentChart(), this.msg)) {
                        System.out.print(msg);
                        majusculeABC.idx++;
                    }
                }

            }
        }
        System.out.println(System.currentTimeMillis() - a);
    }

}