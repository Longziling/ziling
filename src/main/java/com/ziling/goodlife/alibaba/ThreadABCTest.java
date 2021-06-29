package com.ziling.goodlife.alibaba;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 0:55
 */
public class ThreadABCTest {
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}

class MajusculeABC {

    LinkedList<Character> list = new LinkedList();
    int idx = 0;
    int loopCountMax = 10;
    int currentLoop = 0;


    public void addList(Character character) {
        list.add(character);
    }

    public Character getListItem() {
        int i = idx % list.size();
        if (i == 0 && idx != 0) {
            idx = 0;
            currentLoop++;
            System.out.println();
            if (currentLoop == loopCountMax) {
                currentLoop = -1;
                return null;
            }
        }
        return list.get(i);
    }



}
class Thread_ABC implements Runnable {

    private final MajusculeABC maj;
    private Character item;

    Thread_ABC(MajusculeABC maj, Character item) {
        this.maj = maj;
        this.item = item;
        this.maj.addList(item);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (maj) {
                Character listItem = maj.getListItem();
                if (maj.currentLoop == -1) {
                    maj.notifyAll();
                    break;
                } else {
                    if (Objects.equals(listItem, item)) {
                        maj.idx++;
                        System.out.print(item);
                    }
                    try {
                        maj.notifyAll();
                        maj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}