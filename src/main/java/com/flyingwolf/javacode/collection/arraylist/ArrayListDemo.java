package com.flyingwolf.javacode.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
	static ArrayList<Object> listA = new ArrayList<Object>();
	static ArrayList<Object> listB = new ArrayList<Object>();
	
	public static void ensureCapacityTest(){
		//初始化长度
		final int INIT_SIZE = 10000000;
		Object obj = new Object();
		//使用初始化容量方式ensureCapacity()
		listB.ensureCapacity(INIT_SIZE);
		long startB = System.currentTimeMillis();
		for (int i = 0; i < INIT_SIZE; i++) {
			listB.add("ii"+i);
		}
		long endB = System.currentTimeMillis();
		System.out.println("----使用初始化容量方式用时："+(endB-startB));
		System.out.println();
		//不使用初始化容量方式
		long startA = System.currentTimeMillis();
		for (int i = 0; i < INIT_SIZE; i++) {
			listA.add("ii"+i);
		}
		long endA = System.currentTimeMillis();
		System.out.println("----不使用初始化容量方式用时："+(endA-startA));
		System.out.println();
		
	}
	
	
	public static void test1 (){
		final int MAX_SIZE = 10000000;
		Object[] objs = new Object[MAX_SIZE];
		long start = System.currentTimeMillis();
		for (int i = 0; i < objs.length; i++) {
			objs[i] = i;
		}
		System.out.println("Object数组add千万数值(初始化容量方式)耗时："+(System.currentTimeMillis() - start));
		System.out.println();
	}
	
	public static void test2(){
		final int MAX_SIZE = 10000000;
		int size = 10;
		Object[] objs = new Object[size];
		long start = System.currentTimeMillis();
		for (int i = 0; i < MAX_SIZE; i++) {
			if(i >= size){
				size = size + (size >> 1);
				objs = Arrays.copyOf(objs, size);
			}
			objs[i] = i;
		}
		System.out.println("Object数组add千万数值(copyOf方式)耗时："+(System.currentTimeMillis() - start));
		System.out.println();
	}
	

	public static void main(String[] args) {
		//test2();
		//test1();\
		ensureCapacityTest();
	}

}
