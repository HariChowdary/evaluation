package com.infoplustech.smartscrutinization;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.infoplustech.smartscrutinization.evaluation.Eval_BundleEntryActivity;
import com.infoplustech.smartscrutinization.scrutiny.Scrutiny_BundleEntryActivity;

public class Scrutiny_OptionSelectionActivity extends Activity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.scrutiny_option_selection);
	//	getActionBar().setTitle(getString(R.string.title_activity));
	//	getActionBar().setIcon(0);
		findViewById(R.id.btn_scrutiny).setOnClickListener(this);
		findViewById(R.id.btn_scrut_correction).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		if(v.getId()==R.id.btn_scrutiny){
			 intent=new Intent(Scrutiny_OptionSelectionActivity.this, Eval_BundleEntryActivity.class);
			startActivity(intent);
		}else{
			intent=new Intent(Scrutiny_OptionSelectionActivity.this, Eval_BundleEntryActivity.class);
			startActivity(intent);
		}
	}
}
