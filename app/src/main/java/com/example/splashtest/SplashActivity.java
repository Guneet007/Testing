package com.example.splashtest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.splashtest.viewModel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel mSplashViewModel;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashViewModel= ViewModelProviders.of(this).get(SplashViewModel.class);
        mImageView=findViewById(R.id.splash_image);

        mSplashViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    showImage();
                }
                else{
                    hideImage();
                    Intent intent = new Intent(getApplicationContext(),
                            MainActivity.class);
                            startActivity(intent);
                    finish();

                }
            }
        });

        mSplashViewModel.showSplash();
    }

    private void showImage(){
        mImageView.setVisibility(View.VISIBLE);
    }
    private void hideImage(){
        mImageView.setVisibility(View.GONE);
    }
}
