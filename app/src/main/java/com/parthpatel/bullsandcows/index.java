package com.parthpatel.bullsandcows;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.text.Layout;
import android.view.Window;
import android.view.WindowManager;

import static android.support.v4.content.ContextCompat.startActivity;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_index);
        getSupportActionBar().hide();
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }


    private class LogoLauncher extends Thread {

        @Override
        public void run() {
            try {
                sleep(800);
            } catch (InterruptedException e) {
                startActivity(new Intent(index.this,MainActivity.class));
            }
            startActivity(new Intent(index.this, MainActivity.class));
            index.this.finish();
        }

    }
}