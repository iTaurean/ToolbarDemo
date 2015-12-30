package com.android.lvxin.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.android.lvxin.R;

/**
 * 所有要实现Toolbar的基类, 同时设定顶部状态栏跟主题色同步
 */
public class BaseToolbarActivity extends AppCompatActivity {
    private static final String TAG = "BaseToolbarActivity";

    private LinearLayout mRootLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_with_toolbar);
        // 因为有些国产定制的rom上，xml中定义会不起效果。在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        initToolbar();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        mRootLayout = (LinearLayout) findViewById(R.id.layout_root);
        if (null == mRootLayout) return;
        mRootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        initToolbar();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
        } else {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(false);
        }
    }

    /**
     * 添加自定义toolbar的布局
     *
     * @param resId
     */
    public void addCustomToolbar(int resId) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        mToolbar.setContentInsetsAbsolute(0, 0);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        getSupportActionBar().setCustomView(View.inflate(this, resId, null), layoutParams);
    }

    /**
     * 改变Toolbar背景色
     *
     * @param resId
     */
    public void updatePrimaryColor(int resId) {
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
