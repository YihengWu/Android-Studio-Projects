package edu.purdue.wu1271.lab13;

/**
 * Created by yihengwu on 11/14/17.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends ArrayAdapter {
    private List<Item> itemList;
    private Context context;
    public TodoListAdapter(@NonNull Context context, List<Item> itemList) {
        super(context, R.layout.list_item_layout);
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);
        Item item = itemList.get(position);
        TextView content = (TextView) rowView.findViewById(R.id.item_content);
        CheckBox checkBox = (CheckBox)rowView.findViewById(R.id.item_check);

        //TODO: 1. Set text in TextView content using the item's content field
        //         Use EditText's setText() method
        content.setText(item.getContent());
        //TODO: 2. Set checkbox as unchecked using CheckBox's setChecked() method
        checkBox.setChecked(false);

        return rowView;
    }

    @Override
    public int getCount(){
        return itemList!=null ? itemList.size() : 0;
    }

    public void setData(List<Item> itemList){
        this.itemList = itemList;
    }
}
