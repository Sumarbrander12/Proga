package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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



    private Button enterBtn;
    private TextView email, pass;
    private ImageView img;
    private static final String login = "1", password = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
    }

    public void Login (){
        img = (ImageView)findViewById(R.id.imageView3);
        enterBtn =(Button)findViewById(R.id.enterBtn);
        email=(EditText)findViewById(R.id.emailText);
        pass=(EditText)findViewById(R.id.passwordText);

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
