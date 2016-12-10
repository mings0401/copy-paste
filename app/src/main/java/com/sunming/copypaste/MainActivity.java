package com.sunming.copypaste;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteHandler ms = new MySQLiteHandler(this);
        Log.e("matthew","as");
        ms.insertMyText("123","456");
        ms.getMyText();
    }
}
