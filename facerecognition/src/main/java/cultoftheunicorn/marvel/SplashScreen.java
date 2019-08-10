package cultoftheunicorn.marvel;


import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import org.opencv.cultoftheunicorn.marvel.R;

public class SplashScreen extends AppCompatActivity {

    String password;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_screen);


        SharedPreferences settings  = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(password.equals("")) {
                    Intent intent = new Intent(SplashScreen.this, AppAuthReg.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashScreen.this, AppAuthActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);

//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this, UserAuthActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 1000);

    }
}