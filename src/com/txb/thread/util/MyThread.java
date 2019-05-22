package com.txb.thread.util;
/**
 结果说明：
(01) 和上面“MyThread继承于Thread”不同；这里的MyThread实现了Thread接口。
(02) 主线程main创建并启动3个子线程，而且这3个子线程都是基于“mt这个Runnable对象”而创建的。运行结果是这3个子线程一共卖出了10张票。这说明它们是共享了MyThread接口的。
 *
 */
class MyThread extends Thread{  
    private int ticket=10;  
    public void run(){
        for(int i=0;i<20;i++){ 
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    } 
};
