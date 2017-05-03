package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("实现鸭子飞行！");
	}

}
