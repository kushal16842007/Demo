package com.braintech.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterNew extends AppCompatActivity implements View.OnClickListener {

    TextView txtViewLogin;
    Button btnRegister;
    EditText edtTextFirstname;
    EditText edtTextLastName;
    EditText edtTextEmail;
    EditText edtTextPassword;
    EditText edtTextDescription;
    EditText edtTextPhoneNumber;
    RadioButton radioBtn;
    RadioButton radioBtnMale;
    RadioButton radioBtnFemale;
    RadioGroup radioGroupGender;
    CheckBox checkBoxCricket;
    CheckBox checkBoxFootball;
    CheckBox checkBoxStudy;
    CheckBox checkBoxTraveling;
    TextView txtViewTitle;

    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;
    String gender = "";
    String description;
    String hobbies = "";
   // String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new);
        initViews();
        manageClickEvent();


    }

    private void initViews() {
        txtViewLogin = (TextView) findViewById(R.id.txtViewLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtTextFirstname = (EditText) findViewById(R.id.edtTextFirstName);
        edtTextLastName = (EditText) findViewById(R.id.edtTextLastName);
        edtTextEmail = (EditText) findViewById(R.id.edtTextEmail);
        edtTextPassword = (EditText) findViewById(R.id.edtTextPassword);
        edtTextDescription = (EditText) findViewById(R.id.edtTextDescribtion);
        edtTextPhoneNumber = (EditText) findViewById(R.id.edtTextPhoneNumber);
        radioBtnMale = (RadioButton) findViewById(R.id.radioBtnMale);
        radioBtnFemale = (RadioButton) findViewById(R.id.radioBtnFemale);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        checkBoxCricket = (CheckBox) findViewById(R.id.checkBoxCricket);
        checkBoxFootball = (CheckBox) findViewById(R.id.checkBoxFootball);
        checkBoxStudy = (CheckBox) findViewById(R.id.checkBoxStudy);
        checkBoxTraveling = (CheckBox) findViewById(R.id.checkBoxTraveling);
        txtViewTitle = (TextView) findViewById(R.id.txtViewTitle);

        txtViewTitle.setText(getString(R.string.title_register));

    }

    private void manageClickEvent() {
        txtViewLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == txtViewLogin) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
        if (view == btnRegister) {
            edtTextGetData();
             if (isValidate()) {
                Intent intent = new Intent(this, DataShow.class);
                intent = dataBind(intent);
                Toast.makeText(getApplicationContext(),
                        "Your are Register",
                        Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }


        }
    }

    public boolean zeroLength(String s)
    {
        if(s.length()<=0)
            return true;
        else
            return false;
    }

    private boolean isValidate() {
        if (zeroLength(firstName)) {
            Toast.makeText(getApplicationContext(),
                    "Enter First Name",
                    Toast.LENGTH_SHORT).show();


            return false;
        } else if (zeroLength(lastName)) {
             Toast.makeText(getApplicationContext(),
                    "Enter Last Name",
                    Toast.LENGTH_SHORT).show();


            return false;
        } else if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            Toast.makeText(getApplicationContext(),
                    "Enter Email",
                    Toast.LENGTH_SHORT).show();


            return false;
        } else if (zeroLength(password)) {
           Toast.makeText(getApplicationContext(),
                    "Enter Password",
                    Toast.LENGTH_SHORT).show();


            return false;
        } else if (zeroLength(phoneNumber)) {
           Toast.makeText(getApplicationContext(),
                    "Enter PhoneNumber",
                    Toast.LENGTH_SHORT).show();


            return false;
        } else if (!(radioBtnMale.isChecked() || radioBtnFemale.isChecked())) {
            Toast.makeText(getApplicationContext(),
                    "Select Gender",
                    Toast.LENGTH_SHORT).show();


            return false;

        } else if (true) {
            if (checkBoxCricket.isChecked()) {
                hobbies += "Cricket";
            }
            if (checkBoxFootball.isChecked()) {
                hobbies += " Football";
            }
            if (checkBoxStudy.isChecked()) {
                hobbies += " Study";
            }
            if (checkBoxTraveling.isChecked()) {
                hobbies += " Traveling";
            }
            if (hobbies.length() <= 0) {
               Toast.makeText(getApplicationContext(),
                        "Select Hobbies",
                        Toast.LENGTH_SHORT).show();


                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public Intent dataBind(Intent intent)
    {
        intent.putExtra(Const.KEY_FIRST_NAME, firstName);
        intent.putExtra(Const.KEY_LAST_NAME, lastName);
        intent.putExtra(Const.KEY_PHONE_NUMBER, phoneNumber);
        intent.putExtra(Const.KEY_EMAIL, email);
        intent.putExtra(Const.KEY_GENDER, gender);
        intent.putExtra(Const.KEY_DISCRIPTION, description);
        return intent;
    }

    public void edtTextGetData()
    {
        firstName = String.valueOf(edtTextFirstname.getText()).trim();
        lastName = String.valueOf(edtTextLastName.getText()).trim();
        email = String.valueOf(edtTextEmail.getText()).trim();
        password = String.valueOf(edtTextPassword.getText()).trim();
        phoneNumber = String.valueOf(edtTextPhoneNumber.getText()).trim();
        description = String.valueOf(edtTextDescription.getText()).trim();
        //description = description.trim();

        int selectedId = radioGroupGender.getCheckedRadioButtonId();
       // radioBtnMale = (RadioButton) findViewById(selectedId);
        radioBtn = (RadioButton) findViewById(selectedId);
        gender = String.valueOf(radioBtn.getText());
       // gender = String.valueOf(radioBtn.getText());
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this,"onStartMain",Toast.LENGTH_SHORT).show();
        Log.d("onstart","onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this,"onResumeMain",Toast.LENGTH_SHORT).show();
        Log.d("onResume","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this,"onPauseMain",Toast.LENGTH_SHORT).show();
        Log.d("onPause","onPause");

    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this,"onStopMain",Toast.LENGTH_SHORT).show();
        Log.d("onStop","onstop");

    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroyMain", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy","onDestroy");

    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        //Toast.makeText(this, "onRestartMain", Toast.LENGTH_SHORT).show();
        Log.d("onRestart","onRestart");
    }

}
