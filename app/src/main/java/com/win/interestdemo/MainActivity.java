package com.win.interestdemo;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    NavigationView menu;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle Toggle;
    ViewPager pager;
    TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawLayout);
        menu= (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);
        tab= (TabLayout) findViewById(R.id.tab);
        //menu.setOnClickListener(this);
        //显示Home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //三条横线的Meun
        Toggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        Toggle.syncState();
        //由DrawLayout控制Toggle
        drawerLayout.setDrawerListener(Toggle);


        pager=(ViewPager)findViewById(R.id.viewPager);
        List<String> list=new ArrayList<>();

        for (int i = 0; i < 20; i++) {
//            list.add("android"+i);
            list.add(String.format("%02d",i));
        }
        pager.setAdapter(new MyAdater(getSupportFragmentManager(),list));

        tab.setupWithViewPager(pager);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(Toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 关闭侧滑，从侧滑的view里
    @Override
    public void onClick(View v) {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this,"第一项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_2:
                Toast.makeText(this,"第二项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_3:
                Toast.makeText(this,"第三项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_4:
                Toast.makeText(this,"第四项",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
