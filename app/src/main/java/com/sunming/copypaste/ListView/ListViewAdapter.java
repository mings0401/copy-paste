package com.sunming.copypaste.ListView;

/**
 * Created by minkyujo on 2016. 12. 11..
 */
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.sunming.copypaste.MainActivity;
import com.sunming.copypaste.R;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListViewItem> {

    private List<ListViewItem> items;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context, int textViewResourceId,
                           List<ListViewItem> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflater.inflate(R.layout.listview, null);
        }

        // 현재 position 의 내용을 View 로 작성하여 리턴
        final ListViewItem item = (ListViewItem) items.get(position);

        if (item != null) {

            TextView titleText = (TextView) view.findViewById(R.id.listViewText);
            titleText.setTypeface(Typeface.DEFAULT_BOLD);
            titleText.setText(item.getTitle());

        }

        Button button = (Button)view.findViewById(R.id.listViewBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)MainActivity.mContext).copyClipboard(item.getContents());
                Log.e("title",item.getContents());
            }
        });

        return view;
    }

}