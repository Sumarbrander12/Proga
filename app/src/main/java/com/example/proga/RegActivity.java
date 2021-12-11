package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    String empty = " ";
    EditText ETlog, ETpass, ETemail;
    String log, pass, email;
    Button regBtn;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        regBtn = (Button) findViewById(R.id.regBtn);
        dbHelper = new DBHelper(this);
        ETlog = (EditText) findViewById(R.id.editLogin);
        ETpass = (EditText) findViewById(R.id.editPassword);
        ETemail = (EditText) findViewById(R.id.editEmail);
        BtnClick();
    }
    public void BtnClick(){
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = ETlog.getText().toString();
                String email = ETemail.getText().toString();
                String pass = ETpass.getText().toString();
                if(log.length()>2 && email.length()>2 && pass.length()>2){
                    SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBHelper.KEY_MAIL, email);
                    contentValues.put(DBHelper.KEY_NAME, log);
                    //contentValues.put(DBHelper.KEY_PASS, pass);

                    sqLiteDatabase.insert(DBHelper.TABLE_ACCOUNTS,null,contentValues);

                    Toast t =Toast.makeText(getApplicationContext(),"Вы успешно зарегистрировались!", Toast.LENGTH_SHORT);
                    t.show();
                    //Intent intent = new Intent(".MainActivity");
                    //startActivity(intent);
                }
                else{
                    Toast t =Toast.makeText(getApplicationContext(),"Каждый параметр должен быть не короче 3 символов!", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }
}