package postpc.huji.multithreaded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View mButtonAsync;
    private View mButtonThreads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonAsync = findViewById(R.id.async_button);
        mButtonThreads = findViewById(R.id.threads_button);

        mButtonAsync.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AsyncActivity.class);
                startActivity(intent);
            }
        });

        mButtonThreads.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ThreadsActivity.class);
                startActivity(intent);
            }
        });
    }
}
