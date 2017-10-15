package com.fatimamostafa.javadesignpatterns.fragmentasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by fatimamostafa on 10/14/17.
 */

public class AsyncFragment extends Fragment {

    private ParentActivity mParentActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public interface ParentActivity {
        void handleTaskUpdate(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParentActivity = (ParentActivity) context;
        Log.i(getClass().getSimpleName(), "onAttach: ");
    }

    public void runAsyncTask(String... params){
        MyTask task = new MyTask();
        task.execute(params);
    }
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    class MyTask extends AsyncTask<String, String, Void> {

        @Override
        protected Void doInBackground(String... params) {
            for (String s : params) {
                publishProgress("I got " + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mParentActivity.handleTaskUpdate(values[0]);
        }
    }
}
