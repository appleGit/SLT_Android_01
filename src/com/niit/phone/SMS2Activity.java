package com.niit.phone;


import java.util.Iterator;
import java.util.List;

import com.niit.slt_android_01.R;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS2Activity extends Activity implements OnClickListener{
	private Button btnSubmit;
	private EditText etPhoneNum;
	private EditText etSMSContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms2);
		
		btnSubmit= (Button) findViewById(R.id.btn_submit);
		etPhoneNum=(EditText) findViewById(R.id.et_phonenum);
		etSMSContent=(EditText) findViewById(R.id.et_smscontent);
		btnSubmit.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			sendSMS();
			break;

		default:
			break;
		}
	}
	
	public void sendSMS() {
		String phone=etPhoneNum.getText().toString();
		if (TextUtils.isEmpty(phone)) {
			Toast.makeText(this, "号码呢？", Toast.LENGTH_SHORT).show();
		}
		String smscontent=etSMSContent.getText().toString();
		if (TextUtils.isEmpty(smscontent)) {
			Toast.makeText(this, "说点什么", Toast.LENGTH_SHORT).show();
		}
		
		SmsManager smsManager=SmsManager.getDefault();
		List<String> contentList=smsManager.divideMessage(smscontent);
		for (String s : contentList) {
			smsManager.sendTextMessage(phone, null, s, null, null);
		}
		Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
	}
}
