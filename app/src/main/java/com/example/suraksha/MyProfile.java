package com.example.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MyProfile extends AppCompatActivity
{
    EditText st_phone;
    SharedPreferences sharedPreferences;
    static final String mypreference="mypref";
    static final String phone="phoneKey";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        st_phone=findViewById(R.id.phoneText);

        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_phone.setText(sharedPreferences.getString(phone,""));
        }

        setDefaults(phone,st_phone.getText().toString(),this);

    }

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public  String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, st_phone.getText().toString());
    }

    public void save (View v)
    {
        String p=st_phone.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(phone,p);
        editor.commit();

    }

    public void clear(View v)
    {
        st_phone.setText("");
    }

    public String retrive(View v)
    {
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(phone))
        {
            st_phone.setText(sharedPreferences.getString(phone,""));
            return sharedPreferences.getString(phone,"");
        }
        return "100";
    }
}
