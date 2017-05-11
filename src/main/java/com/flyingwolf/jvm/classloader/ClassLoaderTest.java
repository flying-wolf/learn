package com.flyingwolf.jvm.classloader;

/** 
 * @ClassName: ClassLoaderTest 
 * @Description: 寻找类加载器
 * @author: Ma.Chao
 * @date: 2017年5月11日 上午11:09:39  
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		/*
		 * 启动类加载器输出结果为：null
		 * 这是因为我们默认使用的虚拟机启动类加载器(Bootstrap Loader)是用C++实现的,
		 * 找不到一个确定的返回父Loader的方式,所以返回null。
		 */
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		System.out.println("应用类加载器（AppClassLoader）："+cl);
		System.out.println("扩展类加载器（ExtClassLoader）："+cl.getParent());
		System.out.println("启动类加载器（Bootstrap Loader）："+cl.getParent().getParent());
	}

}
