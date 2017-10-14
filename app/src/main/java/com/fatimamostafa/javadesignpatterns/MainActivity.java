package com.fatimamostafa.javadesignpatterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.fatimamostafa.javadesignpatterns.globalvariable.GlobalVariables;
import com.fatimamostafa.javadesignpatterns.staticmethodlibrary.ActivityHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TEXT_KEY = "LOG_TEXT_KEY";
    @BindView(R.id.hello)
    Button hello;
    @BindView(R.id.tvSampleText)
    TextView tvSampleText;

    private GlobalVariables appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appContext = (GlobalVariables) getApplicationContext();
        tvSampleText.setText(appContext.getTextToDisplay());

        hello.setOnClickListener(view ->
                ActivityHelper.log(this, tvSampleText, "Static Method Library Test", true));

    }

    //Save and restore state
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ActivityHelper.log(this, tvSampleText, "saving state", true);
        outState.putString(LOG_TEXT_KEY, tvSampleText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvSampleText.setText(savedInstanceState.getString(LOG_TEXT_KEY));
        ActivityHelper.log(this, tvSampleText, "Restoring state", true);
    }
*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appContext.setTextToDisplay(tvSampleText.getText().toString());
    }
}
