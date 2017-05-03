package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("橡皮鸭子吱吱叫！");
	}

}
