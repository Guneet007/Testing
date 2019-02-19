package com.example.splashtest.viewModel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;


public class SplashViewModel extends ViewModel {


    private MutableLiveData<Boolean>  mIsUpdating=new MutableLiveData<>();


    public void showSplash(){
        mIsUpdating.setValue(true);

         new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mIsUpdating.postValue(false);


            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
