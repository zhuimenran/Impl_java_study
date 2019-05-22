package com.txb.test.synchron.overall;

//LockTest4.java的源码
/**
 * (04) 可以被同时访问。因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的。
 * @author 13125
 *
 */
public class LockTest4 {

 Something x = new Something();
 Something y = new Something();

 // 比较(04) x.isSyncA()与Something.cSyncA()
 private void test4() {
     // 新建t41, t41会调用 x.isSyncA()
     Thread t41 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     x.isSyncA();
                 }
             }, "t41");

     // 新建t42, t42会调用 x.isSyncB()
     Thread t42 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     Something.cSyncA();
                 }
             }, "t42");  


     t41.start();  // 启动t41
     t42.start();  // 启动t42
 }

 public static void main(String[] args) {
     LockTest4 demo = new LockTest4();

     demo.test4();
 }
}
