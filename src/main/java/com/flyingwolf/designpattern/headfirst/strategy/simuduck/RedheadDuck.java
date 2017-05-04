package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		System.out.println("外观是红头鸭！");
	}

}
