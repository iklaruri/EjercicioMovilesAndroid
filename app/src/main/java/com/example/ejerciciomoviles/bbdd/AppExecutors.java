package com.example.ejerciciomoviles.bbdd;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class AppExecutors
{
    private static final Object LOCK = new Object();
    private static AppExecutors sInstance;
    private final Executor diskIP;
    private final Executor mainThread;
    private final Executor networkIO;

    public AppExecutors(Executor diskIP, Executor mainThread, Executor networkIO)
    {
        this.diskIP = diskIP;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    private static class MainThreadExecutor implements Executor
    {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command)
        {
            mainThreadHandler.post(command);
        }
    }

    public static AppExecutors getsInstance()
    {
        if(sInstance == null)
        {
            synchronized (LOCK)
            {
                sInstance = new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor getDiskIP()
    {
        return diskIP;
    }

    public Executor getMainThread()
    {
        return mainThread;
    }

    public Executor getNetworkIO()
    {
        return networkIO;
    }
}
