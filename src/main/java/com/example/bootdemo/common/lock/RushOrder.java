package com.example.bootdemo.common.lock;

public class RushOrder {

    int i  = 60000;//运行时在堆内存 只有堆内存中才是线程共享的
    public void order(){
        //业务操作
        i--;
    }

    public static void main(String[] args) throws InterruptedException {
        RushOrder rushOrder = new RushOrder();
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
