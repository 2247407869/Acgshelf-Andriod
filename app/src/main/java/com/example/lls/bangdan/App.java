package com.example.lls.bangdan;

import android.app.Application;
import android.content.Context;

/**
 * Created by LLS on 2018/2/24.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        CrashHandler.getInstance().init(this);
    }

    public static App getContext() {
        return (App) context;
    }
}
