package com.example.rlam.ckl8_250_homework1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private EditText mEditTextPassword;
    private EditText mEditTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views by ids
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);


        // Set OnClickListener on the submit button
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formIsValid()) {
                    gotoConfirmationScreen();
                }
            }
        });
    }

    /**
     * Validate each input field
     * @return
     */
    private boolean formIsValid() {
        // check if name is entered
        if (TextUtils.isEmpty(getInput(mEditTextPassword))) {
            mEditTextPassword.setError("Please enter password");
            return false;
        }
        // check if email is entered
        if (TextUtils.isEmpty(getInput(mEditTextEmail))) {
            mEditTextEmail.setError("Please enter an email");
            return false;
            // check if email is in valid format
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getInput(mEditTextEmail)).matches()) {
            mEditTextEmail.setError("Please enter a valid email");
            return false;
        }
        return true;
    }

    /**
     * Get the user input in EditText
     * @param editText
     * @return
     */
    private String getInput(EditText editText) {
        return editText.getText().toString().trim();
    }

    /**
     * Go to the confirmation screen that displays user input
     */
    private void gotoConfirmationScreen() {

        Intent intent = new Intent(this, ConfirmUser.class);
        intent.putExtra("name", mEditTextPassword.getText().toString());
        intent.putExtra("email", mEditTextEmail.getText().toString());
        startActivity(intent);

    }

}
