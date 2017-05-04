package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class RubberDuck extends Duck {
	
	public RubberDuck() {
		quackBehavior = new Squeak();
		flyBehavior = new FlyNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("外观是橡皮鸭！");
	}

}
