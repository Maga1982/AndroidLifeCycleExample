package com.example.harshu.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String LIFECYCLE= "Android Lifecycle stage";
    private TextView textView;
    private Button button;
    private  static  final String myTextKey = "myString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appendMessage("oncreate");
        textView = findViewById(R.id.text_id);
        button=findViewById(R.id.button_id);
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView.setText("changed text");

            }
        });
        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString(myTextKey));
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(myTextKey,textView.getText().toString());
        appendMessage("onsaveinstancestate");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendMessage("onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        appendMessage("onresume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        appendMessage("onrestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        appendMessage("onpause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        appendMessage("onstop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        appendMessage("ondestroy");
    }
    protected void appendMessage(String message){
        Log.v(LIFECYCLE,message);
    }
}
