
package com.infoplustech.smartscrutinization.evaluation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.infoplustech.smartscrutinization.R;
import com.infoplustech.smartscrutinization.db.DBHelper;
import com.infoplustech.smartscrutinization.db.SScrutinyDatabase;

import java.io.File;
import java.util.ArrayList;

import static com.infoplustech.smartscrutinization.db.DataBaseUtility.EVALUATION_DATABASE_FILE_PATH;

public class Eval_BundleEntryActivity extends Activity implements
		OnClickListener {

	EditText etEvaluator;
	//String userId, bundleNo;
	DBHelper database;
	Spinner spin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrutiny_layout_bundle_no_entry);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("     Evaluator");
		getActionBar().setIcon(R.drawable.back_ar);
		database = DBHelper.getInstance(this);
		etEvaluator= (EditText) findViewById(R.id.evaluator);
	//	etBundleNo = (EditText) findViewById(R.id.et_bundle_no);
		spin = (Spinner) findViewById(R.id.spin_course);
		spin.setVisibility(View.VISIBLE);
	//	etBundleNo.setFocusable(true);
	//	etBundleNo.setFocusableInTouchMode(true);
		findViewById(R.id.btn_submit).setOnClickListener(this);
		if(EVALUATION_DATABASE_FILE_PATH.exists()) {
			Cursor cur_Course = null;
			try {
				cur_Course = database
						.executeSelectSQLQuery("select program_name,program_id from table_program");

				ArrayList<String> program = new ArrayList<String>();
				if ((cur_Course != null) && (cur_Course.getCount() > 0)) {
					program.add("Select Course");
					while (!cur_Course.isAfterLast()) {
						program.add(cur_Course.getString(cur_Course
								.getColumnIndex("program_name")));
						cur_Course.moveToNext();
					}
					if (!program.isEmpty()) {
						spin.setAdapter(new ArrayAdapter<String>(this,
								R.layout.layout_textview, program));
					}

				} else {

					showAlert("Please check Database",
							getString(R.string.alert_dialog_ok), "");
				}

			} catch (Exception ex) {
			} finally {
				cur_Course.close();
			}
		}else{
			showAlert123("Please check Database files",
					getString(R.string.alert_dialog_ok), "");
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_submit) {
			// here call webservice and submit to DB
			submit();
		}
	}

	// call this method when clicked on submit button
	public String submit() {
	//	String bundleNo = ((EditText) findViewById(R.id.et_bundle_no)).getText()
		//		.toString().trim();
		String userId = ((EditText) findViewById(R.id.evaluator)).getText()
				.toString().trim();
		String Bundle = null;
		Cursor cursor = null;
		String SubjectId = null;
		String SubjectCode = null;
		String program = null;
		int MaxAnswerBook=0;
		if(!userId.isEmpty()&&userId.length()==4) {
			try {
				cursor = database
						.executeSelectSQLQuery("select tb.subject_id,tb.bundle_no,tb.subject_code, tb.total_scripts, " +
								"tb.program_name from table_user tu, table_bundle tb "
								+ "where "
								+ "tu.user_id=tb.enter_by and UPPER(tu.user_id)=UPPER('"
								+ userId + "') and tu.active_status=0");
				if ((cursor != null) && (cursor.getCount() > 0)) {
					while (!(cursor.isAfterLast())) {
						SubjectId = cursor.getString(cursor
								.getColumnIndex("subject_id"));
						Bundle = cursor.getString(cursor
								.getColumnIndex("bundle_no"));
						SubjectCode = cursor.getString(cursor
								.getColumnIndex("subject_code"));
						MaxAnswerBook = cursor.getInt(cursor
								.getColumnIndex("total_scripts"));
						program = cursor.getString(cursor
								.getColumnIndex("program_name"));
						cursor.moveToNext();
					}
				} else {
					((EditText) findViewById(R.id.evaluator)).setText("");
					showAlert("Enter Assigned Evaluator ID",
							getString(R.string.alert_dialog_ok), "");
					return null;
				}
			} catch (Exception ex) {
				showAlert("Database Error",
						getString(R.string.alert_dialog_ok), "");
			} finally {
				cursor.close();
			}
		//	if (!TextUtils.isEmpty(bundleNo) && (bundleNo.length() == 4)) {
		//		if (Bundle.equals(bundleNo)) {
					if (!spin.getSelectedItem().toString().equals("Select Course")) {
						if (spin.getSelectedItem().toString().equals(program)) {
							Intent intent = new Intent(Eval_BundleEntryActivity.this, Eval_MarksEntryActivity.class);
							intent.putExtra("bundleNo", Bundle.toUpperCase().trim());
							intent.putExtra("userId", userId.toUpperCase().trim());
							intent.putExtra("totalCount", MaxAnswerBook);
							intent.putExtra("subject_code", SubjectCode);
							startActivity(intent);
						} else {
							showAlert("Please Verify Selected Course",
									getString(R.string.alert_dialog_ok), "");
						}
					} else {
						showAlert("Please Select Course",
								getString(R.string.alert_dialog_ok), "");
					}
				/*} else {
					((EditText) findViewById(R.id.et_bundle_no)).setText("");
					showAlert("Enter Assigned Bundle Number",
							getString(R.string.alert_dialog_ok), "");
				}
			} else {
				((EditText) findViewById(R.id.et_bundle_no)).setText("");
				showAlert(getString(R.string.alert_enter_valid_bundle),
						getString(R.string.alert_dialog_ok), "");
			}*/
		} else {
			((EditText) findViewById(R.id.evaluator)).setText("");
			showAlert("Enter Valid Evaluator ID",
					getString(R.string.alert_dialog_ok), "");
		}

		return Bundle;
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
}
