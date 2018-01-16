package comli.example.c4q.midassest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        AsyncTaskStuff asyncTaskStuff = new AsyncTaskStuff(this);
        asyncTaskStuff.execute(0);
    }

    private class AsyncTaskStuff extends AsyncTask<Integer,Integer,Integer>{

        Context context;
        public AsyncTaskStuff(Context context) {
            this.context = context;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int i;
            for (i = 0; i < 100000 ; i++) {
                publishProgress(i);
            }
            return i;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText("Loops completed: " + integer);
            Intent intent = new Intent(context,LoginActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText("Loops completed: " + values[0]);
        }

    }}