package postpc.huji.multithreaded.utils;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import postpc.huji.multithreaded.R;

/**
 * Created by User on 5/15/2018.
 */

public class MyAsyncTask extends AsyncTask<Void, String, String> {

    private int i = 0;
    TextView textView = null;
    private final int SLEEP_TIME = 500;
    private final int MAX_ITERATIONS = 10;
    private final String CANCELLED = "Cancelled";

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        while (i < MAX_ITERATIONS) {
            i++;
                publishProgress(String.valueOf(i));
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Done";
    }

    @Override
    protected void onProgressUpdate(String... inputs) {
        super.onProgressUpdate(inputs);
        if (inputs != null && inputs.length > 0) {
            textView.setText(inputs[0]);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        textView.setText(CANCELLED);
    }

    @Override
    protected void onPostExecute(String status) {
        super.onPostExecute(status);
        textView.setText(status);
    }
}
