package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
        TextView logo2 = (TextView) findViewById(R.id.TextViewBottomTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        fade2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                MainActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo1.startAnimation(fade1);
        logo2.startAnimation(fade2);
        Animation spin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spin);
        TableLayout table = findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
        logo1.clearAnimation();
        TextView logo2 = (TextView) findViewById(R.id.TextViewBottomTitle);
        logo2.clearAnimation();
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }
    }
}