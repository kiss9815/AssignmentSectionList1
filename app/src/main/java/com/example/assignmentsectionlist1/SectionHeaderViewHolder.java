package com.example.assignmentsectionlist1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by EOM on 2016-01-23.
 */
public class SectionHeaderViewHolder extends RecyclerView.ViewHolder{
    TextView text_group;
    public SectionHeaderViewHolder(View itemView) {
        super(itemView);
        text_group = (TextView)itemView.findViewById(R.id.text_gourp_title);
    }

    public void setGroupItem(GroupItem group){
        text_group.setText(group.groupName);
    }
}
