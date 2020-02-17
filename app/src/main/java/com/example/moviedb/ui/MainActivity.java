package com.example.moviedb.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.moviedb.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private MoviesFragment moviesFragment;
    private TvFragment tvFragment;
    private ProfileFragment profileFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);
        frameLayout = (FrameLayout) findViewById(R.id.main_frame);

        moviesFragment = new MoviesFragment();
        tvFragment = new TvFragment();
        profileFragment = new ProfileFragment();
        setFragment(moviesFragment);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Menu movieMenu = bottomNavigationView.getMenu();
                Menu tvMenu = bottomNavigationView.getMenu();
                Menu profileMenu = bottomNavigationView.getMenu();
                movieMenu.findItem(R.id.nav_movies).setIcon(R.drawable.selector);
                tvMenu.findItem(R.id.nav_tv).setIcon(R.drawable.selector1);
                profileMenu.findItem(R.id.nav_profile).setIcon(R.drawable.selector2);
                switch (menuItem.getItemId()) {
                    case R.id.nav_movies:
                        setFragment(moviesFragment);
                        break;
                    case R.id.nav_tv:
                        setFragment(tvFragment);
                        break;
                    case R.id.nav_profile:
                        setFragment(profileFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }


}
