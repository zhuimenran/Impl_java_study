package com.txb.yeild;

class ThreadB extends Thread{
	 public ThreadB(String name){ 
	     super(name); 
	 } 
	 public synchronized void run() { 
	     try {
	         for(int i=0; i <10; i++){ 
	             System.out.printf("%s: %d\n", this.getName(), i); 
	             // i能被4整除时，休眠100毫秒
	             if (i%4 == 0)
	                 Thread.sleep(10000);
	         } 
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	 } 
	} 
