package com.example.pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gamerFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvInfo = (TextView) findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button2);

        guess = (int)(Math.random()*100);
        gamerFinished = false;
    }

    public void onClick(View v){

        if (!gamerFinished){
            int inp = Integer.parseInt(etInput.getText().toString());
            if(inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp == guess)
            {
                tvInfo.setText("В точку");
                bControl.setText(getResources().getString(R.string.play_more));
                gamerFinished=true;
            }
        }
        else
        {
            guess =(int)Math.random()*100;
            bControl.setText("Ввести занчение");
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gamerFinished=false;
        }

    }
}