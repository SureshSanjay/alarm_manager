package com.example.androidalarmmanagerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {



	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "From service, onCreate",Toast.LENGTH_SHORT).show();
		Log.d("FROM SERVICE" , "FROM SERVICE");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "From service, onStartCommand",Toast.LENGTH_LONG).show();
		Log.d("FROM SERVICE" , "FROM SERVICE");
		return super.onStartCommand(intent, flags, startId);
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
		public void onDestroy() {
			super.onDestroy();
			Log.d("FROM SERVICE" , "Service Destroyed");
		}


}
