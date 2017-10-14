package com.fatimamostafa.javadesignpatterns.staticmethodlibrary;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fatimamostafa on 10/14/17.
 */

public class ActivityHelper {
    public static void log(Context context, TextView textView, String message, boolean append) {

        if(textView != null && message != null && message.length() > 0) {
            if(append){
                textView.append(message + "\n");
            }
            else {
                textView.setText(message);
            }

            Log.d(context.getClass().getSimpleName(), "log: ");
        }

    }
}
