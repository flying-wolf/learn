package com.flyingwolf.javacode.collection.hashtable;

public class HashTableDemo {
	public static void init(){
		Hashtable<String, Object> ht = new Hashtable<>();
		ht.put("1", 1);
		ht.put("2", 2);
		ht.put("3", 3);
		System.out.println(ht.values().toString());
	}
	
	
	
	public static void main(String[] args) {
		init();
	}
}
