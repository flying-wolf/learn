package com.flyingwolf.javacode.arrays;

public class ArraysDemo {
	
	/** 
	 * @Title: ArraysClassTest 
	 * @Description: 数组类型
     * 				 1.数组是Object的直接子类
     * 				 2.数组的类名是由若干个"["和数组元素类型的内部名称组成
     * 				 3."["的个数由数组的维度决定
	 * @author Ma.Chao
	 * @return: void
	 */
	public static void arraysClassTest(){
		int[] i = new int[10];
		System.out.println(i.getClass().getName());
		
		int[][] ii = new int[10][10];
		System.out.println(ii.getClass().getName());
		
		int[][][] iii = new int[10][10][10];
		System.out.println(iii.getClass().getName());
		
		double[] s = new double[10];
		System.out.println(s.getClass().getName());
		
		int[] array = new int[10];
		
		System.out.println("array的父类是："+array.getClass().getSuperclass().getName());
		System.out.println("array的类名是："+array.getClass().getName());
	}
	
	/** 
	 * @Title: arraysLengthTest 
	 * @Description: 
	 * 				1.数组类没有声明任何成员变量、方法、构造函数、Annotation、length，它是个空类
	 * 				2.
	 * @author Ma.Chao
	 * @return: void
	 */
	public static void arraysLengthTest(){
		int[] array = new int[10];
		Class clazz = array.getClass();
		System.out.println(clazz.getDeclaredFields().length);   
        System.out.println(clazz.getDeclaredMethods().length);   
        System.out.println(clazz.getDeclaredConstructors().length);   
        System.out.println(clazz.getDeclaredAnnotations().length);   
        System.out.println(clazz.getDeclaredClasses().length);   
	}
	

	public static void main(String[] args) {
		arraysClassTest();
		arraysLengthTest();
	}

}
