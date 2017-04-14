package com.flyingwolf.javacode.socket.socketdemo;

public class Test {

	public static void main(String[] args) {
		try {
			Server.start();
			Client.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
