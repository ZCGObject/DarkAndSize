package com.ikang.mydark.aidltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.ikang.aidltest.IMyAidlInterface;
import com.ikang.mydark.R;

public class AidlTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView aidlContent, bindService, getServiceContent, unbindService;
    private IMyAidlInterface myAIDLService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);

        bindService = findViewById(R.id.bindService);
        getServiceContent = findViewById(R.id.getServiceContent);
        unbindService = findViewById(R.id.unbindService);
        aidlContent = findViewById(R.id.aidlContent);


        bindService.setOnClickListener(this);
        getServiceContent.setOnClickListener(this);
        unbindService.setOnClickListener(this);

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("Service--->>>" , "onServiceConnected");
            myAIDLService = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("Service--->>>" , "onServiceDisconnected");
            myAIDLService = null;
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bindService:
                Intent intent = new Intent();
                intent.setAction("com.ikang.aidl.my_service");
                //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
                intent.setPackage("com.ikang.aidltest");
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;

            case R.id.getServiceContent:
                try {
                    String str = myAIDLService.getString();
                    aidlContent.setText(myAIDLService.getBookName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.unbindService:
                aidlContent.setText("默认内容");
                unbindService(connection);
                break;
        }

    }
}