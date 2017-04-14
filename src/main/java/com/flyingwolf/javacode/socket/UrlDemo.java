package com.flyingwolf.javacode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL(Uniform Resource Locator)统一资源定位符，表示Internet上某一资源的地址，协议名：资源名称
 */
public class UrlDemo {

	/**
	 * 显示url信息内容
	 */
	public static void viewUrlCentent(){
		try {
			URL baidu = new URL("http://www.baidu.com");
			URL url = new URL(baidu,"index.html?username=tom#test");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			System.out.println("端口："+url.getPort());
			System.out.println("文件："+url.getFile());
			System.out.println("路径："+url.getPath());
			System.out.println("相对路径"+url.getRef());
			System.out.println("查找内容"+url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取url内容
	 */
	public static void readUrlCentent() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			URL url = new URL("https://getpocket.com/a/read/1256659847");
			is = url.openStream();
			isr = new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(isr);
			String data = br.readLine();
			while(data != null){
				System.out.println(data);
				data = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(is != null)
					is.close();
				if(isr != null)
					isr.close();
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		viewUrlCentent();
		readUrlCentent();
	}

}
