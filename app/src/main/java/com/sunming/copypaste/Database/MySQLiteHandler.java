package com.sunming.copypaste.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.sunming.copypaste.Util.MyText;

import java.util.HashMap;

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
    public HashMap getMyText() {
        Cursor c = db.rawQuery("select * from myText;", null);
        int _id = 0; String title="", contents="";
        HashMap<Integer, MyText> map = new HashMap<Integer, MyText>();

        while(c.moveToNext()) {
            MyText myText = new MyText(c.getInt(0), c.getString(1), c.getString(2));

            map.put(c.getInt(0), myText);
        }
        return map;
    }

    /**
     * _id값으로 db에서 삭제하는 함수
     * @param _id : _id값
     */
    public void delete(int _id) {
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM MYTEXT WHERE _id='" + _id + "';");
    }


}

