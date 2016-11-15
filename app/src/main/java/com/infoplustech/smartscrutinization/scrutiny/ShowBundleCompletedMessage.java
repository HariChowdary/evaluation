package com.infoplustech.smartscrutinization.scrutiny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.infoplustech.smartscrutinization.R;

public class ShowBundleCompletedMessage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empty_bundle_completed_message);
		getActionBar().setTitle(" Chief Examiner");

		/*((TextView) findViewById(R.id.text1)).setText(getIntent().getStringExtra("sub_id"));
		((TextView) findViewById(R.id.text3)).setText(getIntent().getStringExtra("totalCount"));
		((TextView) findViewById(R.id.text4)).setText(getIntent().getStringExtra("maxMarks"));
		((TextView) findViewById(R.id.text5)).setText(getIntent().getStringExtra("avgMarks"));
		((TextView) findViewById(R.id.text6)).setText(getIntent().getStringExtra("Pass"));*/

		findViewById(R.id.btn_ok).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//navigateToTabletHomeScreen();
			//	finish();
				navigateToTabletHomeScreen();
				//Toast.makeText(ShowBundleCompletedMessage.this, "Please Release the Tab...!", Toast.LENGTH_SHORT).show();
			}
		});
	}     

	protected void navigateToTabletHomeScreen() {  
		// TODO Auto-generated method stub
		Intent in = new Intent(ShowBundleCompletedMessage.this,
				Scrutiny_BundleEntryActivity.class);
		in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		in.addCategory(Intent.CATEGORY_HOME);
		startActivity(in);
	}

	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_HOME) {
			return false;
		}
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(this,
					getResources().getString(R.string.alert_press_home),
					Toast.LENGTH_LONG).show();
			return false;
		}
		return false;
	}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	Toast.makeText(this,
			getResources().getString(R.string.alert_press_home),
			Toast.LENGTH_LONG).show();
}

}
