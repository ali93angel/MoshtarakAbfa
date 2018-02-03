package com.sa_sh.sepehr.moshtarakapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sa_sh.sepehr.moshtarakapp.R;

import java.util.List;

/**
 * Created by Leon on 12/4/2017.
 */

public class LearningCustomAdapter extends ArrayAdapter<LearningCustomAdapter.DrawerItem> {
    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public DrawerItem getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getPosition(DrawerItem item) {
        return super.getPosition(item);
    }

    Context context;
    List<DrawerItem> drawerItemList;
    int layoutResID;

    public LearningCustomAdapter(Context context, int layoutResourceID,
                                 List<DrawerItem> listItems) {
        super(context, layoutResourceID, listItems);
        this.context = context;
        this.drawerItemList = listItems;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        DrawerItemHolder drawerHolder;
        convertView = null;
        DrawerItem dItem;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        drawerHolder = new DrawerItemHolder();
        convertView = inflater.inflate(layoutResID, parent, false);
        drawerHolder.textViewTitle = (TextView) convertView
                .findViewById(R.id.textViewTitle);
        drawerHolder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        dItem = (DrawerItem) this.drawerItemList.get(position);
        drawerHolder.imageViewIcon.setImageDrawable(convertView.getResources().getDrawable(
                dItem.getImgResID()));
        drawerHolder.textViewTitle.setText(dItem.getItemName());

        convertView.setTag(drawerHolder);


        return convertView;
//        DrawerItemHolder drawerHolder;
//        View view = convertView;
//
//        if (view == null) {
//            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//            drawerHolder = new DrawerItemHolder();
//
//            view = inflater.inflate(layoutResID, parent, false);
//            drawerHolder.textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
//            drawerHolder.imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
//
//            view.setTag(drawerHolder);
//
//        } else {
//            drawerHolder = (DrawerItemHolder) view.getTag();
//        }
//
//        DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);
//
//        drawerHolder.imageViewIcon.setImageDrawable(view.getResources().getDrawable(
//                dItem.getImgResID()));
//        drawerHolder.textViewTitle.setText(dItem.getItemName());
//
//        return view;
    }

    private static class DrawerItemHolder {
        TextView textViewTitle;
        ImageView imageViewIcon, imageViewSeperator;
    }

    public static class DrawerItem {

        String ItemName;
        int imgResID;

        public DrawerItem(String itemName, int imgResID) {
            super();
            ItemName = itemName;
            this.imgResID = imgResID;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String itemName) {
            ItemName = itemName;
        }

        public int getImgResID() {
            return imgResID;
        }

        public void setImgResID(int imgResID) {
            this.imgResID = imgResID;
        }

    }
}
