package com.txb.yeild;
/**
 * 主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，即synchronized(obj)。在t1运行过程中，虽然它会调用Thread.sleep(100)；但是，t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！
注意，若我们注释掉synchronized (obj)后再次执行该程序，t1和t2是可以相互切换的。下面是注释调synchronized(obj) 之后的源码：
 * @author 13125
 *
 */
//SleepLockTest.java的源码
public class SleepLockTest{ 

 private static Object obj = new Object();

 public static void main(String[] args){ 
     ThreadA t1 = new ThreadA("t1"); 
     ThreadA t2 = new ThreadA("t2"); 
     t1.start(); 
     t2.start();
 } 

 static class ThreadA extends Thread{
     public ThreadA(String name){ 
         super(name); 
     } 
     public void run(){ 
         // 获取obj对象的同步锁
         synchronized (obj) {
             try {
                 for(int i=0; i <10; i++){ 
                     System.out.printf("%s: %d\n", this.getName(), i); 
                     // i能被4整除时，休眠100毫秒
                     if (i%4 == 0)
                         Thread.sleep(100);
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     } 
 } 
}
