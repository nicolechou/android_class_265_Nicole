package com.example.user.simpleui;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by user on 2016/5/5.
 */
public class SimpleUIApplicatio extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("VYldPZJnpVDQOJ668ORJD2JldM6UEp6DooogvuCo")
                        .clientKey("3EPf8TkFKtX9gE1kdrjenqK8vUHZieWMNOYewXVc")
                        .server("https://parseapi.back4app.com/")
                        .build()
        );
    }
}
