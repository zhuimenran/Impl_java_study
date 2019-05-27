package com.txb.inter;

class MyThreadA extends Thread {
	 
	 public MyThreadA(String name) {
	     super(name);
	 }

	 @Override
	 public void run() {
	     int i=0;
	     while (!isInterrupted()) {
	         try {
	             Thread.sleep(100); // 休眠100ms
	         } catch (InterruptedException ie) {  
	             System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");  
	         }
	         i++;
	         System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);  
	     }
	 }
	}
