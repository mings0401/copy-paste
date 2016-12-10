package com.sunming.copypaste;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.sunming.copypaste.Database.MySQLiteHandler;
import com.sunming.copypaste.Util.MyText;

import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends Activity {
    MySQLiteHandler ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ms = new MySQLiteHandler(this);
        setCurrentMyTextList();
    }

    /**
     * List에 넣을 목록들 가져와서 뿌려주는 함수
     */
    public void setCurrentMyTextList(){
        HashMap map = ms.getMyText();

        Iterator<Integer> keys = map.keySet().iterator();
        while ( keys.hasNext() ) {
            int key = keys.next();
            MyText mytext = (MyText) map.get(key);
            int value = mytext.getId();
            Log.e("matthew123","value : " + value);
        }


    }
}
