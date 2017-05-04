package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class DecoyDuck extends Duck {
	
	public DecoyDuck(){
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("外观是诱饵鸭！");
	}
	
}
