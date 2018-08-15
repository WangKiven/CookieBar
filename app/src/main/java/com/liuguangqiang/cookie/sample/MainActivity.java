package com.liuguangqiang.cookie.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.liuguangqiang.cookie.CookieBar;
import com.liuguangqiang.cookie.OnActionClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTop = (Button) findViewById(R.id.btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setTitle(R.string.cookie_title)
                        .setMessage(R.string.cookie_message)
                        .show();
            }
        });

        Button btnBottom = (Button) findViewById(R.id.btn_bottom);
        btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar
                        .Builder(MainActivity.this)
                        .setTitle(R.string.cookie_title)
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage(R.string.cookie_message)
                        .setLayoutGravity(Gravity.BOTTOM)
                        .setAction(R.string.cookie_action, new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        Button btnTopWithIcon = (Button) findViewById(R.id.btn_top_with_icon);
        btnTopWithIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setMessage(R.string.cookie_message)
                        .setDuration(10000)
                        .setActionWithIcon(R.mipmap.ic_action_close, new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.btn_top_only_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setTitle(R.string.cookie_title)
                        .setLayoutGravity(Gravity.TOP)
                        .show();
            }
        });

        findViewById(R.id.btn_top_only_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setMessage(R.string.cookie_message)
                        .show();
            }
        });

        Button btnCustom = (Button) findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CookieBar.Builder(MainActivity.this)
                        .setTitle(R.string.cookie_title)
                        .setMessage(R.string.cookie_message)
                        .setDuration(3000)
                        .setBackgroundColor(R.color.colorPrimary)
                        .setActionColor(android.R.color.white)
                        .setTitleColor(R.color.colorAccent)
                        .setAction(R.string.cookie_action, new OnActionClickListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getApplicationContext(), "点击后，我更帅了!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.btn_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideInAnimation = AnimationUtils.loadAnimation(MainActivity.this,
                        com.liuguangqiang.cookie.R.anim.slide_in_from_top);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(slideInAnimation);
                view.setAnimation(animationSet);
            }
        });
    }

}
