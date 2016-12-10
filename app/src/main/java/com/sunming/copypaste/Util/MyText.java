package com.sunming.copypaste.Util;

import android.util.Log;

/**
 * Created by minkyujo on 2016. 12. 10..
 */

public class MyText {
    private int _id = 0;
    private String title = "";
    private String contents = "";

    public MyText(int _id, String title, String contents){
        this._id = _id;
        this.title = title;
        this.contents = contents;
    }

    public int getId(){
        return this._id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContents(){
        return this.contents;
    }
}
