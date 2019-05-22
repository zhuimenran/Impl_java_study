package com.txb.test;

class MyThread extends Thread{  
	 public MyThread(String name) {
	     super(name);
	 }

	 public void run(){
	     System.out.println(Thread.currentThread().getName()+" is running");
	 } 
	}; 
