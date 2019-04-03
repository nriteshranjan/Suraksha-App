package com.example.suraksha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        Button login=findViewById(R.id.loginButton);
    }

    public void login_page(View view)
    {
        String name=username.getText().toString();
        String pass=password.getText().toString();
        if(name.equals("admin")&&pass.equals("admin"))
        {
            Intent intent=new Intent(MainActivity.this,activity_user.class);
            Bundle bundle=new Bundle();
            bundle.putString("name", String.valueOf(username));
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(name.equals("")||pass.equals(""))
        {
            Toast.makeText(this, "Please input data for both the fields", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Wrong details entered!", Toast.LENGTH_SHORT).show();
    }

}
