package mg.m1p9.kidsedu.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import mg.m1p9.kidsedu.interfaces.CallbackListener;

public class Utils {


    static SharedPreferences sharedPreferences;

    public Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPref", 0);
    }

    public static void setPref(String Key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Key, value);
        editor.apply();
    }

    public static Boolean getPref(String Key, boolean value) {
        return sharedPreferences.getBoolean(Key, value);
    }


    public static void setPref(Context context, String key, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value);
        editor.apply();
    }
    public static String getPref(Context context, String key, String value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, value);
    }


    public static void setPref(Context context, String key, Integer value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(key, value);
        editor.apply();
    }

    public static Integer getPref(Context context, String key, Integer value) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, value);
    }

    public static void openInternetDialog(final CallbackListener callbackListener, final Boolean isSplash, final Context context) {
        if (!Utils.isNetworkConnected(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("No internet Connection");
            builder.setCancelable(false);
            builder.setMessage("Please turn on internet connection to continue");
            builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!isSplash) {
                        openInternetDialog(callbackListener, false,context);
                    }
                    dialog.dismiss();
                    callbackListener.onRetry();
                }
            });

            builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(homeIntent);
                    ((Activity)context).finishAffinity();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
