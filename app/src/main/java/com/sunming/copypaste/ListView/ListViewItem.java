package com.sunming.copypaste.ListView;

/**
 * Created by minkyujo on 2016. 12. 10..
 */

public class ListViewItem {
    private int _id;
    private String title ;
    private String contents;

    public ListViewItem(int _id, String title, String contents){
        this._id = _id;
        this.title = title;
        this.contents = contents;
    }

    public void setTitle(String title) {
        this.title = title ;
    }

    public String getTitle() {
        return this.title ;
    }

    public void setContents(String contents){
        this.contents = contents;
    }

    public String getContents(){
        return this.contents;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public int get_id(){
        return this._id;
    }
}
