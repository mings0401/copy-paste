package com.sunming.copypaste;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by minkyujo on 2016. 12. 10..
 */

public class MySQLiteHandler {
    //DB 관련 변수
    private MySQLiteOpenHelper helper;
    String dbName = "click50.db";
    int dbVersion = 1; // 데이터베이스 버전
    private SQLiteDatabase db;

   public MySQLiteHandler(Context context){
       // sqLite3 : 모바일 용으로 제작된 경량화 DB
       helper = new MySQLiteOpenHelper(context, dbName, null, dbVersion);

       try {
           db = helper.getWritableDatabase(); // 읽고 쓸수 있는 DB
           //db = helper.getReadableDatabase(); // 읽기 전용 DB select문
       } catch (SQLiteException e) {
           e.printStackTrace();
       }
   }

    /**
     * DB에 네 text집어넣기
     */
    public void insertMyText (String title, String contents) {
        db.execSQL("insert into myText (title, contents) values('"+title+"', '"+contents+"');");
    }

    /**
     * DB에서 목록 가져오기
     */
    public void getMyText() {
        Cursor c = db.rawQuery("select * from myText;", null);
        int _id = 0; String title="", contents="";
        while(c.moveToNext()) {

        }
    }
}

