package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class MallardDuck extends Duck {
	
	public MallardDuck(){
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("外观是绿头鸭！");
	}

}
