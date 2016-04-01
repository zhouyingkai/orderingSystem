package com.chujian.HttpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientUtil {
	public static String httpClientGet(String url) throws IOException{
		URL httpUrl=new URL(url);
		HttpURLConnection conn=(HttpURLConnection) httpUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setReadTimeout(500);
		
//		获取数据
		BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String str;
		StringBuffer sb=new StringBuffer();
		while((str=reader.readLine())!=null){
			sb.append(str);
		}
		return str;
	}
	
	public static String httpClientPost(String baseUrl,String content) throws IOException{
		URL httpUrl=new URL(baseUrl);
		HttpURLConnection conn=(HttpURLConnection) httpUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setReadTimeout(5000);
		OutputStream out=conn.getOutputStream();
		out.write(content.getBytes());
//		接收服务器传过来的数据
		BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb=new StringBuffer();
		String str;
		while((str=reader.readLine())!=null){
			sb.append(str);
		}
		
		return str;
	}
}
