package com.example.storagedemo;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AppListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);

        ListView appListView = (ListView) findViewById(R.id.app_list_view);

        List<String> appNames = new ArrayList<>();
        appNames.add("Wechat");
        appNames.add("QQ");
        appNames.add("Imooc");

        appListView.setAdapter(new AppListAdapter(appNames));
    }

    public class AppListAdapter extends BaseAdapter{

        private List<String> mAppNames;

        public AppListAdapter(List<String> appNames){
            mAppNames = appNames;
        }

        @Override
        public int getCount() {

            //有多少条item
            return mAppNames.size();
        }

        @Override
        public Object getItem(int position) {

            //获取当前的一条
            return mAppNames.get(position);
        }

        @Override
        public long getItemId(int position) {
            //上一条的id
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //处理view <-> data 填充数据的过程
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_app_list_view,null);
            ImageView appIconImageView = (ImageView) convertView.findViewById(R.id.app_icon_image_view);
            TextView appNameTextView = (TextView) convertView.findViewById(R.id.app_name_text_view);

            appNameTextView.setText(mAppNames.get(position));

            return convertView;
        }
    }
}
