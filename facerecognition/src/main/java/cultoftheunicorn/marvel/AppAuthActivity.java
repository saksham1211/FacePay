package cultoftheunicorn.marvel;


import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class AppAuthActivity extends AppCompatActivity {

    EditText pass;
    String password,inputpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_auth);
        pass = (EditText) findViewById(R.id.enterpwd);

        SharedPreferences settings  = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");
    }

    public void Click(View view) {
        inputpassword = pass.getText().toString();

        if(inputpassword.equals(password)){
            Intent intent = new Intent(AppAuthActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Password didn't match",Toast.LENGTH_LONG).show();
        }

    }
}