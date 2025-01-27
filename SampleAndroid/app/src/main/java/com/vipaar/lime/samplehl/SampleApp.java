package com.vipaar.lime.samplehl;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class SampleApp extends Application {

    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new MyDebugTree());
        }
    }

    private static class MyDebugTree extends Timber.DebugTree {

        protected void log(int priority, String tag, @NotNull String message, Throwable t) {
            super.log(priority, tag, String.format("[ %s ] %s", Thread.currentThread().getName(), message), t);
        }
    }
}
