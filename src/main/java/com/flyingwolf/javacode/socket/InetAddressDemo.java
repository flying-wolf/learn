package com.flyingwolf.javacode.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类用于标识网络上的硬件资源，标识互联网协议(IP)地址。
 *
 */
public class InetAddressDemo {

	/**
	 * 显示本机IP信息
	 */
	public static void viewLocalHost(){
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("pc-name:"+address.getHostName());
			System.out.println("ip:"+address.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据传入参数显示IP信息
	 */
	public static void viewHostByName(String name){
		try {
			InetAddress address = InetAddress.getByName(name);
			System.out.println("pc-name:"+address.getHostName());
			System.out.println("ip:"+address.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		viewLocalHost();
		viewHostByName("192.168.1.235");
	}
	
}
