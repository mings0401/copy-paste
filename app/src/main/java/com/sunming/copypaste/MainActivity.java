package com.sunming.copypaste;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sunming.copypaste.Database.MySQLiteHandler;
import com.sunming.copypaste.ListView.ListViewAdapter;
import com.sunming.copypaste.ListView.ListViewItem;
import com.sunming.copypaste.Util.BackPressCloseHandler;
import com.sunming.copypaste.Util.MyText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {
    public static Context mContext;
    private BackPressCloseHandler backPressCloseHandler;
    MySQLiteHandler ms;
    private List<ListViewItem> myTextItem;
    private ListViewAdapter myTextAdapter;
    private ListView myTextListVeiw;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ms = new MySQLiteHandler(this);
        myTextListVeiw = (ListView) findViewById(R.id.myCopyList);

        mContext = this;

        settingAd(); //광고 셋팅

        setCurrentMyTextList(); //리스트뷰 뿌려주기

        findViewById(R.id.myTextAddBtn).setOnClickListener(mClickListener);

        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.myTextAddBtn:
                    Intent mainIntent = new Intent(getApplicationContext(), AddDialogActivity.class);
                    startActivity(mainIntent);
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    /**
     * 광고 셋팅해주는 함수
     */
    public void settingAd(){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView = (AdView) findViewById(R.id.mainAdView);
        mAdView.loadAd(adRequest);
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
     * ListView 비우기
     */
    public void initListView(){
        myTextListVeiw.setAdapter(null);
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
