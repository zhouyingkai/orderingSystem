package com.chujian.Threads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class HttpClientThread extends Thread{
	private String url;
	private Handler handler;
	public HttpClientThread(String url){
		this.url=url;
		
	}
	public HttpClientThread(String url,Handler handler){
		this.url=url;
		this.handler=handler;
	}
	private String name;
	private String age;
	
	public HttpClientThread(String url, String name, String age) {
		super();
		this.url = url;
		this.name = name;
		this.age = age;
	}
	private void dohttpClientGet(){
		HttpGet httpGet=new HttpGet(url);
		HttpClient client=new DefaultHttpClient();
		HttpResponse response;
		try {
			response=client.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				String content=EntityUtils.toString(response.getEntity());
				System.out.println("content---->"+content);
				Log.i("content", content);
				
//				将消息发送回主线程
				Message msg=new Message();
				msg.obj=content;
				handler.sendMessage(msg);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
//	使用post方式时中文乱码
	private void dohttpClientPost(){
		HttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(url);
		ArrayList<NameValuePair>list =new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("name", name));
		list.add(new BasicNameValuePair("age", age));
		try {
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse response=client.execute(post);
			if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				String content =EntityUtils.toString(response.getEntity());
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 dohttpClientGet();
//		dohttpClientPost();
	}
}
