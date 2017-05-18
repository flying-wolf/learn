package com.flyingwolf.javacode.thread.threadlocal.demo;
/** 
 * 其中引用了Context类 
 */  
public class MyThreadLocal {  
    private static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<Context>();  
    public static void set(Context user){  
        userThreadLocal.set(user);  
    }  
    public static void unset(){  
        userThreadLocal.remove();  
    }  
    public static Context get(){  
        return userThreadLocal.get();  
    }  
      
}  