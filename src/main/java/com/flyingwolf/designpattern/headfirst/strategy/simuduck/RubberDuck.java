package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class RubberDuck extends Duck {
	
	public void quack() {
		System.out.println("叫声是吱吱叫！");
	}

	@Override
	public void display() {
		System.out.println("外观是橡皮鸭！");
	}

	
	public void fly() {
		//不会飞
	}
}
