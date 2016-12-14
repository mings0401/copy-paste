package com.sunming.copypaste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.sunming.copypaste.Database.MySQLiteHandler;

public class AddDialogActivity extends Activity {
    private  MySQLiteHandler ms;
    private EditText titleEditTxt, contentsEditTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_dialog);

        ms = new MySQLiteHandler(this);

        titleEditTxt = (EditText)findViewById(R.id.title_editTxt);
        contentsEditTxt = (EditText)findViewById(R.id.contents_editTxt);

        findViewById(R.id.saveBtn).setOnClickListener(mClickListener);
        findViewById(R.id.cancelBtn).setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.saveBtn:
                    String title = titleEditTxt.getText().toString();
                    String contents = contentsEditTxt.getText().toString();
                    ms.insertMyText(title, contents);
                    ((MainActivity)MainActivity.mContext).initListView();
                    ((MainActivity)MainActivity.mContext).setCurrentMyTextList();
                    finish();
                    break;
                case R.id.cancelBtn:
                    finish();
                    break;
            }
        }
    };

}
