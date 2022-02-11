package com.example.mobiledevelopment2021citymanager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

//        getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, new ListFragment()).commit();
//
//        int orientation = getResources().getConfiguration().orientation;
//        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment, new DetailFragment()).commit();
//        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragement = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_list:
                            selectedFragement = new ListFragment();
                            break;
                        case R.id.navigation_add:
                            selectedFragement = new AddFragment();
                            break;
                        case R.id.navigation_settings:
                            selectedFragement = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, selectedFragement).commit();

                    int orientation = getResources().getConfiguration().orientation;
                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment, new DetailFragment()).commit();
                    }

                    return true;
                }
            };
}
