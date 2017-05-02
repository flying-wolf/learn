package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class MainTest {

	public static void main(String[] args) {
		MallardDuck mDuck = new MallardDuck();
		mDuck.quack();
		mDuck.swim();
		mDuck.display();
		mDuck.fly();
		System.out.println("------------------------------------");
		RedheadDuck rDuck = new RedheadDuck();
		rDuck.quack();
		rDuck.swim();
		rDuck.display();
		rDuck.fly();
		System.out.println("------------------------------------");
		RubberDuck ruDuck = new RubberDuck();
		ruDuck.quack();
		ruDuck.swim();
		ruDuck.display();
		ruDuck.fly();
		System.out.println("------------------------------------");
		DecoyDuck dDuck = new DecoyDuck();
		dDuck.quack();
		dDuck.swim();
		dDuck.display();
		dDuck.fly();
		
	
		
	}

}
