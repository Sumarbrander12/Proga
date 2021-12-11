package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity {



    private Button enterBtn, registrBtn;
    private TextView email, pass;
    private ImageView img;
    private static final String login = "1", password = "1";
    //DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
        //dbHelper = new DBHelper(this);
    }

    public void Login (){
        registrBtn = (Button) findViewById(R.id.registrBtn);
        registrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".RegActivity");
                startActivity(intent);
            }
        });
        img = (ImageView)findViewById(R.id.imageView3);
        enterBtn =(Button)findViewById(R.id.enterBtn);
        email=(EditText)findViewById(R.id.emailText);
        pass=(EditText)findViewById(R.id.passwordText);

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                //ContentValues contentValues = new ContentValues();

                if(login.equals(String.valueOf(email.getText())) && password.equals(String.valueOf(pass.getText()))){
                    Intent intent = new Intent(".Activity2");
                    startActivity(intent);
                }
                else{
                    img.setImageResource(R.drawable.cross);
                }
            }
        });
    }


}
