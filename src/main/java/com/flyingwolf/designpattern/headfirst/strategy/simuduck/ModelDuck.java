package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class ModelDuck extends Duck {

	public ModelDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	
	@Override
	public void display() {
		System.out.println("模型鸭！");
	}

}
