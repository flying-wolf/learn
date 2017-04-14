package com.flyingwolf.javacode.socket.socketdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Ma.Chao
 * Socket服务端
 * 1.创建ServerSocket对象,绑定监听端口
 * 2.调用accept()方法监听客户端请求
 * 3.开启输入流，读取客户端请求
 * 4.开启输出流，响应客户端请求
 * 5.关闭相关资源
 */
public class Server {
	public static void start() throws IOException{
		int port = 10086;//端口号
		//1.创建一个服务端Socket,绑定指定的端口监听
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(port);
		//2.调用accept()方法开始监听,等待客户端连接
		Socket socket = server.accept();
		//3.获取输入流,并获取客户端信息
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("我是服务端,客户端说："+info);
		}
		//关闭socket输入流
		socket.shutdownInput();
		//4.获取输出流，响应客户端请求
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("欢迎您！");
		pw.flush();
		
		//5.关闭资源
		is.close();
		isr.close();
		br.close();
		os.close();
		pw.close();
		socket.shutdownOutput();
		socket.close();
	}
}
