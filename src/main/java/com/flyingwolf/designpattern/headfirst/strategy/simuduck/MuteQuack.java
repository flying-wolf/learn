package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		//什么也不做,鸭子不会叫
	}

}
