package postpc.huji.multithreaded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import postpc.huji.multithreaded.utils.MyThread;

public class ThreadsActivity extends AppCompatActivity {
    private View mButtonCreate;
    private View mButtonStart;
    private View mButtonCancel;
    private TextView threadsText;
    private MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);
        mButtonCreate = findViewById(R.id.threads_create);
        mButtonStart = findViewById(R.id.threads_start);
        mButtonCancel = findViewById(R.id.threads_cancel);
        threadsText = (TextView)findViewById(R.id.threads_text);

        mButtonCreate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                myThread = new MyThread(ThreadsActivity.this);
                threadsText.setText("0");
            }
        });

        mButtonStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                myThread.start();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                myThread.interrupt();
            }
        });
    }

    public void setText(final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                threadsText.setText(value);
            }
        });
    }
}
