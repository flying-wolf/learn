package com.flyingwolf.javacode.thread.threadlocal.demo;
/* 
 * 包含业务唯一标识的类 
 * */  
public class Context {  
    private String transactionId;  
  
    public String getTransactionId() {  
        return transactionId;  
    }  
  
    public void setTransactionId(String transactionId) {  
        this.transactionId = transactionId;  
    }  
  
}  