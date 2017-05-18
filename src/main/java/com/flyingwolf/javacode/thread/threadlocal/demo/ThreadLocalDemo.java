package com.flyingwolf.javacode.thread.threadlocal.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo implements Runnable{  
	
    private static AtomicInteger ai = new AtomicInteger(0);  
    
    public void run() {  
        Context context = new Context();  
        context.setTransactionId(getName());  
        MyThreadLocal.set(context);  
        System.out.println("request["+Thread.currentThread().getName()+"]:"+context.getTransactionId());  
        new BusinessService().businessMethod();  
        MyThreadLocal.unset();  
    }  
      
    private String getName() {  
        return ai.getAndIncrement()+"";  
    }  
  
    public static void main(String[] args) {  
        ThreadLocalDemo tld  = new ThreadLocalDemo();  
        new Thread(tld).start();  
        new Thread(tld).start();  
    }  
  
}  


class BusinessService {  
  
    public void businessMethod() {  
        Context context = MyThreadLocal.get();  
        System.out.println("service["+Thread.currentThread().getName()+"]:"+context.getTransactionId());  
    }  
  
}  