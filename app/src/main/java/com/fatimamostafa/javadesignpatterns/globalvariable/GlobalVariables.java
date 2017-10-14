package com.fatimamostafa.javadesignpatterns.globalvariable;

import android.app.Application;

/**
 * Created by fatimamostafa on 10/14/17.
 */

public class GlobalVariables extends Application {

    private String TextToDisplay;

    public String getTextToDisplay() {
        return TextToDisplay;
    }

    public void setTextToDisplay(String textToDisplay) {
        TextToDisplay = textToDisplay;
    }
}
