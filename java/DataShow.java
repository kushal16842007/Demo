package com.braintech.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataShow extends AppCompatActivity {
    TextView txtViewDataShow;
    TextView txtViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        initView();
        showData();


    }

    private void initView() {
        txtViewDataShow = (TextView) findViewById(R.id.txtViewDataShow);
        txtViewTitle = (TextView) findViewById(R.id.txtViewTitle);

        txtViewTitle.setText(getString(R.string.title_details));
    }

    private void showData() {

        Intent intent = getIntent();

        if (intent != null) {

            if (intent.hasExtra(Const.KEY_FIRST_NAME)) {

                String FirstName = intent.getStringExtra(Const.KEY_FIRST_NAME);
                String LastName = intent.getStringExtra(Const.KEY_LAST_NAME);
                String MobileNumber = intent.getStringExtra(Const.KEY_PHONE_NUMBER);
                String Email = intent.getStringExtra(Const.KEY_EMAIL);
                String Gender = intent.getStringExtra(Const.KEY_GENDER);
                String Description = intent.getStringExtra(Const.KEY_DISCRIPTION);
                txtViewDataShow.setText("\n\n Name : " + FirstName + LastName + "\n\n Mobile Number :" + MobileNumber + "\n\n Email : " + Email + "\n\n Gender : " + Gender + "\n\n Description : " + Description);


            }


        }





    }
}
