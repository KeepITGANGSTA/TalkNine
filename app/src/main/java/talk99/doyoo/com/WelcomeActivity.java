package talk99.doyoo.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status();
        setContentView(R.layout.activity_welcome);
        startHomeActivity();
    }


    private void startHomeActivity(){
        timer=new Timer();
        tt=new TimerTask() {
            @Override
            public void run() {
                Intent intentHome=new Intent(WelcomeActivity.this,HomeActivity.class);
                startActivity(intentHome);
                finish();
//                runOnUiThread(() -> {
//                    Intent intentHome=new Intent(WelcomeActivity.this,HomeActivity.class);
//                    Log.d("Welcome","当前版本："+Build.VERSION.SDK_INT);
//                    if (Build.VERSION.SDK_INT>=21){
//                        Log.d("Welcome","走21以上");
//                        startActivity(intentHome, ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this).toBundle());
//
//                    }else {
//                        Log.d("Welcome","走21以下");
//                        startActivity(intentHome);
//
//                    }
//                });

            }
        };
        timer.schedule(tt,3000);
    }

    /**
     *  全屏
     */
    private void status() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer!=null){
            timer.cancel();
            timer=null;
        }
        if (tt!=null){
            tt.cancel();
            tt=null;
        }
    }
}
