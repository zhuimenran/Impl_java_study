package com.txb.thread.priority;

class MyThread1 extends Thread{  
	 public MyThread1(String name) {
	     super(name);
	 }

	 public void run(){
	     try {
	         for (int i=0; i<5; i++) {
	             Thread.sleep(3);
	             System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
	         }
	     } catch (InterruptedException e) {
	     }
	 } 
	}; 