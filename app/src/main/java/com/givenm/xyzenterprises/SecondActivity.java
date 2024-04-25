package com.givenm.xyzenterprises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    NonPersistandDataManager npDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.toolbar);
        npDataManager = new NonPersistandDataManager(this);
        toolbar.setTitle(npDataManager.Language);
        TextView secondInterface = findViewById(R.id.secondInterface);
        secondInterface.setText(npDataManager.SecondInterface);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Your custom action (e.g., call finish() to close the activity)
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}