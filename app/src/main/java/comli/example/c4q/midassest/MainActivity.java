package comli.example.c4q.midassest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private midTermAsyncTask asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTask = new midTermAsyncTask(this);
        asyncTask.execute(50);
        textView = findViewById(R.id.textview);


    }
    public class midTermAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        MainActivity activity;

        public midTermAsyncTask(MainActivity activity) {
            this.activity = activity;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int r = integers[0];
            for (int i = 0; i < 100000; i++) {
                try {Thread.sleep(500);

                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return 1000000-r;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (activity!= null){
                activity.textView.setText("loops completed"+integer);
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progress = values[0];
            if (activity!= null){
                activity.textView.setText("loops compeleted  "  + progress);
            }
        }
    }
}
