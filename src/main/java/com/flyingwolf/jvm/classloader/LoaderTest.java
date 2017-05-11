package com.flyingwolf.jvm.classloader;

public class LoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "com.flyingwolf.jvm.classloader.StaticLoaderTest";
		ClassLoader cl = LoaderTest.class.getClassLoader();
		System.out.println(cl);
		/*
		 * 使用ClassLoader.loadClass(name)方法来加载类不会执行初始化步骤,不会执行static代码块
		 * loadClass(name)方法内部调用loadClass(name,false)方法，第二个boolean参数表示目标对象是否进行链接，
		 * 不链接意味着不会执行包括初始化的一系列步骤,所以static代码块也不会执行
		 */
		cl.loadClass(className);
		
		/*
		 * 使用Class.forName(name)方法加载类会执行初始化步骤，初始化时会执行static代码块
		 * forName(name)方法内部实现是forName(name,true,loader),第二个boolean参数表示是否进行初始化
		 */
		Class.forName(className);
		
		/*
		 * 加载一个指定ClassLoader加载器的java类,并指定不进行初始化
		 */
		Class.forName(className,false,cl);
		
	}
}
