
package com.infoplustech.smartscrutinization.scrutiny;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.infoplustech.smartscrutinization.R;
import com.infoplustech.smartscrutinization.db.SScrutinyDatabase;

import static com.infoplustech.smartscrutinization.utils.SSConstants.DATABASE_FILE_PATH_TO_SSCRUTINY;

public class Scrutiny_BundleEntryActivity extends Activity implements
		OnClickListener {

	EditText etEvaluator, etBundleNo;
	String userId, bundleNo;
	SScrutinyDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrutiny_layout_bundle_no_entry);
		getActionBar().setTitle("     Chief Examiner");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setIcon(R.drawable.back_ar);
		database = SScrutinyDatabase.getInstance(this);
		etEvaluator= (EditText) findViewById(R.id.evaluator);
		etEvaluator.setHint("Enter Chief Examiner ID");
		etBundleNo = (EditText) findViewById(R.id.et_bundle_no);
		etBundleNo.setVisibility(View.VISIBLE);
		etBundleNo.setFocusable(true);
		etBundleNo.setFocusableInTouchMode(true);
		findViewById(R.id.btn_submit).setOnClickListener(this);
		if(!DATABASE_FILE_PATH_TO_SSCRUTINY.exists())
			showAlert123("Please check Database files",
					getString(R.string.alert_dialog_ok), "");
	}


	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_submit) {
			// here call webservice and submit to DB
			submit();
		}
	}
	private void showAlert123(String msg, String positiveStr, String negativeStr) {
		AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
				new ContextThemeWrapper(this, R.style.alert_text_style));
		myAlertDialog.setTitle("Alert");
		myAlertDialog.setMessage(msg);
		myAlertDialog.setCancelable(false);

		myAlertDialog.setPositiveButton(positiveStr,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						finish();
						dialog.dismiss();

					}
				});

		myAlertDialog.setNegativeButton(negativeStr,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						// do something when the OK button is
						// clicked
						finish();
						dialog.dismiss();
					}
				});

		myAlertDialog.show();
	}
	// call this method when clicked on submit button
	private void submit() {
		bundleNo = ((EditText) findViewById(R.id.et_bundle_no)).getText()
				.toString().trim();
		userId = ((EditText) findViewById(R.id.evaluator)).getText()
				.toString().trim();
if(!userId.isEmpty()&&userId.length()==4){
			String strQuery;
			 strQuery = "select * from table_user where TRIM(UPPER(login)) =TRIM(UPPER('"
					+ userId + "')) AND active_status=1";

			Cursor cursorq = database.executeSQLQuery(strQuery, null);
			if (cursorq != null && cursorq.getCount() > 0) {

				if (!TextUtils.isEmpty(bundleNo)
						&& (bundleNo.length() == 4)) {
				String _strQuery = "select * from table_marks_scrutinize "
						+ "where TRIM(UPPER(bundle_no)) = TRIM(UPPER('"
						+ bundleNo
						+ "'))";
					Cursor _cursor = database.executeSQLQuery(_strQuery, null);
					if (_cursor != null && _cursor.getCount() > 0) {
								int count = _cursor.getCount();
					Intent intent=new Intent(Scrutiny_BundleEntryActivity.this, Scrutiny_MarksEntryActivity.class);
						intent.putExtra("bundleNo", bundleNo.toUpperCase().trim());
						intent.putExtra("userId", userId.toUpperCase().trim());
						intent.putExtra("totalCount",count);
						startActivity(intent);
					} else {
						((EditText) findViewById(R.id.et_bundle_no)).setText("");
						showAlert("Enter Assigned Bundle Number",
								getString(R.string.alert_dialog_ok), "");
					}
					if (_cursor != null)
						_cursor.close();
				} else {
					((EditText) findViewById(R.id.et_bundle_no)).setText("");
					showAlert(getString(R.string.alert_enter_valid_bundle),
							getString(R.string.alert_dialog_ok), "");
				}
			} else {
				((EditText) findViewById(R.id.evaluator)).setText("");
				showAlert("Enter Assigned Chief Examiner ID",
						getString(R.string.alert_dialog_ok), "");
			}
	if (cursorq != null)
		cursorq.close();

} else {
	((EditText) findViewById(R.id.evaluator)).setText("");
	showAlert("Enter valid Chief Examiner ID",
			getString(R.string.alert_dialog_ok), "");
}
}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void showAlert(String msg, String positiveStr, String negativeStr) {
		AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
				new ContextThemeWrapper(this, R.style.alert_text_style));
		myAlertDialog.setTitle("Alert");
		myAlertDialog.setMessage(msg);
		myAlertDialog.setCancelable(false);

		myAlertDialog.setPositiveButton(positiveStr,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						// do something when the OK button is
						// clicked
						dialog.dismiss();

					}
				});

		myAlertDialog.setNegativeButton(negativeStr,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						// do something when the OK button is
						// clicked
						dialog.dismiss();
					}
				});

		myAlertDialog.show();
	}


}
