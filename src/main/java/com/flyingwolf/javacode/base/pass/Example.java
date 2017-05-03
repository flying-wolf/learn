package com.flyingwolf.javacode.base.pass;

public class Example {
	//值传递
	String str = new String("good");
	//引用传递
	char[] ch = { 'a', 'b', 'c' };
	public static void main(String args[]) {
		Example ex = new Example();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
	}
	public void change(String str, char ch[]) {
		//值传递,方法调用时传递的参数是按值的拷贝传递
		str = "test ok";
		//引用传递,方法调用时传递的变量所对应的内存空间的地址
		ch[0] = 'g';
	}
}