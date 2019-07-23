package com.tencent.android.qqdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import java.io.IOException;

public class InstallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_PACKAGE_ADDED.equals(intent.getAction())){
            String pkg = intent.getDataString();
            Log.e("InstallReceiver", "added:" + pkg);
            reboot(pkg, context);
        }
        if(Intent.ACTION_PACKAGE_REPLACED.equals(intent.getAction())){
            String pkg = intent.getDataString();
            Log.e("InstallReceiver", "replaced:" + pkg);
            reboot(pkg, context);
        }
        if(Intent.ACTION_PACKAGE_REMOVED.equals(intent.getAction())){
            String pkg = intent.getDataString();
            Log.e("InstallReceiver", "removed:" + pkg);
        }
    }

    public void reboot(String pkg, Context context){
        if(pkg.equals("package:cn.knowbox.hermes")){
            Log.e("InstallReceiver", "reboot:" + pkg);
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            pm.reboot("");
//            try {
//                Runtime.getRuntime().exec("reboot");
//            } catch (IOException e) {
//                Log.e("InstallReceiver", "InstallReceiver", e);
//            }
        }
    }
}
