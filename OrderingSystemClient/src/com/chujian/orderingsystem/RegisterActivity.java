package com.chujian.orderingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chujian.orderingsystem.R.color;

public class RegisterActivity extends Activity implements OnClickListener{
	private EditText etPhone;
	private TextView tvPhone;
	private ImageButton ibDeletePhone;
	private Button btNext;
	
	private CharSequence charSequence;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_regist_1);
		
		etPhone=(EditText) findViewById(R.id.et_phone);
		tvPhone=(TextView) findViewById(R.id.tv_phone);
		ibDeletePhone=(ImageButton) findViewById(R.id.ib_delete_phone);
		btNext=(Button) findViewById(R.id.bt_next);
		
		ibDeletePhone.setOnClickListener(this);
		btNext.setOnClickListener(this);
		
		
		etPhone.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String text = s.toString();
				tvPhone.setText(s);
				
				if (text.length() >= 4 && text.length() <= 7) {
					String s1 = text.substring(0, 3);
					String s2 = text.substring(3, text.length());
					tvPhone.setText(s1+"-"+s2);
				}else if (text.length() >= 7) {
					String s1 = text.substring(0, 3);
					String s2 = text.substring(3, 7);
					String s3 = text.substring(7, text.length());
					tvPhone.setText(s1 + "-" + s2 + "-" + s3);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				charSequence=s;
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(charSequence.length()==0){
					tvPhone.setVisibility(View.GONE);
				}else{
					tvPhone.setVisibility(View.VISIBLE);
				}
				if(charSequence.length()==11){
					btNext.setBackgroundResource(R.drawable.bt_blue);
					btNext.setEnabled(true);
				}else{
					btNext.setBackgroundColor(color.color_gray);
//					电话号码不正确是不可点击
					btNext.setEnabled(false);
				}
			}
		});
			
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ib_delete_phone:
			etPhone.setText("");
			break;
		case R.id.bt_next:
			Intent intent=new Intent();
			intent.putExtra("phoneNumb", etPhone.getText().toString());
			intent.setClass(RegisterActivity.this, RegisterActivityNext.class);
			startActivity(intent);
			break;
			
			default:break;
			
		}
	}
}
