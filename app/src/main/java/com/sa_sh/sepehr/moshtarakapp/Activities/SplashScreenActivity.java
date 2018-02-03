package com.sa_sh.sepehr.moshtarakapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.sa_sh.sepehr.moshtarakapp.R;

/**
 * Created by sa-sh on 7/22/2016.
 */
public class SplashScreenActivity extends Activity {
    private static boolean splashLoaded = false;
    private ImageView splashImageView;
    private ShimmerFrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        if (!splashLoaded) {
            setContentView(R.layout.splash);
            initialize();
            startSplash();
        } else {
            Intent goToLoginActivity = new Intent(SplashScreenActivity.this, HomeActivity.class);
            goToLoginActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToLoginActivity);
            finish();
        }
    }

    private void initialize() {
        int splashResourceId = R.drawable.img_splash;
        splashImageView = (ImageView) findViewById(R.id.splashscreenImageView);
        splashImageView.setImageResource(splashResourceId);
        container = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
    }

    private void startSplash() {
        container.setRepeatCount(0);
        container.setDuration(2800);
        container.setBaseAlpha(0.5f);
        container.setAutoStart(false);
        container.setIntensity(1);
        container.startShimmerAnimation();
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    splashLoaded = true;
                    Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
