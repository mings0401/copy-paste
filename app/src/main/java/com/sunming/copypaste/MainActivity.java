package com.sunming.copypaste;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
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
    public static Context mContext;
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

        mContext = this;

        setCurrentMyTextList();

//        myTextListVeiw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ListView listView = (ListView) parent;
//                // TODO 아이템 클릭시에 구현할 내용은 여기에.
//                String item = (String) listView.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, "123123", Toast.LENGTH_LONG).show();
//            }
//        });
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
            String contents = mytext.getContents();

            myTextItem.add(new ListViewItem(title, contents));
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
