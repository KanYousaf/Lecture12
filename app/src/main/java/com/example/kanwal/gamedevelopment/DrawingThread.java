package com.example.kanwal.gamedevelopment;

import android.os.Handler;
import android.os.Looper;
import android.view.View;


public class DrawingThread {
    private View view = null;
    private int fps;
    private Thread thread = null;
    private Handler handler = null;
    private volatile boolean isRunning = false;


    public DrawingThread(View view, int fps) {
        if (view == null || fps <= 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.fps = fps;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(new MainRunner());
            thread.start();
        }
    }

    /*
     * Small runnable helper class that contains the thread's main loop
     * to repeatedly sleep-and-redraw the view.
     */
    private class MainRunner implements Runnable {
        public void run() {
            isRunning = true;
            while (isRunning) {
                // sleep for a short time between frames of animation
                try {
                    Thread.sleep(1000 / fps);
                } catch (InterruptedException ie) {
                    isRunning = false;
                }

                // post a message that will cause the view to redraw
                handler.post(new Updater());
            }
        }
    }

    /*
     * Small runnable helper class needed by Android to redraw a view.
     */
    private class Updater implements Runnable {
        public void run() {
            view.invalidate();
        }
    }
}
