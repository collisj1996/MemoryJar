package com.arcticumi.memoryjar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Button newBtn;
    private BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newBtn = findViewById(R.id.btnNew);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMem = new Intent(MainActivity.this, NewMemActivity.class);
                startActivity(newMem);
            }
        });

        botNav = findViewById(R.id.bottom_nav);
        Menu menu = botNav.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        botNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_random:
                        Intent intent1 = new Intent(MainActivity.this, RandomActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_calendar:
                        Intent intent2 = new Intent(MainActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }
}
