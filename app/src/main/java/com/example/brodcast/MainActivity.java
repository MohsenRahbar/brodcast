package com.example.brodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            MyReceiver myre = new MyReceiver();
            registerReceiver(myrec, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));

        }
    }
}