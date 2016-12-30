package com.hong.uistudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("on", "onCreate: "+getApplicationContext().getPackageResourcePath()+"/files");
        Log.i("on", "onCreate: "+getApplicationContext().getFilesDir().getAbsolutePath());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_main_collapsing:
                intent.setClass(this, CollapsingLayout.class);
                startActivity(intent);
                break;
            case R.id.btn_main_Notification:
                intent.setClass(this, NotificationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_main_middleExtrude:
                intent.setClass(this, MiddleExtrudeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
