package cultoftheunicorn.marvel;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class AppAuthReg extends AppCompatActivity {

    EditText pwd,pwdconfirm;
    String getpwd,confirmpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_auth_reg);
        pwd = (EditText) findViewById(R.id.pwd);
        pwdconfirm = (EditText) findViewById(R.id.pwd_confirm);


    }

    public void Reg(View view) {
        getpwd = pwd.getText().toString();
        confirmpwd = pwdconfirm.getText().toString();

        if(getpwd.equals("")||confirmpwd.equals("")){
            Toast.makeText(getApplicationContext(),"ENter password",Toast.LENGTH_SHORT).show();
        }
        if(getpwd.equals(confirmpwd)){
            SharedPreferences settings  = getSharedPreferences("PREFS",0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("password",getpwd);
            editor.apply();

            Intent intent = new Intent(AppAuthReg.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Password didn't match",Toast.LENGTH_LONG).show();
        }

    }
}