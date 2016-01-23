package com.example.assignmentsectionlist1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by EOM on 2016-01-23.
 */
public class ChildViewHolder extends RecyclerView.ViewHolder{

    TextView text_child;
    public ChildViewHolder(View itemView) {
        super(itemView);
        text_child = (TextView)itemView.findViewById(R.id.text_child_title);
    }

    public void setChildItem(ChildItem child){
        text_child.setText(child.childName);
        text_child.setTextSize(child.fontSize);
    }
}
