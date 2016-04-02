package com.chujian.orderingsystem;



import java.io.IOException;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

import com.chujian.HttpUtil.Constan;
import com.chujian.HttpUtil.HttpClientUtil;
import com.chujian.Threads.HttpClientThread;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener{
	private EditText mPhoneNumb;
	private EditText mPassword;
	private ImageButton mDeletePhone;
	private CheckBox mShowPasswrd;
	private Button mLogin;
	private Button mRegister;
	private TextView mForgetPass;
	private CheckBox mRememberPsd;
	
	private boolean smsFlag=false;
	private String smsPhone;
	SharedPreferences pref;
	Editor editor;
	
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_regist);
 		
		mPhoneNumb=(EditText) findViewById(R.id.et_phone);
		mPassword=(EditText) findViewById(R.id.et_pwd);
		mDeletePhone=(ImageButton) findViewById(R.id.ib_delete_phone);
		mShowPasswrd=(CheckBox) findViewById(R.id.cb_eye);
		mRememberPsd=(CheckBox) findViewById(R.id.cb_remember_psd);
		mLogin=(Button) findViewById(R.id.bt_login);
		mRegister=(Button) findViewById(R.id.bt_register);
		mForgetPass=(TextView) findViewById(R.id.tv_forget_pwd);
		
		mRegister.setOnClickListener(this);
		mForgetPass.setOnClickListener(this);
		mLogin.setOnClickListener(this);
		mDeletePhone.setOnClickListener(this);
		
		pref=getSharedPreferences("userInfo", MODE_PRIVATE);
		editor=pref.edit();
		String telNumb=pref.getString("phoneNumber", "");
		String password=pref.getString("password", "");
		if(telNumb==null){
			mRememberPsd.setChecked(false);
		}else{
			mRememberPsd.setChecked(true);
			mPhoneNumb.setText(telNumb);
			mPassword.setText(password);
		}
//		初始化handler
		handler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				String str=(String) msg.obj;
				if(str.trim().equals("loginFailed")){
					Toast.makeText(LoginActivity.this,str+",用户名或者密码错误", Toast.LENGTH_SHORT).show();
					
				}
				else
				{
					Toast.makeText(LoginActivity.this,"login succed,result="+str, Toast.LENGTH_SHORT).show();
//					保存用户名和密码
					if(mRememberPsd.isChecked()){
						editor.putString("phoneNumber",mPhoneNumb.getText().toString() );
						editor.putString("password", mPassword.getText().toString());
						editor.commit();
					}else{
						editor.remove("phoneNumber");
						editor.remove("password");
						editor.commit();
					}
				}
			}
		};
		
//		是否显示密码的监听
		mShowPasswrd.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					mPassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
					
				}else{
					mPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				}
				
			}
		});
		
//		记住密码的监听
		mRememberPsd.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					
				}else{
					
				}
			}
		});
 	
	}

	@Override
	public void onClick(View v) {
		Intent intent =new Intent();
		switch (v.getId()) {
//		登录
		case R.id.bt_login:
			String phone=mPhoneNumb.getText().toString();
			String passwd=mPassword.getText().toString();
			String url=Constan.BASE_URL+"LoginServlet"+"?phoneNumb="+phone+"&password="+passwd;
			new HttpClientThread(url,handler).start();;
			Toast.makeText(LoginActivity.this,"login ", Toast.LENGTH_SHORT).show();
			break;
//		注册
		case R.id.bt_register:
			SmsValidate(true);
			break;
//		忘记密码
		case R.id.tv_forget_pwd:
			SmsValidate(false);
			break;
//		删除电话号码
		case R.id.ib_delete_phone:
//			清空电话号码
			mPhoneNumb.setText("");
			break;
		default:
			break;
		}
		
	}
	
	private void SmsValidate( boolean flag){
//		**************************
//		mod sms sdk 接入
		//打开注册页面
		final boolean smsFlag=flag;
		RegisterPage registerPage = new RegisterPage();
		registerPage.setRegisterCallback(new EventHandler() {
		public void afterEvent(int event, int result, Object data) {
		// 解析注册结果
		if (result == SMSSDK.RESULT_COMPLETE) {
		@SuppressWarnings("unchecked")
		HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
		String country = (String) phoneMap.get("country");
		String phone = (String) phoneMap.get("phone"); 
		smsPhone=phone;//获取电话号码
		Log.i("LoginActivity", country+" "+phone);
		Toast.makeText(LoginActivity.this,country+" "+phone, Toast.LENGTH_LONG).show();;
		Intent intent =new Intent();
		intent.putExtra("phoneNumb",smsPhone);
		if(smsFlag){
//			注册
			intent.setClass(LoginActivity.this,RegisterActivityNext.class);
			startActivity(intent);
			
		}else{
//			找回密码
			intent.setClass(LoginActivity.this,ForgetPasswordAct.class);
			startActivity(intent);
		}
		
		}else{
//			验证失败
//			关闭界面
			Toast.makeText(LoginActivity.this,"验证失败", Toast.LENGTH_SHORT).show();
		}
		}
		});
		registerPage.show(this);
//	*************************
		Toast.makeText(LoginActivity.this, ""+smsFlag, Toast.LENGTH_SHORT).show();;
	}
	
	
	
	
}

