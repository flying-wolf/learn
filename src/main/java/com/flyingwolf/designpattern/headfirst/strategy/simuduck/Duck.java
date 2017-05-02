package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public abstract class Duck {
	/** 
	 * @Title: 叫声 
	 * @Description: TODO
	 * @author Ma.Chao
	 * @return: void
	 */
	public void quack(){
		System.out.println("叫声是呱呱叫！");
	}
	
	/** 
	 * @Title: 游泳 
	 * @Description: TODO
	 * @author Ma.Chao
	 * @return: void
	 */
	public void swim(){
		System.out.println("正在游泳！");
	}
	
	/** 
	 * @Title: 外观 
	 * @Description: TODO
	 * @author Ma.Chao
	 * @return: void
	 */
	public abstract void display();
	
	/** 
	 * @Title: 飞行 
	 * @Description: TODO
	 * @author Ma.Chao
	 * @return: void
	 */
	public void fly(){
		System.out.println("鸭子会飞！");
	}
}
