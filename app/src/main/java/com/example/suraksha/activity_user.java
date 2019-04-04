package com.example.suraksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        usern.setText("WELCOME");


        Button navigate =findViewById(R.id.navigateButton);
        navigate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(activity_user.this,MapsDirection.class);
                startActivity(intent);
            }
        });




        drawerLayout=findViewById(R.id.drawerLayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view=findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id=menuItem.getItemId();

                if(id==R.id.trackDaughter)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                    Toast.makeText(activity_user.this, "Track Daughter", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(activity_user.this,MapsActivity.class);
                    startActivity(intent);
                }

                else if(id==R.id.myProfile)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                    Toast.makeText(activity_user.this, "My Profile", Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.emergency)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:100"));
                    startActivity(callIntent);
                    Toast.makeText(activity_user.this, "Emergency", Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.selfDefense)
                {
                    ///IMPLEMENT ON CLICK LISTENER
                    Toast.makeText(activity_user.this, "Self Defence", Toast.LENGTH_SHORT).show();
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
