package com.infoplustech.smartscrutinization.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.infoplustech.smartscrutinization.R;

public class Eval_ShowBundleCompletedMessage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.small_bundle_completed_message);
		getActionBar().setIcon(R.drawable.ic_launchere);
		getActionBar().setTitle(" Evaluator");
		((TextView) findViewById(R.id.text1)).setText(getIntent().getStringExtra("totalCount"));
		((TextView) findViewById(R.id.text2)).setText(getIntent().getStringExtra("maxMarks"));
	/*	((TextView) findViewById(R.id.text4)).setText(getIntent().getStringExtra("maxMarks"));
		((TextView) findViewById(R.id.text5)).setText(getIntent().getStringExtra("avgMarks"));
		((TextView) findViewById(R.id.text6)).setText(getIntent().getStringExtra("Pass"));*/

		findViewById(R.id.btn_ok).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//navigateToTabletHomeScreen();
			//	finish();
				navigateToTabletHomeScreen();
				//Toast.makeText(Eval_ShowBundleCompletedMessage.this, "Please Release the Tab...!", Toast.LENGTH_SHORT).show();
			}
		});
	}     

	protected void navigateToTabletHomeScreen() {  
		// TODO Auto-generated method stub
		Intent in = new Intent(Eval_ShowBundleCompletedMessage.this,
				Eval_BundleEntryActivity.class);
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
			return false;
		}
		return false;
	}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
}

}
