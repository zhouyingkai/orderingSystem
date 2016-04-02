package com.chujian.orderingsystem;

import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;


public class ForgetPasswordAct extends Activity{
	private EditText etPassword;
	private TextView tvPhone;
	private String phoneNumb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_forget_psd);
		tvPhone=(TextView) findViewById(R.id.tv_fg_tel_num);
		
//		获取电话号码
		Intent intent=getIntent();
		 phoneNumb=intent.getStringExtra("phoneNumb");
		tvPhone.setText(phoneNumb);
	}
}
