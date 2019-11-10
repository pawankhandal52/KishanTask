/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 6:47 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 10/5/19 2:08 PM
 *
 */
package com.kishan.contactstask.utils;


import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * This class is used to execute database operations
 */
public class AppExecutors {

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static AppExecutors sInstance;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }
    
    /**
     * To get Instance of this class
     * @return instance
     */
    public static AppExecutors getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }
    
    /**
     * Disk Io
     * @return Executor
     */
    public Executor diskIO() {
        return diskIO;
    }
    
    /**
     * Main Thread
     * @return Executor
     */
    public Executor mainThread() {
        return mainThread;
    }
    
    /**
     * networkIO
     * @return Executor
     */
    public Executor networkIO() {
        return networkIO;
    }

    
    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
