package com.txb.thread.priority;

//Demo.java

/**
 * 结果说明：
(01) 主线程main是用户线程，它创建的子线程t1也是用户线程。
(02) t2是守护线程。在“主线程main”和“子线程t1”(它们都是用户线程)执行完毕，只剩t2这个守护线程的时候，JVM自动退出。

 
 * @author 13125
 *
 */

public class Demo1 {  
 public static void main(String[] args) {  

     System.out.println(Thread.currentThread().getName()
             +"(isDaemon="+Thread.currentThread().isDaemon()+ ")");

     Thread t1=new MyThread1("t1");    // 新建t1
     Thread t2=new MyDaemon("t2");    // 新建t2
     t2.setDaemon(true);                // 设置t2为守护线程
     t1.start();                        // 启动t1
     t2.start();                        // 启动t2
 }  
}