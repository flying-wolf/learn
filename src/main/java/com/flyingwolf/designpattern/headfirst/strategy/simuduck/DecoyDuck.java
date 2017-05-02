package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class DecoyDuck extends Duck {

	@Override
	public void display() {
		System.out.println("外观是诱饵鸭！");
	}
	
	public void quack(){
		//不会叫
	}
	
	public void fly() {
		//不会飞
	}

}
