package com.android.lvxin.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.lvxin.R;
import com.android.lvxin.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initTopBar();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(this, itemData());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (0 == position) {
                    ToolbarActivity.start(MainActivity.this);
                } else if (1 == position) {
                    CustomToolbarActivity.start(MainActivity.this);
                }
            }
        });
    }

    private void initTopBar() {
        ImageView backBtn = (ImageView) findViewById(R.id.iv_back);
        backBtn.setVisibility(View.GONE);
        TextView actionBtn = (TextView) findViewById(R.id.tv_action);
        actionBtn.setVisibility(View.GONE);
        TextView titleTv = (TextView) findViewById(R.id.tv_title);
        titleTv.setText(R.string.main_title);
    }


    private List<String> itemData() {
        List<String> values = new ArrayList<>();
        values.add("Toolbar - 系统布局");
        values.add("Toolbar - 自定义布局");
        return values;
    }
}
