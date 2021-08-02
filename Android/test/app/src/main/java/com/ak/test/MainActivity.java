package com.ak.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    View  headerView;
    TextView navName, navUsername;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        drawer = findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        sessionManager = new SessionManager(this);
        headerView = navigationView.getHeaderView(0);
        navName = (TextView) headerView.findViewById(R.id.navName);
        navUsername = (TextView) headerView.findViewById(R.id.navUsername);
        HashMap<String, String> user = sessionManager.getUserDetail();
        String name = user.get(sessionManager.NAME);
        String userame = user.get(sessionManager.USERNAME);
        navName.setText(name);
        navUsername.setText(userame);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                setTitle("Home");
                break;
            case R.id.nav_categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CategoriesFragment()).commit();
                setTitle("Categories");
                break;
            case R.id.nav_order:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OrderFragment()).commit();
                setTitle("Order");
                break;
            case R.id.nav_mycart:
                Intent cart = new Intent(MainActivity.this,Mycart.class);
                startActivity(cart);
                setTitle("My Cart");
                break;
            case R.id.nav_help:
                Intent help = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(help);
                setTitle("Help");
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                setTitle("About");
                break;
            case R.id.nav_profile:
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
                setTitle("Profile");
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
