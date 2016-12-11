package com.sunming.copypaste;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.sunming.copypaste.Database.MySQLiteHandler;
import com.sunming.copypaste.ListView.ListViewAdapter;
import com.sunming.copypaste.ListView.ListViewItem;
import com.sunming.copypaste.Util.MyText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {
    MySQLiteHandler ms;
    private List<ListViewItem> myTextItem;
    private ListViewAdapter myTextAdapter;
    private ListView myTextListVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ms = new MySQLiteHandler(this);
        myTextListVeiw = (ListView) findViewById(R.id.myCopyList);

        setCurrentMyTextList();


    }

    /**
     * List에 넣을 목록들 가져와서 뿌려주는 함수
     */
    public void setCurrentMyTextList(){
        HashMap map = ms.getMyText();
        myTextItem = new ArrayList<ListViewItem>();

        Iterator<Integer> keys = map.keySet().iterator();
        while ( keys.hasNext() ) {
            int key = keys.next();
            MyText mytext = (MyText) map.get(key);
            int value = mytext.getId();
            String title = mytext.getTitle();
            myTextItem.add(new ListViewItem(title));
            Log.e("matthew123","value : " + value);
        }

        // 북마크 Adapter 작성
        myTextAdapter = new ListViewAdapter(this, R.layout.listview, myTextItem);
        myTextListVeiw.setAdapter(myTextAdapter);

    }

    /**
     * clipboard에 글자 복사하는 함수
     * @param contents : 복사할 내용
     */
    public void copyClipboard(String contents){
        final ClipboardManager clipboardManager =  (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboardManager.setText(contents);
    }



}
