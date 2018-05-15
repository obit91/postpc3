package postpc.huji.multithreaded;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import postpc.huji.multithreaded.utils.MyAsyncTask;

public class AsyncActivity extends AppCompatActivity {

    private View mButtonCreate;
    private View mButtonStart;
    private View mButtonCancel;
    private TextView asyncText;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mButtonCreate = findViewById(R.id.async_create);
        mButtonStart = findViewById(R.id.async_start);
        mButtonCancel = findViewById(R.id.async_cancel);
        asyncText = (TextView)findViewById(R.id.async_text);

        mButtonCreate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                myAsyncTask = new MyAsyncTask(asyncText);
            }
        });

        mButtonStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                myAsyncTask.execute();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                myAsyncTask.cancel(true);
            }
        });

    }
}
