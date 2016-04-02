package com.chujian.orderingsystem;


import com.chujian.HttpUtil.Constan;
import com.chujian.Threads.HttpClientThread;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivityNext extends Activity implements OnClickListener{
	private Button btnConfirm;
	private TextView tvPhoneN;
	private EditText etPassword;
	private CheckBox cbShowPsd;
	private String phoneNumb;
	private Handler mHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_regist_2);
		
		
		btnConfirm=(Button) findViewById(R.id.btn_confirm);
		tvPhoneN=(TextView) findViewById(R.id.tv_tel_num);
		etPassword=(EditText) findViewById(R.id.et_pwd);
		cbShowPsd=(CheckBox) findViewById(R.id.cb_show_psd);
		
		btnConfirm.setOnClickListener(this);
		
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				String str = (String) msg.obj;
				if (str.trim().equals("alreadyRegistered")) {
					tvPhoneN.setTextColor(Color.RED);
					Toast.makeText(RegisterActivityNext.this, "账号已经被注册",Toast.LENGTH_SHORT).show();
//					RegisterActivityNext.this.finish();
				} 
				else if (str.trim().equals("success")) {
					Toast.makeText(RegisterActivityNext.this, str,Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(RegisterActivityNext.this,LoginActivity.class);
					startActivity(intent);
					RegisterActivityNext.this.finish();
				} else {
					Toast.makeText(RegisterActivityNext.this, "failed",
							Toast.LENGTH_SHORT).show();
				}
			}
		};
		
		
		
//		获取电话号码
		Intent intent=getIntent();
		phoneNumb=intent.getStringExtra("phoneNumb");
		tvPhoneN.setText(phoneNumb);
		
//		设置密码 
		cbShowPsd.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					etPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
					
				}else{
					etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				}
				
			}
			
		});
		
		
		
	}


	@Override
	public void onClick(View v) {
		String password=etPassword.getText().toString();
//		Toast.makeText(RegisterActivityNext.this, phoneNumb+"\n"+password, Toast.LENGTH_SHORT).show();
		String url=Constan.BASE_URL+"RegisterServlet"+"?phoneNumb="+phoneNumb+"&password="+password;
		new HttpClientThread(url,mHandler).start();
	}
}














