package com.example.bootdemo.common.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class RushOrderAtomic {

    AtomicInteger i = new AtomicInteger(60000);
   // int i  = 60000;//运行时在堆内存 只有堆内存中才是线程共享的
    public void order(){
        //业务操作
        i.decrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        RushOrderAtomic rushOrder = new RushOrderAtomic();
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
