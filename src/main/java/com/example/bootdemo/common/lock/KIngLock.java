package com.example.bootdemo.common.lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class KIngLock implements Lock {
    //保证原子性操作, 这个atomicreference参数是泛型 可以是线程thread
    AtomicReference<Thread> owner = new AtomicReference<>();
    //等待的线程--线程安全  阻塞队列是线程安全的
    LinkedBlockingDeque<Thread> wait = new LinkedBlockingDeque<>();


    @Override
    public void lock() {
        //抢不到
        while (!owner.compareAndSet(null,Thread.currentThread())){
           wait.add(Thread.currentThread());
           LockSupport.park();//让当前线程堵塞
           wait.remove(Thread.currentThread()); //放在这里不会影响的,因为线程堵塞了不会执行
        }
        //成功,不需要任何处理
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //只有持有锁的线程才能成功解锁
        if (owner.compareAndSet(Thread.currentThread(),null)){//解锁成功
            //唤醒其他线程
            for (Object obj:wait.toArray()){
                Thread thread = (Thread) obj;
                LockSupport.unpark(thread);
            }
            //存在问题,队列中存放数据,没有删除数据  累积多了可能会内存泄漏
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
