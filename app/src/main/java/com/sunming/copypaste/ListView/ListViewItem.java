package com.sunming.copypaste.ListView;

/**
 * Created by minkyujo on 2016. 12. 10..
 */

public class ListViewItem {
    private String title ;
    private String contents;

    public ListViewItem(String title, String contents){
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
}
