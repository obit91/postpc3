package postpc.huji.multithreaded.utils;

import android.app.Activity;
import android.widget.TextView;

import postpc.huji.multithreaded.ThreadsActivity;

/**
 * Created by User on 5/16/2018.
 */

public class MyThread extends Thread implements Runnable {

    private int i = 0;
    private final int SLEEP_TIME = 500;
    private final int MAX_ITERATIONS = 10;
    private final String CANCELLED = "Cancelled";
    private final String DONE = "Done";
    private ThreadsActivity parent = null;

    public MyThread(ThreadsActivity parent) {
        this.parent = parent;
    }

    @Override
    public void run() {
        super.run();
            while (i < MAX_ITERATIONS && !isInterrupted()) {
                i++;
                parent.setText(String.valueOf(i));
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            parent.setText(DONE);
    }

    @Override
    public void interrupt() {
        super.interrupt();
        parent.setText(CANCELLED);
    }
}
