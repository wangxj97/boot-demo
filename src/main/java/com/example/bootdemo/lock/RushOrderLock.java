package com.example.bootdemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RushOrderLock {

    int i  = 60000;//运行时在堆内存 只有堆内存中才是线程共享的
    Lock lock = new ReentrantLock();//可重入锁

    public void order(){
        //业务操作
        lock.lock();
        try {
            i--;

        }finally {//一般解锁都要放在finally里,必须确保释放
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RushOrderLock rushOrder = new RushOrderLock();
        //6线程处理
        for (int j = 0;j<6;j++){
            new Thread(
                    ()->{//1.8
                        for (int k = 0;k<10000;k++){
                            rushOrder.order();
                        }
                    }
            ).start();
        }
        Thread.sleep(5000);
        System.out.println("库存量:"+rushOrder.i);
    }
}
