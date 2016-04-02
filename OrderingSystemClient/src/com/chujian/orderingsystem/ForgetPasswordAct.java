package com.chujian.orderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chujian.HttpUtil.Constan;
import com.chujian.Threads.HttpClientThread;


public class ForgetPasswordAct extends Activity implements OnClickListener{
	private EditText etPassword;
	private Button btnConfirm;
	private TextView tvPhone;
	private String phoneNumb;
	private Handler mHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_forget_psd);
		tvPhone=(TextView) findViewById(R.id.tv_fg_tel_num);
		btnConfirm=(Button) findViewById(R.id.btn_fg_confirm);
		etPassword=(EditText) findViewById(R.id.et_fg_pwd);
		btnConfirm.setOnClickListener(this);
		mHandler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				String str=(String) msg.obj;
				if(str.trim().equals("changedSuccess")){
					Toast.makeText(ForgetPasswordAct.this, "密码修改成功", Toast.LENGTH_SHORT).show();
					ForgetPasswordAct.this.finish();
				}else{
					Toast.makeText(ForgetPasswordAct.this, str+"密码修改失败", Toast.LENGTH_SHORT).show();
					ForgetPasswordAct.this.finish();
				}
			}
		};
		
//		获取电话号码
		Intent intent=getIntent();
		phoneNumb=intent.getStringExtra("phoneNumb");
		tvPhone.setText(phoneNumb);
	}
	@Override
	public void onClick(View v) {
			String password=etPassword.getText().toString();
			Toast.makeText(ForgetPasswordAct.this, "修改密码", Toast.LENGTH_SHORT).show();
			String url=Constan.BASE_URL+"ForgetPsdServlet"+"?phoneNumb="+phoneNumb+"&password="+password;
			new HttpClientThread(url, mHandler).start();;
	}
}
