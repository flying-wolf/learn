package com.flyingwolf.designpattern.headfirst.strategy.simuduck;

public class MainTest {

	public static void main(String[] args) {
		MallardDuck mDuck = new MallardDuck();
		mDuck.performQuack();
		mDuck.swim();
		mDuck.display();
		mDuck.performFly();
		System.out.println("------------------------------------");
		RedheadDuck rDuck = new RedheadDuck();
		rDuck.performQuack();
		rDuck.swim();
		rDuck.display();
		rDuck.performFly();
		System.out.println("------------------------------------");
		RubberDuck ruDuck = new RubberDuck();
		ruDuck.performQuack();
		ruDuck.swim();
		ruDuck.display();
		ruDuck.performFly();
		System.out.println("------------------------------------");
		DecoyDuck dDuck = new DecoyDuck();
		dDuck.performQuack();
		dDuck.swim();
		dDuck.display();
		dDuck.performFly();
		System.out.println("------------------------------------");
		ModelDuck md = new ModelDuck();
		md.performQuack();
		md.display();
		md.performFly();
		md.setFlyBehavior(new FlyRocketPowered());
		md.performFly();
		
	}

}
