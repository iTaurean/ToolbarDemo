package com.android.lvxin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.lvxin.R;

public class CustomToolbarActivity extends BaseToolbarActivity implements View.OnClickListener {

    ImageView backBtn;
    TextView titleTv;
    ImageView rightBtn;

    public static void start(Context context) {
        Intent intent = new Intent(context, CustomToolbarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toolbar);

        addCustomToolbar(R.layout.layout_custom_toolbar);
        initCustomToolbar();
    }

    private void initCustomToolbar() {
        backBtn = (ImageView) findViewById(R.id.iv_back);
        backBtn.setOnClickListener(this);
        titleTv = (TextView) findViewById(R.id.tv_title);
        rightBtn = (ImageView) findViewById(R.id.iv_action);
        rightBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_action:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
