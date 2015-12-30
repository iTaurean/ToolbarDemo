package com.android.lvxin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.lvxin.R;

public class ToolbarActivity extends BaseToolbarActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, ToolbarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base_with_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (R.id.action_share == id) {
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
            return true;
        } else if (R.id.action_settings == id) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
