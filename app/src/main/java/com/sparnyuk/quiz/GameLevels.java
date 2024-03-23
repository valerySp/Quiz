package com.sparnyuk.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save=getSharedPreferences("Save", MODE_PRIVATE); // save game
        final int level = save.getInt("level",1); // save game

        Button button_back=(Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameLevels.this,MainActivity.class);
                startActivity(intent);finish();
            }
        });
        // кнопка перехода на 1 уровень - начало
        TextView textView1=(TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=1){
                    Intent intent = new Intent(GameLevels.this,level1.class);
                    startActivity(intent);finish();
                    } else {}
                }

                catch (Exception e){}
            }
        });
        // кнопка на 1 уровень - конец

        // кнопка перехода на 2 уровень - начало
        TextView textView2=(TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=2){
                    Intent intent = new Intent(GameLevels.this,level2.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });
        // кнопка на 2 уровень - конец

        // кнопка перехода на 3 уровень - начало
        TextView textView3=(TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=3){
                    Intent intent = new Intent(GameLevels.this,level3.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });
        // кнопка на 3 уровень - конец

        // кнопка перехода на 4 уровень - начало
        TextView textView4=(TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=4){
                    Intent intent = new Intent(GameLevels.this,level5.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });
        // кнопка на 4 уровень - конец

        TextView textView5=(TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=5){
                    Intent intent = new Intent(GameLevels.this,level5.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        TextView textView6=(TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=6){
                    Intent intent = new Intent(GameLevels.this,level6.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        TextView textView7=(TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=7){
                    Intent intent = new Intent(GameLevels.this,level7.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        TextView textView8=(TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=8){
                    Intent intent = new Intent(GameLevels.this,level8.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        TextView textView9=(TextView) findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=9){
                    Intent intent = new Intent(GameLevels.this,level9.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        TextView textView10=(TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=10){
                    Intent intent = new Intent(GameLevels.this,level10.class);
                    startActivity(intent);finish();}
                    else {}
                }
                catch (Exception e){}
            }
        });

        final int[] x={
                R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,
                R.id.textView5,R.id.textView6,R.id.textView7,R.id.textView8,
                R.id.textView9,R.id.textView10
        };
        for (int i = 0; i < level; i++) {
            TextView tv=findViewById(x[i]);
            tv.setText(""+(i+1));
        }

    }
    //Системная кнопка "назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this,MainActivity.class);
            startActivity(intent);finish();
        }
        catch (Exception e){}
    }

    //Системная кнопка "назад" - конец кода
}