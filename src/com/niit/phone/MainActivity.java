package com.niit.phone;

import com.niit.slt_android_01.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 所有的活动都需要继承至Activity
 * 一个Activity相当于一个html页面
 * 
 * 注意点：
 * 1-R的包不能够导错。
 * 2-OnClickListener匿名内部类最好使用自动创建的，不要手写。
 * @author Admin
 *
 */
public class MainActivity extends Activity {
	private EditText editPhoneNum;
	private Button btnSubmit;
	
	/**
	 * 活动一开始加载就执行
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//绑定XML画面（先告诉这个JAVA类，我处理的是哪个画面）
		setContentView(R.layout.activity_main);
		//得到画面的里面的控件(找到事件源)
		//绑定变量和页面中的控件
		editPhoneNum = (EditText)findViewById(R.id.et_phonenum);
		btnSubmit = (Button)findViewById(R.id.btn_submit);
		//设置btn的监听click事件.
		// 第一种方法：使用匿名内部类的方式
		btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//执行拨打电话的方法
				CallPhone();
			}
		});
	}

	/**
	 * 执行拨打电话的方法
	 */
	private void CallPhone(){
		//1-需要电话号码
		String number= editPhoneNum.getText().toString();
		//判断电话号码是否为空，为空则弹出对话框，警告用户
		if(TextUtils.isEmpty(number)){
			Toast.makeText(this, "电话号码不能为空", Toast.LENGTH_LONG).show();
			return;
		}
		//2-调用手机系统里面的拨打电话的拨号盘拨出电话
		Intent intent = new Intent();//意图
		intent.setAction(Intent.ACTION_CALL);//我的意图是想拨打电话
		intent.setData(Uri.parse("tel:"+number));//设置需要拨打的号码
		
		//执行意图（拨打电话）
		startActivity(intent);//执行一个跳转画面的动作
	}
}
