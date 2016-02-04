package com.example.jsontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = (TextView) findViewById(R.id.text_result);
        resultText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void testLogan(View view) {
        resultText.setText("<<< LoganSquare >>>\n\n" + new LoganTest().test());
    }

    public void testGson(View view) {
        resultText.setText("<<< Gson >>>\n\n" + new GsonTest().test());
    }

    public void testJackson(View view) {
        resultText.setText("<<< Jackson >>>\n\n" + new JacksonTest().test());
    }
}
