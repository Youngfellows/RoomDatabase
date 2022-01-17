package com.neandroid.sqlite;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.neandroid.sqlite.db.MyAppDatabase;
import com.neandroid.sqlite.db.MyAppDatabase2;

public class MyApp extends Application {

    private String TAG = this.getClass().getSimpleName();

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Log.d(TAG, "onCreate:: ");
        initRoomDatabase();
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 初始化数据库
     */
    private void initRoomDatabase() {
        MyAppDatabase.getInstance(this);
        MyAppDatabase2.getInstance(this);
    }
}
