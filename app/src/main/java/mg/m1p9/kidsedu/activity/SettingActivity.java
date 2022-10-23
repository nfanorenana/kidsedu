package mg.m1p9.kidsedu.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mg.m1p9.kidsedu.R;
import mg.m1p9.kidsedu.utils.Utils;

public class SettingActivity extends AppCompatActivity {

    private static String SOUND="Sound";
    private static boolean switchState=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        initDefine();
    }

    Switch soundOnOff;
    private void initDefine() {
        soundOnOff=findViewById(R.id.soundOnOff);
        if(Utils.getPref(SOUND,true)){
            soundOnOff.setChecked(true);
            switchState=true;
        }else{
            switchState=false;
            soundOnOff.setChecked(false);
        }
        soundOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchState){
                    switchState=false;
                    soundOnOff.setChecked(false);
                    Utils.setPref(SOUND,false);
                }else {
                    switchState=true;
                    soundOnOff.setChecked(true);
                    Utils.setPref(SOUND,true);
                }
            }
        });

    }

    public void onClickBack(View view) {
        finish();
    }
}
