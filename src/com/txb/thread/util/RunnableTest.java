package com.txb.thread.util;

public class RunnableTest {  
    public static void main(String[] args) {  
        MyThread mt=new MyThread();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1=new Thread(mt);
        Thread t2=new Thread(mt);
        Thread t3=new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }  
}