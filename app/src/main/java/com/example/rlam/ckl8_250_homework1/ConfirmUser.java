package com.example.rlam.ckl8_250_homework1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ConfirmUser extends ActionBarActivity {

    private String mName;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_user);

        Bundle extras = getIntent().getExtras();
        mName = extras.getString("name");
        mEmail = extras.getString("email");

        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewEmail = (TextView) findViewById(R.id.textViewEmail);

        // Name
        textViewName.setText(mName);
        // Email
        textViewEmail.setText(mEmail);
    }
}
