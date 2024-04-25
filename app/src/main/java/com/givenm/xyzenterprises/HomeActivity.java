package com.givenm.xyzenterprises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button button;
    NonPersistandDataManager npDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        npDataManager = new NonPersistandDataManager(this);

        setToolbarTitle();

        button = findViewById(R.id.buttonLabel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public void setToolbarTitle() {
        toolbar.setTitle(npDataManager.Language);
        TextView firstInterface = findViewById(R.id.firstInterfaceText);
        firstInterface.setText(npDataManager.FirstInterface);
        Button buttonLabel = findViewById(R.id.buttonLabel);
        buttonLabel.setText(npDataManager.ButtonLabel);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_english) {
            // Your custom action (e.g., call finish() to close the activity)
            npDataManager.setLanguage("English");
            setToolbarTitle();
            return true;
        }
        if (item.getItemId() == R.id.action_french) {
            // Your custom action (e.g., call finish() to close the activity)
            npDataManager.setLanguage("French");
            setToolbarTitle();
            return true;
        }
        if (item.getItemId() == R.id.action_spanish) {
            // Your custom action (e.g., call finish() to close the activity)
            npDataManager.setLanguage("Spanish");
            setToolbarTitle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}