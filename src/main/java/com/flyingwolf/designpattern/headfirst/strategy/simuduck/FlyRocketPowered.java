package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("火箭动力飞行中！");
	}

}
