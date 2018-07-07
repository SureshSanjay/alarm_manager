package com.example.androidalarmmanagerdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void startService(View v) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		int curent  = cal.get(Calendar.DAY_OF_MONTH );
		cal.set(Calendar.DAY_OF_MONTH,(curent+1));
		Intent i = new Intent(this, MyReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this,0, i, 0);
		AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
	}
	public void stopService(View v) {
		Intent i = new Intent(this, MyReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this,0, i, 0);
		AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		am.cancel(pi);
		
		Intent intent = new Intent(this, MyService.class);
		stopService(intent);
	}
}
