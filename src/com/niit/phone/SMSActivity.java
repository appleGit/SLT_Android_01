package com.niit.phone;

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

/**
 * 用来发送短信
 * 
 * @author Admin
 *
 */
public class SMSActivity extends Activity implements OnClickListener {
	private EditText etPhoneNum;// 短信号码文本框
	private EditText edSMSContent;// 短信内容文本框
	private Button btnSubmit;// 发送短信的按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 绑定UI
		setContentView(R.layout.activity_sms);
		// 绑定UI元素
		etPhoneNum = (EditText) findViewById(R.id.et_phonenum);
		edSMSContent = (EditText) findViewById(R.id.et_smscontent);
		btnSubmit = (Button) findViewById(R.id.btn_submit);
		// 为发送短信按钮设置监听器，第二种方式
		btnSubmit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			SendSMS();
			break;

		default:
			break;
		}
	}

	/**
	 * 发送短信
	 */
	private void SendSMS() {
		// 1-先获取手机号码和短信内容
		String phone = etPhoneNum.getText().toString();
		if (TextUtils.isEmpty(phone)) {
			Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
			return;// 终止程序，返回界面
		}
		String smscontent = edSMSContent.getText().toString();
		if (TextUtils.isEmpty(smscontent)) {
			Toast.makeText(this, "短信内容不能为空", Toast.LENGTH_SHORT).show();
		}
		// 2-利用系统短信功能发送短信

		SmsManager smsManager = SmsManager.getDefault();// 得到一个发送短信的管理器的对象
		// smsManager.sendTextMessage(phone, null, smscontent, null,
		// null);//发送一个文本短信
		Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
		// 拆分短信
		List<String> contentList = smsManager.divideMessage(smscontent);
		for (String s : contentList) {
			smsManager.sendTextMessage(phone, null, s, null, null);
		}
	}

}
