package com.example.suraksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class activity_user extends AppCompatActivity
{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    TextView usern;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        usern=findViewById(R.id.usern);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        System.out.println("Name : "+name);
        usern.setText(name);

        drawerLayout=findViewById(R.id.drawerLayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id=menuItem.getItemId();

                if(id==R.id.trackDaughter)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                }

                else if(id==R.id.myProfile)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                }

                else if(id==R.id.emergency)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                }

                else if(id==R.id.selfDefense)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                }

                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return actionBarDrawerToggle.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }
}
