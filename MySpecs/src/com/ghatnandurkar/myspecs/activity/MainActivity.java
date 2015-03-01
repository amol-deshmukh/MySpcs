package com.ghatnandurkar.myspecs.activity;

import com.ghatnandurkar.myspecs.R;
import com.ghatnandurkar.myspecs.util.Utils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


	private TextView tvDeviceHeight;
	private TextView tvDeviceWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		innitialize();
		setSpecs();


	}

	private void setSpecs() {
		tvDeviceHeight.setText("Device Height= "+Utils.getDeviceHeight(this));
		tvDeviceWidth.setText("Device Width= "+Utils.getDeviceWidth(this));

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
