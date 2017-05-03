package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("实现鸭子呱呱叫！");
	}

}
