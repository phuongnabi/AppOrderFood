package com.example.sulleynguyen.apporderfood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.sulleynguyen.apporderfood.FramentApp.ShowTableDinnerFragment;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sulleynguyen on 2/28/18.
 */

public class HomePageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView txtEmployeeName_Navigation;

    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentManager fragmentManager;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homepage);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationViewHomePage);
        toolbar = (Toolbar) findViewById(R.id.toolBar);

        //tim txtEmployeeName_Navigation tu layout khac
        View view = navigationView.inflateHeaderView(R.layout.layout_header_navigation_homepage);
        txtEmployeeName_Navigation =  (TextView) view.findViewById(R.id.txtEmployeeName_Navigation);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //hien thi mau icon
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        txtEmployeeName_Navigation.setText(userName);
        //Log.d("data",userName);

        fragmentManager = getSupportFragmentManager();

        //default khi chay app thi chay fragement trang chu
        FragmentTransaction transShowTableDinner = fragmentManager.beginTransaction();
        ShowTableDinnerFragment showTableDinnerFragment = new ShowTableDinnerFragment();
        transShowTableDinner.replace(R.id.content, showTableDinnerFragment);
        transShowTableDinner.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.itHomePage:
                FragmentTransaction transShowTableDinner = fragmentManager.beginTransaction();
                ShowTableDinnerFragment showTableDinnerFragment = new ShowTableDinnerFragment();
                transShowTableDinner.replace(R.id.content, showTableDinnerFragment);
                transShowTableDinner.commit();

                item.setChecked(true);
                drawerLayout.closeDrawers();
            ;break;
        }

        return false;
    }
}
