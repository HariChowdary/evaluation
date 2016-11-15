
package com.infoplustech.smartscrutinization.evaluation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.infoplustech.smartscrutinization.R;
import com.infoplustech.smartscrutinization.db.DBHelper;
import com.infoplustech.smartscrutinization.db.SScrutinyDatabase;
import com.infoplustech.smartscrutinization.utils.SSConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Eval_MarksSummryActivity extends Activity implements
		OnClickListener {

	String userId, bundleNo, sub_code;
	DBHelper database;
	Integer sum= 0;
int TotalCount=0;
	ArrayList<String> snArray=new ArrayList<String>();
	ArrayList<String> tmArray=new ArrayList<String>();
	ArrayList<String> rmArray=new ArrayList<String>();
	int passCount=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrutiny_marks_summary_activity);
		database = DBHelper.getInstance(this);
		getActionBar().setIcon(R.drawable.ic_launchere);
		getActionBar().setTitle(" Evaluator");
		bundleNo= getIntent().getStringExtra("bundleNo");
		userId= getIntent().getStringExtra("userId");
		TotalCount= getIntent().getIntExtra("totalCount", 0);
		sub_code= getIntent().getStringExtra("sub_id");
		snArray=getIntent().getStringArrayListExtra("sn");
		tmArray=getIntent().getStringArrayListExtra("tm");
		rmArray=getIntent().getStringArrayListExtra("rm");

		((TextView) findViewById(R.id.evaluatorid)).setText(userId);
		((TextView) findViewById(R.id.bundle_id)).setText(bundleNo);
		((TextView) findViewById(R.id.sub_id)).setText(sub_code);
		for (int i=0;i<snArray.size();i++)
			setDatatoView(i);

		findViewById(R.id.sumry).setVisibility(View.VISIBLE);
		findViewById(R.id.back).setVisibility(View.VISIBLE);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		findViewById(R.id.btn_ok).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				submit1();
			}
		});
		try{
			for (String str : tmArray) {
				arrayOfInts.add(Integer.parseInt(str));
			}
		}catch (Exception e){

		}

		for (Integer i:arrayOfInts) {
			sum = sum + i;
			if(i>=35)
				passCount++;
		}
	}
	ArrayList<Integer> arrayOfInts = new ArrayList<Integer>();

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_submit) {
			// here call webservice and submit to DB
			submit1();
		}
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
	private void setDatatoView(int no){
		no++;
		switch (no){
			case 1: setValuestoViews (1,R.id.tr_1,R.id.sn_1, R.id.tm_1,R.id.rm_1);  break;
			case 2: setValuestoViews (2,R.id.tr_2,R.id.sn_2, R.id.tm_2,R.id.rm_2);  break;
			case 3: setValuestoViews (3,R.id.tr_3,R.id.sn_3, R.id.tm_3,R.id.rm_3);  break;
			case 4: setValuestoViews (4,R.id.tr_4,R.id.sn_4, R.id.tm_4,R.id.rm_4);  break;
			case 5: setValuestoViews (5,R.id.tr_5,R.id.sn_5, R.id.tm_5,R.id.rm_5);  break;
			case 6: setValuestoViews (6,R.id.tr_6,R.id.sn_6, R.id.tm_6,R.id.rm_6);  break;
			case 7: setValuestoViews (7,R.id.tr_7,R.id.sn_7, R.id.tm_7,R.id.rm_7);  break;
			case 8: setValuestoViews (8,R.id.tr_8,R.id.sn_8, R.id.tm_8,R.id.rm_8);  break;
			case 9: setValuestoViews (9,R.id.tr_9,R.id.sn_9, R.id.tm_9,R.id.rm_9);  break;
			case 10: setValuestoViews (10,R.id.tr_10,R.id.sn_10, R.id.tm_10,R.id.rm_10);  break;
			case 11: setValuestoViews (11,R.id.tr_11,R.id.sn_11, R.id.tm_11,R.id.rm_11);  break;
			case 12: setValuestoViews (12,R.id.tr_12,R.id.sn_12, R.id.tm_12,R.id.rm_12);  break;
			case 13: setValuestoViews (13,R.id.tr_13,R.id.sn_13, R.id.tm_13,R.id.rm_13);  break;
			case 14: setValuestoViews (14,R.id.tr_14,R.id.sn_14, R.id.tm_14,R.id.rm_14);  break;
			case 15: setValuestoViews (15,R.id.tr_15,R.id.sn_15, R.id.tm_15,R.id.rm_15);  break;
			case 16: setValuestoViews (16,R.id.tr_16,R.id.sn_16, R.id.tm_16,R.id.rm_16);  break;
			case 17: setValuestoViews (17,R.id.tr_17,R.id.sn_17, R.id.tm_17,R.id.rm_17);  break;
			case 18: setValuestoViews (18,R.id.tr_18,R.id.sn_18, R.id.tm_18,R.id.rm_18);  break;
			case 19: setValuestoViews (19,R.id.tr_19,R.id.sn_19, R.id.tm_19,R.id.rm_19);  break;
			case 20: setValuestoViews (20,R.id.tr_20,R.id.sn_20, R.id.tm_20,R.id.rm_20);  break;
			case 21: setValuestoViews (21,R.id.tr_21,R.id.sn_21, R.id.tm_21,R.id.rm_21);  break;
			case 22: setValuestoViews (22,R.id.tr_22,R.id.sn_22, R.id.tm_22,R.id.rm_22);  break;
			case 23: setValuestoViews (23,R.id.tr_23,R.id.sn_23, R.id.tm_23,R.id.rm_23);  break;
			case 24: setValuestoViews (24,R.id.tr_24,R.id.sn_24, R.id.tm_24,R.id.rm_24);  break;
			case 25: setValuestoViews (25,R.id.tr_25,R.id.sn_25, R.id.tm_25,R.id.rm_25);  break;
			case 26: setValuestoViews (26,R.id.tr_26,R.id.sn_26, R.id.tm_26,R.id.rm_26);  break;
			case 27: setValuestoViews (27,R.id.tr_27,R.id.sn_27, R.id.tm_27,R.id.rm_27);  break;
			case 28: setValuestoViews (28,R.id.tr_28,R.id.sn_28, R.id.tm_28,R.id.rm_28);  break;
			case 29: setValuestoViews (29,R.id.tr_29,R.id.sn_29, R.id.tm_29,R.id.rm_29);  break;
			case 30: setValuestoViews (30,R.id.tr_30,R.id.sn_30, R.id.tm_30,R.id.rm_30);  break;
			case 31: setValuestoViews (31,R.id.tr_31,R.id.sn_31, R.id.tm_31,R.id.rm_31);  break;
			case 32: setValuestoViews (32,R.id.tr_32,R.id.sn_32, R.id.tm_32,R.id.rm_32);  break;
			case 33: setValuestoViews (33,R.id.tr_33,R.id.sn_33, R.id.tm_33,R.id.rm_33);  break;
			case 34: setValuestoViews (34,R.id.tr_34,R.id.sn_34, R.id.tm_34,R.id.rm_34);  break;
			case 35: setValuestoViews (35,R.id.tr_35,R.id.sn_35, R.id.tm_35,R.id.rm_35);  break;
			case 36: setValuestoViews (36,R.id.tr_36,R.id.sn_36, R.id.tm_36,R.id.rm_36);  break;
			case 37: setValuestoViews (37,R.id.tr_37,R.id.sn_37, R.id.tm_37,R.id.rm_37);  break;
			case 38: setValuestoViews (38,R.id.tr_38,R.id.sn_38, R.id.tm_38,R.id.rm_38);  break;
			case 39: setValuestoViews (39,R.id.tr_39,R.id.sn_39, R.id.tm_39,R.id.rm_39);  break;
			case 40: setValuestoViews (40,R.id.tr_40,R.id.sn_40, R.id.tm_40,R.id.rm_40);  break;
			case 41: setValuestoViews (41,R.id.tr_41,R.id.sn_41, R.id.tm_41,R.id.rm_41);  break;
			case 42: setValuestoViews (42,R.id.tr_42,R.id.sn_42, R.id.tm_42,R.id.rm_42);  break;
			case 43: setValuestoViews (43,R.id.tr_43,R.id.sn_43, R.id.tm_43,R.id.rm_43);  break;
			case 44: setValuestoViews (44,R.id.tr_44,R.id.sn_44, R.id.tm_44,R.id.rm_44);  break;
			case 45: setValuestoViews (45,R.id.tr_45,R.id.sn_45, R.id.tm_45,R.id.rm_45);  break;
			case 46: setValuestoViews (46,R.id.tr_46,R.id.sn_46, R.id.tm_46,R.id.rm_46);  break;
			case 47: setValuestoViews (47,R.id.tr_47,R.id.sn_47, R.id.tm_47,R.id.rm_47);  break;
			case 48: setValuestoViews (48,R.id.tr_48,R.id.sn_48, R.id.tm_48,R.id.rm_48);  break;
			case 49: setValuestoViews (49,R.id.tr_49,R.id.sn_49, R.id.tm_49,R.id.rm_49);  break;
			case 50: setValuestoViews (50,R.id.tr_50,R.id.sn_50, R.id.tm_50,R.id.rm_50);  break;
			}
	}

	private void setValuestoViews(int id, int tr_id, int sn_id, int tm_id, int remarks_id) {
		try {
			 findViewById(tr_id).setVisibility(View.VISIBLE);
			((EditText) findViewById(sn_id)).setText(snArray.get(id-1));
			((EditText) findViewById(tm_id)).setText(tmArray.get(id-1));
			((EditText) findViewById(remarks_id)).setText(rmArray.get(id-1));
			findViewById(sn_id).setEnabled(false);
			findViewById(tm_id).setEnabled(false);
			 findViewById(remarks_id).setEnabled(false);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	// call this method when clicked on submit button

	private void submit1() {
		ScriptSubmissionAlert();
	}
	private void ScriptSubmissionAlert() {
		AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
		myAlertDialog.setTitle("Smart Evaluation");
		myAlertDialog
				.setMessage("You have Completed the Bundle, and No More Edits are Possible if Submitted");
		myAlertDialog.setCancelable(false);

		myAlertDialog.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int arg1) {

						upDateMarks();
						updateDBCompleted();
						updateBundleStatusByBundleNo(bundleNo, 1);
						Intent intent=new Intent(Eval_MarksSummryActivity.this, Eval_ShowBundleCompletedMessage.class);
						intent.putExtra("totalCount",""+TotalCount);
						intent.putExtra("sub_id",""+sub_code);
						intent.putExtra("maxMarks",""+sum);
						double dd=(double)sum/TotalCount;
						intent.putExtra("avgMarks",""+dd);
						intent.putExtra("Pass",""+passCount);
						startActivity(intent);
						dialog.dismiss();
					}
				});

		myAlertDialog.setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		myAlertDialog.show();
	}
	private void upDateMarks() {
		try {
			String imi=getIMEINo();
			for (int i = 0; i < snArray.size(); i++) {
					ContentValues _contentValues = new ContentValues();
					_contentValues.put("barcode", snArray.get(i));
					_contentValues.put("user_id", userId);
					_contentValues.put("subject_code", sub_code);
					_contentValues.put("bundle_no", bundleNo);
					int jj=i+1;
					_contentValues.put("bundle_serial_no", jj);
					_contentValues.put("barcode_status", 1);
					_contentValues.put("tablet_IMEI", imi);
					_contentValues.put("is_updated_server", "0");
					String	startTime=getPresentTime();
					_contentValues.put("enter_on", startTime);
					_contentValues.put("updated_on", startTime);
				_contentValues.put("question_setcode", ""+rmArray.get(i));
					_contentValues.put("total_mark", tmArray.get(i));

					database.insertReords("table_marks", _contentValues);
					_contentValues.remove("updated_on");
					database.insertReords("table_marks_history",
							_contentValues);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	private void updateDBCompleted(){
		try{
		String query5 ="update table_user set active_status=10 where TRIM(UPPER(login)) =TRIM(UPPER('"+
				userId + "'))";
		Log.v("query submit", query5);
		database.executeSQLQuery(query5).close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	String getIMEINo() {
		String imei = "";
		String a[] = { "tablet_IMEI" };
		Cursor _cursor = database.getRow("table_bundle",
				"bundle_no" + "='" + bundleNo + "'", a);
		if (_cursor != null) {
			if (_cursor.getCount() > 0) {
				imei = _cursor.getString(_cursor
						.getColumnIndex("tablet_IMEI"));
			}
		}
		_cursor.close();
		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String IMEIa = telephonyManager.getDeviceId();
		if (TextUtils.isEmpty(imei)) {
			imei = IMEIa;
		}
		return imei;
	}

	private String getPresentTime() {
		// set the format here
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	public void updateBundleStatusByBundleNo(String pBundleNo, int status) {

		String updateSql = "UPDATE table_bundle SET status="
				+ status
				+ ",updated_on=(datetime('now','localtime')),is_updated_server=0 WHERE bundle_no='"
				+ pBundleNo + "'";
		Cursor cursorRecordsForUpdation = null;
		try {
			cursorRecordsForUpdation = database.executeSQLQuery(updateSql);
			if (status == 1 || status == 2) {
				String insertSqlForBundleHistory = "insert into table_bundle_history"
						+ " (is_deleted,is_unreadable,program_name,bundle_no,subject_id,subject_code,status,enter_by,"
						+ "enter_on,is_updated_server,tablet_IMEI,apk_version) select 0,is_unreadable,program_name,"
						+ "bundle_no,subject_id,subject_code,status,enter_by,enter_on,is_updated_server,"
						+ "tablet_IMEI,apk_version from table_bundle WHERE bundle_no='"
						+ pBundleNo + "'";

				Cursor cursorRecordsForHistoryUpdation = null;
				try {
					cursorRecordsForHistoryUpdation = database
							.executeSQLQuery(insertSqlForBundleHistory);

				} catch (Exception ex) {

				} finally {
					if(cursorRecordsForHistoryUpdation!=null)
					cursorRecordsForHistoryUpdation.close();
				}
			}
		} catch (Exception ex) {

		} finally {
			if(cursorRecordsForUpdation!=null)
			cursorRecordsForUpdation.close();
		}

	}

}
