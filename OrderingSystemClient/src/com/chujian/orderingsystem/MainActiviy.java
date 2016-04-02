package com.chujian.orderingsystem;

import cn.smssdk.SMSSDK;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActiviy extends Activity {
//	sms sdk 
	private static String APPKEY = "11261cbae90bc";
	private static String APPSECRET = "9ba8b5e63401c1ea8960622edb7ae3e6";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiy_main);
//		初始化mob sms sdk 
		SMSSDK.initSDK(this, APPKEY, APPSECRET);

		
		Button btn=(Button) findViewById(R.id.btn_go);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActiviy.this, LoginActivity.class);
				startActivity(intent);;
			}
		});
	}

}
