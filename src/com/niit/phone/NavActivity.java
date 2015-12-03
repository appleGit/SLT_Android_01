package com.niit.phone;

import java.security.PrivilegedActionException;

import com.niit.slt_android_01.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NavActivity extends Activity implements OnClickListener {

	private Button btnPhone;
	private Button btnSMS;
	private Button btnsms2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 绑定UI
		setContentView(R.layout.activity_nav);

		// 绑定元素
		btnPhone = (Button) findViewById(R.id.btn_phone);
		btnSMS = (Button) findViewById(R.id.btn_sms);
		btnsms2=(Button) findViewById(R.id.btn_sms2);
		
		// 两个按钮都要设置监听器
		btnPhone.setOnClickListener(this);
		btnSMS.setOnClickListener(this);
		btnsms2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_phone:
			//跳转拨打电话页面
			Intent intent =new Intent();
			intent.setClass(NavActivity.this, MainActivity.class);
			startActivity(intent);
			finish();//停止当前的Activity。如果不写这个，则按返回键，会返回原来的Activity
			break;
		case R.id.btn_sms:
			//跳转发送短信页面
			Intent intent2 =new Intent(NavActivity.this, SMSActivity.class);
			startActivity(intent2);
			break;
			
		case R.id.btn_sms2:
			Intent intent3 =new Intent();
			intent3.setClass(NavActivity.this, SMS2Activity.class);
			startActivity(intent3);
			finish();
			break;

		default:
			break;
		}

	}

}
