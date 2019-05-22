package com.txb.test.synchron.overall;

//LockTest3.java的源码

/**
 * (03) 不能被同时访问。因为cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.isSyncA()，y.cSyncB()相当于Something.isSyncB()，因此它们共用一个同步锁，不能被同时反问。
 * @author 13125
 *
 */
public class LockTest3 {

 Something x = new Something();
 Something y = new Something();

 // 比较(03) x.cSyncA()与y.cSyncB()
 private void test3() {
     // 新建t31, t31会调用 x.isSyncA()
     Thread t31 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     x.cSyncA();
                 }
             }, "t31");

     // 新建t32, t32会调用 x.isSyncB()
     Thread t32 = new Thread(
             new Runnable() {
                 @Override
                 public void run() {
                     y.cSyncB();
                 }
             }, "t32");  


     t31.start();  // 启动t31
     t32.start();  // 启动t32
 }

 public static void main(String[] args) {
     LockTest3 demo = new LockTest3();

     demo.test3();
 }
}
