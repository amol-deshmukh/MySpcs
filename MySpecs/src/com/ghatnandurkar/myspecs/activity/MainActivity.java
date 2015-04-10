package com.ghatnandurkar.myspecs.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ghatnandurkar.myspecs.R;
import com.ghatnandurkar.myspecs.utils.Utils;

public class MainActivity extends Activity {


	private TextView tvDeviceHeight;
	private TextView tvDeviceWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		innitialize();
		setSpecs(getApplicationContext());
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
		Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);
		
		// How are we charging?
		int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
		boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

		
		System.out.println("Charging mode: ");
		System.out.println("USB CHARGE: "+usbCharge);
		System.out.println("AC CHARGE: "+acCharge);
		int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level / (float)scale;
        System.out.println("Battery Level= "+batteryPct+" %");
        
        
	}

	private void setSpecs(Context context) {
		tvDeviceHeight.setText("Device Height= "+Utils.getDeviceHeight(context)+" px");
		tvDeviceWidth.setText("Device Width= "+Utils.getDeviceWidth(context)+" px");

	}

	private void innitialize() {
		tvDeviceHeight=(TextView) findViewById(R.id.deviceHeight);
		tvDeviceWidth=(TextView) findViewById(R.id.deviceWidth);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
