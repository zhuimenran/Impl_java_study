package com.txb.inter;

//Demo2.java的源码
/**
 * 结果说明：
程序进入了死循环！
为什么会这样呢？这是因为，t1在“等待(阻塞)状态”时，被interrupt()中断；此时，会清除中断标记[即isInterrupted()会返回false]，而且会抛出InterruptedException异常[该异常在while循环体内被捕获]。因此，t1理所当然的会进入死循环了。
解决该问题，需要我们在捕获异常时，额外的进行退出while循环的处理。例如，在MyThread的catch(InterruptedException)中添加break 或 return就能解决该问题。
 * @author 13125
 *
 */
public class Demo2 {

 public static void main(String[] args) {  
     try {  
         Thread t1 = new MyThreadA("t1");  // 新建“线程t1”
         System.out.println(t1.getName() +" ("+t1.getState()+") is new.");  

         t1.start();                      // 启动“线程t1”
         System.out.println(t1.getName() +" ("+t1.getState()+") is started.");  

         // 主线程休眠300ms，然后主线程给t1发“中断”指令。
         Thread.sleep(300);
         t1.interrupt();
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

         // 主线程休眠300ms，然后查看t1的状态。
         Thread.sleep(300);
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
     } catch (InterruptedException e) {  
         e.printStackTrace();
     }
 } 
}
