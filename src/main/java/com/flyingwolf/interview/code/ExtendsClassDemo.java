package com.flyingwolf.interview.code;

public class ExtendsClassDemo {
	class ClassA {
		public void show(){
			show1();
		}
		public void show1(){
			System.out.println("我");
		}
	}
	
	class ClassB extends ClassA {
		public void show1(){
			System.out.println("爱");
		}
	}
	
	class ClassC extends ClassB {
		public void show(){
			super.show();
		}
		
		public void show1(){
			System.out.println("你");
		}
	}
	
	public void test(){
		ClassA a = new ClassB();
		a.show();
		
		ClassB b = new ClassC();
		b.show();
	}
	
	public static void main(String[] args) {
		ExtendsClassDemo e = new ExtendsClassDemo();
		e.test();
	}
}
