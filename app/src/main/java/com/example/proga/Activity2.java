package com.example.proga;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Activity2 extends AppCompatActivity {

    ImageView img;
    Button b1,b2,b3,btnRead,btnWrite;
    EditText textWrite;
    TextView textRead;
    MediaPlayer horseSound, musicSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        img = (ImageView) findViewById(R.id.imageView2);
        horseSound = MediaPlayer.create(this, R.raw.horse);
        musicSound = MediaPlayer.create(this, R.raw.kamen);
        imageClick();
        b1 = (Button) findViewById(R.id.start);
        b2 = (Button) findViewById(R.id.pause);
        b3 = (Button) findViewById(R.id.stop);
        btnClick();
        btnRead = (Button) findViewById(R.id.buttonRead);
        btnWrite = (Button) findViewById(R.id.buttonWrite);
        textWrite = (EditText) findViewById(R.id.editTextWrite);
        textRead = (TextView) findViewById(R.id.textRead);

    }

    public void Read (View view){
        try {
            FileInputStream fileInput = openFileInput("example.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while((lines = buffer.readLine()) != null){
                strBuffer.append(lines + "\n");
            }
            textRead.setText(strBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Write (View view){
        String myTxt = textWrite.getText().toString();
        try {
            FileOutputStream fileOutput = openFileOutput("example.txt",MODE_PRIVATE);
            fileOutput.write(myTxt.getBytes());
            fileOutput.close();
            textWrite.setText("");
            Toast.makeText(Activity2.this, "Текст сохранен", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imageClick() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horseSound.start();
            }
        });
    }
    public void btnClick(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicSound.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicSound.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicSound.stop();
            }
        });
    }
}