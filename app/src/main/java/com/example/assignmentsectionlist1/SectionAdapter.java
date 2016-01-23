package com.example.assignmentsectionlist1;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by EOM on 2016-01-23.
 */
public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<GroupItem> items = new ArrayList<GroupItem>();
    Random r = new Random();

    public void put(String groupName, String childName){
        GroupItem group = null;
        for(GroupItem g: items){
            if(g.groupName.equals(groupName)){
                group =g;
                break;
            }
        }

        if(group == null){ //Item 이 없으면 생성
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }
        if (!TextUtils.isEmpty(childName)){
            ChildItem child = new ChildItem();
            child.childName = childName;
            child.fontSize = 20 + r.nextInt(20);
            group.children.add(child); //group에 child를 추가
        }
        notifyDataSetChanged();
    }

    private static final int VIEW_TYPE_SECTION_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        for (int i = 0 ; i <items.size(); i++){
            GroupItem group = items.get(i);
            if(position < 1) return VIEW_TYPE_SECTION_HEADER;
            position--;

            int childCount =group.children.size();
            if(position< childCount)return VIEW_TYPE_ITEM;
            position-= childCount;
        }

        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType){
            case VIEW_TYPE_SECTION_HEADER:
                view =inflater.inflate(R.layout.view_section_header, parent,false);
                StaggeredGridLayoutManager.LayoutParams params = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setFullSpan(true);
                view.setLayoutParams(params);
                return new SectionHeaderViewHolder(view);

            case VIEW_TYPE_ITEM:
                view = inflater.inflate(R.layout.view_child_item, parent, false);
                return new ChildViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        for(int i =0; i<items.size(); i++){
            GroupItem group = items.get(i);
            if(position < 1){
                ((SectionHeaderViewHolder)holder).setGroupItem(group);
                return;
            }
            position--;
            int childCount = group.children.size();
            if(position < childCount){
                ChildItem child = group.children.get(position);
                ((ChildViewHolder)holder).setChildItem(child);
                return;
            }
            position -= childCount;
        }
    }

    @Override
    public int getItemCount() {
        int totalCount =0;
        for (GroupItem g : items){
            totalCount += (1 + g.children.size());
        }
        return totalCount;
    }
}
