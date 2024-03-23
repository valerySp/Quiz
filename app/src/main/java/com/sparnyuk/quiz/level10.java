package com.sparnyuk.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level10 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    Array array=new Array();
    Random random=new Random();
    public int ran;
    public int slovo;

    public int count=0;
    public final int lvl=100;
    public final int div=5;

    public MediaPlayer soundRight, soundWrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level10);

       final LinearLayout layout_left=findViewById(R.id.line5_univ);
       final LinearLayout layout_right=findViewById(R.id.line6_univ);


        TextView text_left = findViewById(R.id.text_left);
        TextView text_right = findViewById(R.id.text_right);


        final TextView textLeft=findViewById(R.id.text_left_line);
        final TextView textRight=findViewById(R.id.text_right_line);

        //звук-начало
        soundRight=MediaPlayer.create(this,R.raw.right);
        soundWrong=MediaPlayer.create(this,R.raw.wrong);
        //звук - конец

        //вызов диалогового окна
        dialog =new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрытть заголовок
        dialog.setContentView(R.layout.previewdialog); // путь к макету окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачный фон
        dialog.setCancelable(false);// недбзя закрыть кнопкой назад

        TextView btnclose=(TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(level10.this, GameLevels.class);
                startActivity(intent);finish();
                dialog.dismiss();

            }
        });
        Button btncont =(Button)dialog.findViewById(R.id.btncontinue);
        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        //__________________________
        dialogEnd =new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрытть заголовок
        dialogEnd.setContentView(R.layout.dialogfin); // путь к макету окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачный фон
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);// растягивание слоя на всю ширину
        dialogEnd.setCancelable(false);// недбзя закрыть кнопкой назад



        TextView btnclose2=(TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(level10.this, GameLevels.class);
                startActivity(intent);finish();
                dialogEnd.dismiss();

            }
        });



        //__________________________

        //кнопка "назад" - начало
        Button btn_back=(Button)findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(level10.this, GameLevels.class);
                startActivity(intent);finish();
            }
        });
        // кнопка "назад" - конец

        // массив для игры  - начало
        final int[] progress = {R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,
                R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,
                R.id.point11,R.id.point12,R.id.point13,R.id.point14,R.id.point15,
                R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20};
        // массив для игры  - конец

        //подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(level10.this, R.anim.alpha);

        //подключаем анимацию - конец


        //логига программы
        ran = random.nextInt(lvl);
        slovo=random.nextInt(2);
        if(slovo==0) {
            textLeft.setText(array.dictionary[ran][0]);
            textRight.setText(array.dictionary[ran][1]);
            text_left.setText(array.dictionary[ran][3]);
            text_right.setText(array.dictionary[ran][3]);
        } else {
            textLeft.setText(array.dictionary[ran][1]);
            textRight.setText(array.dictionary[ran][0]);
            text_left.setText(array.dictionary[ran][3]);
            text_right.setText(array.dictionary[ran][3]);
        }
        //логига программы -конец

        // обработка нажатия на левую картинку - начало
        layout_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касание картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN ){
                    layout_right.setEnabled(false);//блокировка правой картинки
                    if ((textLeft.getText()).equals(array.dictionary[ran][2])){
                        soundRight.start();
                        layout_left.setBackgroundResource(R.drawable.right);
                        text_left.setText("О дааа!");
                        text_right.setText("Не верно!");

                    } else {
                        soundWrong.start();
                        layout_left.setBackgroundResource(R.drawable.worse);
                        text_left.setText("Не верно!");
                        text_right.setText("О дааа!");
                    }
                }
                else if (event.getAction()==MotionEvent.ACTION_UP){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //если отпустил палец - начало
                    if ((textLeft.getText().toString()).equals(array.dictionary[ran][2])){
                        if (count<lvl){
                            count=count+1;
                        }
                        for (int i = 0; i < 20; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы - начало
                        for (int i = 0; i < count/div; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы - конец
                    }
                    else{
                        if(count>0){
                            if (count==1){
                                count=0;
                            } else
                                count-=2;
                        }

                        for (int i = 0; i < 19; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count/div; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    // если отпустил палец - конец


                    if (count==lvl){
                        dialogEnd.show();//выход из уровня
                    } else {
                        //смотри 31.7 если что не так.
                        ran=random.nextInt(lvl);
                        slovo=random.nextInt(2);

                        if(slovo==0) {
                            textLeft.setText(array.dictionary[ran][0]);
                            layout_left.startAnimation(a);
                            layout_left.setBackgroundResource(R.drawable.layoutchange);
                            textRight.setText(array.dictionary[ran][1]);
                            layout_right.startAnimation(a);
                            layout_right.setBackgroundResource(R.drawable.layoutchange);
                            layout_right.setEnabled(true);
                            text_left.setText(array.dictionary[ran][3]);
                            text_right.setText(array.dictionary[ran][3]);// еще не понятно с анимацией
                        } else {
                            textLeft.setText(array.dictionary[ran][1]);
                            layout_left.startAnimation(a);
                            layout_left.setBackgroundResource(R.drawable.layoutchange);
                            textRight.setText(array.dictionary[ran][0]);
                            layout_right.startAnimation(a);
                            layout_right.setBackgroundResource(R.drawable.layoutchange);
                            layout_right.setEnabled(true);
                            text_left.setText(array.dictionary[ran][3]);
                            text_right.setText(array.dictionary[ran][3]);
                        }
                        //смотри 31.7 если что не так - конец.
                    }

                }
                //условие касание картинки - конец
                return true;
            }
        });
        // обработка нажатия на левую картинку - конец



        //обработка правой части -начало
        layout_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касание картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN ){
                    layout_left.setEnabled(false);//блокировка правой картинки
                    if ((textRight.getText()).equals(array.dictionary[ran][2].toString())){
                        soundRight.start();
                        layout_right.setBackgroundResource(R.drawable.right);
                        text_right.setText("О дааа!");
                        text_left.setText("Не верно!");

                    } else {
                        soundWrong.start();
                        layout_right.setBackgroundResource(R.drawable.worse);
                        text_right.setText("Аха, лоох!");
                        text_left.setText("Как надо");
                    }
                }
                else if (event.getAction()==MotionEvent.ACTION_UP){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //если отпустил палец - начало
                    if ((textRight.getText().toString()).equals(array.dictionary[ran][2])){
                        if (count<lvl){
                            count=count+1;
                        }
                        for (int i = 0; i < 20; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы - начало
                        for (int i = 0; i < count/div; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы - конец
                    }
                    else{
                        if(count>0){
                            if (count==1){
                                count=0;
                            } else
                                count-=2;
                        }

                        for (int i = 0; i < 19; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < count/div; i++) {
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    // если отпустл палец - конец


                    if (count==lvl){
                        dialogEnd.show(); //выход из уровня
                    } else {
                        //смотри 31.7 если что не так.
                        ran=random.nextInt(lvl);
                        slovo=random.nextInt(2);

                        if(slovo==0) {
                            textRight.setText(array.dictionary[ran][0]);
                            layout_right.startAnimation(a);
                            layout_right.setBackgroundResource(R.drawable.layoutchange);
                            textLeft.setText(array.dictionary[ran][1]);
                            layout_left.startAnimation(a);
                            layout_left.setBackgroundResource(R.drawable.layoutchange);
                            layout_left.setEnabled(true);
                            text_left.setText(array.dictionary[ran][3]);
                            text_right.setText(array.dictionary[ran][3]);// еще не понятно с анимацией
                        } else {
                            textRight.setText(array.dictionary[ran][1]);
                            layout_right.startAnimation(a);
                            layout_right.setBackgroundResource(R.drawable.layoutchange);
                            textLeft.setText(array.dictionary[ran][0]);
                            layout_left.startAnimation(a);
                            layout_left.setBackgroundResource(R.drawable.layoutchange);
                            layout_left.setEnabled(true);
                            text_left.setText(array.dictionary[ran][3]);
                            text_right.setText(array.dictionary[ran][3]);
                        }
                        //смотри 31.7 если что не так - конец.
                    }

                }
                //условие касание картинки - конец
                return true;
            }
        });
        //обработка правой части -конец



    }
    @Override
    public void onBackPressed (){
        Intent intent=new Intent(level10.this, GameLevels.class);
        startActivity(intent);finish();
    }

}