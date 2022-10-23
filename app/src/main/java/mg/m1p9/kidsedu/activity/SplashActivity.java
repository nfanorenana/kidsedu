package mg.m1p9.kidsedu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import mg.m1p9.kidsedu.MainActivity;
import mg.m1p9.kidsedu.R;
import mg.m1p9.kidsedu.interfaces.CallbackListener;
import mg.m1p9.kidsedu.utils.Utils;

public class SplashActivity extends AppCompatActivity implements CallbackListener {

    @Override
    public void onSuccess() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onRetry() {
        callApi();
    }


    Context context;
    private Handler handler = new Handler();
    private Boolean isLoaded = false;
    private static final String SPLASH_SCREEN_COUNT = "splash_screen_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        context = this;
        callApi();

    }

    public void callApi() {
        if (Utils.isNetworkConnected(this)) {
            successCall();
        } else {
            Utils.openInternetDialog(this, true,this);
        }

        handler.postDelayed(myRunnable, 10000);
    }

    private void successCall() {
        if (Utils.getPref(this, SPLASH_SCREEN_COUNT, 1) == 1) {
            Log.e("TAG", "successCall::::IFFFFF " + Utils.getPref(this, SPLASH_SCREEN_COUNT, 1));
            Utils.setPref(this, SPLASH_SCREEN_COUNT, 2);

            startNextActivity(1000);
        } else {
            Log.e("TAG", "successCall::::ELSEEE " + Utils.getPref(this, SPLASH_SCREEN_COUNT, 1));
        }
    }

    public void startNextActivity(Integer time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }

    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            if (Utils.isNetworkConnected(SplashActivity.this)) {
                if (!isLoaded) {
                    startNextActivity(0);
                }
            }
        }
    };


}
