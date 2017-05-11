package com.flyingwolf.jvm.classloader;

public class StaticLoaderTest {
	static {
		System.out.println("静态初始代码块被执行了！");
	}
}
