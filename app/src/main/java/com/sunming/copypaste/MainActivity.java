package com.sunming.copypaste;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteHandler ms = new MySQLiteHandler(this);
        HashMap map = ms.getMyText();
        MyText myText = (MyText) map.get(1);
        Log.d("matthew main", myText.getContents());

    }
}
