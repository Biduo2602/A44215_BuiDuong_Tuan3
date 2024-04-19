package com.example.adapterapplication.BaiTapTuan3;

import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapterapplication.R;

import java.util.ArrayList;

class InfoAdapter extends BaseAdapter implements Adapter {
    private ArrayList<Info> arrayList;
    private Context context;

    protected static class ViewHolder{
        ImageView imageAx = null;
        TextView textName = null;
        TextView textGia = null;
    }
    public InfoAdapter(ArrayList<Info> arrayList, Context context){
//        super(context, R.layout.item_view, arrayList);
        this.arrayList = arrayList;
        this.context = context;
    };
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Info dataModel = (Info) getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.t3item_view,parent, false);
            viewHolder.imageAx = convertView.findViewById(R.id.imgView);
            viewHolder.textGia = convertView.findViewById(R.id.textView2);
            viewHolder.textName = convertView.findViewById(R.id.txtView1);
            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.textName.setText(dataModel.name);
        viewHolder.textGia.setText(dataModel.gia);
        viewHolder.imageAx.setImageResource(dataModel.image);
        return convertView;
    }

}
