package im.xun.phoneinfo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String phoneInfo() {
        final TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        String android_id = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);

        StringBuilder sb = new StringBuilder();
        sb.append("tm.getDeviceId(): " + tm.getDeviceId() + "\n");
        sb.append("tm.getLine1Number(): " + tm.getLine1Number() + "\n");
        sb.append("tm.getNetworkCountryIso(): " + tm.getNetworkCountryIso() + "\n");
        sb.append("tm.getNetworkOperator(): " + tm.getNetworkOperator() + "\n");
        sb.append("tm.getSimSerialNumber(): " + tm.getSimSerialNumber() + "\n");
        sb.append("android.os.Build.BOARD: " + Build.BOARD+ "\n");
        sb.append("android.os.Build.MODEL: " + Build.MODEL+ "\n");
        sb.append("android.os.Build.MANUFACTURER: " + Build.MANUFACTURER+ "\n");
        sb.append("android.os.Build.ID: " + Build.ID+ "\n");
        sb.append("android.os.Build.DEVICE: " + Build.DEVICE+ "\n");
        sb.append("android.os.Build.SERIAL: " + Build.SERIAL+ "\n");
        sb.append("android.os.Build.BRAND: " + Build.BRAND+ "\n");
        sb.append("Secure.ANDROID_ID: " + android_id + "\n");
        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView tv = (TextView) findViewById(R.id.info);
        tv.setText(phoneInfo());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Refresh", Toast.LENGTH_LONG).show();
                tv.setText(phoneInfo());
            }
        });
    }

}
