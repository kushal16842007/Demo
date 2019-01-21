package com.braintech.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText edtTextUserName;
    EditText edtTextPassword;
    Button btnLogin;
    TextView txtViewMessage;
    TextView txtViewTitleBar;
    TextView txtViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        manageClickEvents();

    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtTextUserName = (EditText) findViewById(R.id.edtTextUserName);
        edtTextPassword = (EditText) findViewById(R.id.edtTextPassword);
        txtViewMessage = (TextView) findViewById(R.id.txtViewMessage);
        txtViewTitleBar = (TextView) findViewById(R.id.txtViewTitle);
        txtViewSignUp = (TextView) findViewById(R.id.txtViewSignUp);

        txtViewTitleBar.setText(getString(R.string.hint_login));
    }

    private void manageClickEvents() {

        btnLogin.setOnClickListener(this);
        txtViewSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == txtViewSignUp) {
            Intent intent = new Intent(Login.this, RegisterNew.class);
            startActivity(intent);
            finish();
        } else if (view == btnLogin) {
            String userName = String.valueOf(edtTextUserName.getText());
            String password = String.valueOf(edtTextPassword.getText());

            if(isValidate(userName,password)){
                txtViewMessage.setText("");
                Toast.makeText(getApplicationContext(),
                        "you are login",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

    private Boolean isValidate(String userName, String password){

        if(userName.isEmpty() ){
            txtViewMessage.setText(getString(R.string.msg_userName));
            return false;
        }

        else if(password.isEmpty()){
            txtViewMessage.setText(getString(R.string.msg_password));
            return false;
        }
        return true;

    }
}
