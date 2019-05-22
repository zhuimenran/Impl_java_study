package com.txb.wait;

//WaitTimeoutTest.java的源码
/**
 * 运行结果：

main start t1
main call wait 
t1 run                  // 大约3秒之后...输出“main continue”
main continue
结果说明：
如下图，说明了“主线程”和“线程t1”的流程。
(01) 注意，图中"主线程" 代表WaitTimeoutTest主线程(即，线程main)。"线程t1" 代表WaitTest中启动的线程t1。 而“锁” 代表“t1这个对象的同步锁”。
(02) 主线程main执行t1.start()启动“线程t1”。
(03) 主线程main执行t1.wait(3000)，此时，主线程进入“阻塞状态”。需要“用于t1对象锁的线程通过notify() 或者 notifyAll()将其唤醒” 或者 “超时3000ms之后”，主线程main才进入到“就绪状态”，然后才可以运行。
(04) “线程t1”运行之后，进入了死循环，一直不断的运行。
(05) 超时3000ms之后，主线程main会进入到“就绪状态”，然后接着进入“运行状态”。
 * @author 13125
 *
 */

public class WaitTimeoutTest {

 public static void main(String[] args) {

     ThreadB t1 = new ThreadB("t1");

     synchronized(t1) {
         try {
             // 启动“线程t1”
             System.out.println(Thread.currentThread().getName() + " start t1");
             t1.start();

             // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
             System.out.println(Thread.currentThread().getName() + " call wait ");
             t1.wait(3000);

             System.out.println(Thread.currentThread().getName() + " continue");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}
