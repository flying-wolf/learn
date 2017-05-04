package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	
	/** 
	 * @Title: 叫声 
	 * @Description: TODO
	 * @author Ma.Chao
	 * @return: void
	 */
	public void performQuack(){
		quackBehavior.quack();
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
	public void performFly(){
		flyBehavior.fly();
	}
}
