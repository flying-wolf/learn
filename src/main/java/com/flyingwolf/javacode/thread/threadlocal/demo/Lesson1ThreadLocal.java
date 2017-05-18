package com.flyingwolf.javacode.thread.threadlocal.demo;

/**
* blog http://www.cnblogs.com/mantu/
* github https://github.com/mantuliu/
* @author mantu
*
*/
public class Lesson1ThreadLocal {
   public static ThreadLocal<String> local = new ThreadLocal<String>();//声明静态的threadlocal变量
   public static ThreadLocal<String> local2 = new ThreadLocal<String>();//声明静态的threadlocal变量
   public static void main(String [] args){
       for(int i=0;i<5;i++){
           TestThread testThread = new TestThread();//创建5个线程
           new Thread(testThread).start();
       }
   }
    
}

class TestThread implements Runnable{
    
   @Override
   public void run() {
       // TODO Auto-generated method stub
       try {
           Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       Lesson1ThreadLocal.local.set(Thread.currentThread().getId()+":"+System.currentTimeMillis());
       Lesson1ThreadLocal.local2.set(Thread.currentThread().getId()+"");
       firstStep();
       try {
           Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       secondStep();
       try {
           Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       thirdStep();
       try {
           Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       fourthStep();
       try {
           Thread.sleep(1l);//让线程停顿一下，便于其它线程执行
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       fStep();
   }
    
   public void firstStep(){
       System.out.println(Lesson1ThreadLocal.local.get().toString()+":first step");//获取本线程的threadlocal变量值并打印
   }
   public void secondStep(){
       System.out.println(Lesson1ThreadLocal.local.get().toString()+":second step");
   }
   public void thirdStep(){
       System.out.println(Lesson1ThreadLocal.local.get().toString()+":third step");
   }
   public void fourthStep(){
       System.out.println(Lesson1ThreadLocal.local.get().toString()+":fourth step");
   }
   public void fStep(){
       System.out.println(Lesson1ThreadLocal.local.get().toString()+":fifth step");
   }
}