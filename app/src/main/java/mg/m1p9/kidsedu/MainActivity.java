package mg.m1p9.kidsedu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import mg.m1p9.kidsedu.activity.SettingActivity;
import mg.m1p9.kidsedu.adapter.HomeAdapter;
//import mg.m1p9.kidsedu.database.DatabaseHelper;
import mg.m1p9.kidsedu.interfaces.CallbackListener;
import mg.m1p9.kidsedu.utils.Utils;

public class MainActivity extends AppCompatActivity implements CallbackListener {

    Context context;
    //DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        context=this;
        initDefine();
        //databaseHelper = new DatabaseHelper(context);
        //try {
            //databaseHelper.createDataBase();
        //} catch (Exception e) {
          //  e.printStackTrace();
        //}
        successCall();
        try {
            //subScribeToFirebaseTopic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subScribeToFirebaseTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic("kids_play_topic")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Log.e("subScribeFirebaseTopic", ": Fail");
                        } else {
                            Log.e("subScribeFirebaseTopic", ": Success");
                        }
                    }
                });

    }


    private void successCall() {
        if (Utils.isNetworkConnected(this)) {

        } else {
            Utils.openInternetDialog(this, true,this);
        }
    }

    public int[] arrOfCategory;
    private void initDefine() {
        rvCategory=findViewById(R.id.rvCategory);
        setRvAdapter();
    }


    public void onClickSetting(View view){
        Intent intent= new Intent(MainActivity.this, SettingActivity.class);
        startActivityForResult(intent,111);
    }

    HomeAdapter homeAdapter;
    RecyclerView rvCategory;
    private void setRvAdapter() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);
        homeAdapter=new HomeAdapter(context,arrOfCategory);
        rvCategory.setAdapter(homeAdapter);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onRetry() {

    }
}