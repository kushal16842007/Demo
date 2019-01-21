package com.braintech.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    Button btnRegister;
    TextView txtViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        manageClickEvent();


    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtViewTitle = (TextView) findViewById(R.id.txtViewTitle);

        txtViewTitle.setText(getString(R.string.title_home_page));
    }

    private void manageClickEvent() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            Intent intent = new Intent(this, Login.class);
            System.out.print("hello Main Activity");
            startActivity(intent);
        }
        if (view == btnRegister) {
            Intent intent = new Intent(this, RegisterNew.class);
            startActivity(intent);
        }
    }

}
