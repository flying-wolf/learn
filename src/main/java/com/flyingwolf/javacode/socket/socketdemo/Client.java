package com.flyingwolf.javacode.socket.socketdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Ma.Chao
 * Socket客户端
 * 1.创建Socket对象，指定需要链接的服务器地址和端口请求服务端
 * 2.链接建立后通过输出流向服务器发送请求信息
 * 3.通过输入留获取服务器响应信息
 * 4.关闭资源
 */
public class Client {
	
	public static void send() throws IOException {
		String localhost = "192.168.1.235";//地址
		int port = 10086;//端口
		//1.创建Socket对象，指定需要链接的服务器地址和端口请求服务端
		Socket socket = new Socket(localhost,port);
		//2.获取输出流，向服务器发消息
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.print("用户名：admin；密码：123");
		pw.flush();
		socket.shutdownOutput();
		//3.获取输入流,接受服务器的响应消息
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = br.readLine();
		while((info = br.readLine()) != null){
			System.out.println("我是客户端，服务器说："+info);
		}
		//4.关闭资源
		os.close();
		pw.close();
		is.close();
		isr.close();
		br.close();
		socket.shutdownInput();
		socket.close();
	}
}
