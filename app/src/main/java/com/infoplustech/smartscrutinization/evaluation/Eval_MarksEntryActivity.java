
package com.infoplustech.smartscrutinization.evaluation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.infoplustech.smartscrutinization.R;
import com.infoplustech.smartscrutinization.db.SScrutinyDatabase;
import com.infoplustech.smartscrutinization.utils.SSConstants;

import java.util.ArrayList;

public class Eval_MarksEntryActivity extends Activity {

	String userId, bundleNo, sub_code;
	SScrutinyDatabase database;
int TotalCount=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrutiny_marks_summary_activity);
		database = SScrutinyDatabase.getInstance(this);
		getActionBar().setIcon(R.drawable.ic_launchere);
		getActionBar().setTitle(" Evaluator");
		bundleNo= getIntent().getStringExtra("bundleNo");
		userId= getIntent().getStringExtra("userId");
		TotalCount= getIntent().getIntExtra("totalCount", 0);
		sub_code= getIntent().getStringExtra("subject_code");
		
		((TextView) findViewById(R.id.evaluatorid)).setText(userId);
		((TextView) findViewById(R.id.bundle_id)).setText(bundleNo);
		((TextView) findViewById(R.id.sub_id)).setText(sub_code);


		//uiChnage();
		
		findViewById(R.id.btn_ok).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				submit1();
			}
		});
		((Button)findViewById(R.id.back)).setText("Change Script Count");
		findViewById(R.id.back).setVisibility(View.VISIBLE);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setTotalScriptCount(false);
			}
		});
		setTotalScriptCount(true);
	}

	private void alertMessageForCharge() {
		AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
				new ContextThemeWrapper(this, R.style.alert_text_style));
		myAlertDialog.setTitle("Alert");
		myAlertDialog.setMessage("Do you want to submit?");

		myAlertDialog.setPositiveButton("YES",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface Dialog, int arg1) {
						Intent intent=new Intent(Eval_MarksEntryActivity.this, Eval_MarksSummryActivity.class);
						intent.putExtra("bundleNo", bundleNo);
						intent.putExtra("userId", userId);
						intent.putExtra("totalCount",TotalCount);
						intent.putExtra("sub_id",sub_code);
						intent.putStringArrayListExtra("sn",snArray);
						intent.putStringArrayListExtra("tm",tmArray);
						intent.putStringArrayListExtra("rm",rmArray);
						startActivity(intent);
						Dialog.dismiss();
					}
				});
		myAlertDialog.setNegativeButton("NO",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface Dialog, int arg1) {
						Dialog.dismiss();
					}
				});
		myAlertDialog.show();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
	private void setVisibilView(int no){

		switch (no){
			case 1: ((TableRow) findViewById(R.id.tr_1)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_1)).setEnabled(true); break;
			case 2: ((TableRow) findViewById(R.id.tr_2)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_2)).setEnabled(true); break;
			case 3: ((TableRow) findViewById(R.id.tr_3)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_3)).setEnabled(true); break;
			case 4: ((TableRow) findViewById(R.id.tr_4)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_4)).setEnabled(true); break;
			case 5: ((TableRow) findViewById(R.id.tr_5)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_5)).setEnabled(true); break;
			case 6: ((TableRow) findViewById(R.id.tr_6)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_6)).setEnabled(true); break;
			case 7: ((TableRow) findViewById(R.id.tr_7)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_7)).setEnabled(true); break;
			case 8: ((TableRow) findViewById(R.id.tr_8)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_8)).setEnabled(true); break;
			case 9: ((TableRow) findViewById(R.id.tr_9)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_9)).setEnabled(true); break;
			case 10: ((TableRow) findViewById(R.id.tr_10)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_10)).setEnabled(true); break;
			case 11: ((TableRow) findViewById(R.id.tr_11)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_11)).setEnabled(true); break;
			case 12: ((TableRow) findViewById(R.id.tr_12)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_12)).setEnabled(true); break;
			case 13: ((TableRow) findViewById(R.id.tr_13)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_13)).setEnabled(true); break;
			case 14: ((TableRow) findViewById(R.id.tr_14)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_14)).setEnabled(true); break;
			case 15: ((TableRow) findViewById(R.id.tr_15)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_15)).setEnabled(true); break;
			case 16: ((TableRow) findViewById(R.id.tr_16)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_16)).setEnabled(true); break;
			case 17: ((TableRow) findViewById(R.id.tr_17)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_17)).setEnabled(true); break;
			case 18: ((TableRow) findViewById(R.id.tr_18)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_18)).setEnabled(true); break;
			case 19: ((TableRow) findViewById(R.id.tr_19)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_19)).setEnabled(true); break;
			case 20: ((TableRow) findViewById(R.id.tr_20)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_20)).setEnabled(true); break;
			case 21: ((TableRow) findViewById(R.id.tr_21)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_21)).setEnabled(true); break;
			case 22: ((TableRow) findViewById(R.id.tr_22)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_22)).setEnabled(true); break;
			case 23: ((TableRow) findViewById(R.id.tr_23)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_23)).setEnabled(true); break;
			case 24: ((TableRow) findViewById(R.id.tr_24)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_24)).setEnabled(true); break;
			case 25: ((TableRow) findViewById(R.id.tr_25)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_25)).setEnabled(true); break;
			case 26: ((TableRow) findViewById(R.id.tr_26)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_26)).setEnabled(true); break;
			case 27: ((TableRow) findViewById(R.id.tr_27)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_27)).setEnabled(true); break;
			case 28: ((TableRow) findViewById(R.id.tr_28)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_28)).setEnabled(true); break;
			case 29: ((TableRow) findViewById(R.id.tr_29)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_29)).setEnabled(true); break;
			case 30: ((TableRow) findViewById(R.id.tr_30)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_30)).setEnabled(true); break;
			case 31: ((TableRow) findViewById(R.id.tr_31)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_31)).setEnabled(true); break;
			case 32: ((TableRow) findViewById(R.id.tr_32)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_32)).setEnabled(true); break;
			case 33: ((TableRow) findViewById(R.id.tr_33)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_33)).setEnabled(true); break;
			case 34: ((TableRow) findViewById(R.id.tr_34)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_34)).setEnabled(true); break;
			case 35: ((TableRow) findViewById(R.id.tr_35)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_35)).setEnabled(true); break;
			case 36: ((TableRow) findViewById(R.id.tr_36)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_36)).setEnabled(true); break;
			case 37: ((TableRow) findViewById(R.id.tr_37)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_37)).setEnabled(true); break;
			case 38: ((TableRow) findViewById(R.id.tr_38)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_38)).setEnabled(true); break;
			case 39: ((TableRow) findViewById(R.id.tr_39)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_39)).setEnabled(true); break;
			case 40: ((TableRow) findViewById(R.id.tr_40)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_40)).setEnabled(true); break;
			case 41: ((TableRow) findViewById(R.id.tr_41)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_41)).setEnabled(true); break;
			case 42: ((TableRow) findViewById(R.id.tr_42)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_42)).setEnabled(true); break;
			case 43: ((TableRow) findViewById(R.id.tr_43)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_43)).setEnabled(true); break;
			case 44: ((TableRow) findViewById(R.id.tr_44)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_44)).setEnabled(true); break;
			case 45: ((TableRow) findViewById(R.id.tr_45)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_45)).setEnabled(true); break;
			case 46: ((TableRow) findViewById(R.id.tr_46)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_46)).setEnabled(true); break;
			case 47: ((TableRow) findViewById(R.id.tr_47)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_47)).setEnabled(true); break;
			case 48: ((TableRow) findViewById(R.id.tr_48)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_48)).setEnabled(true); break;
			case 49: ((TableRow) findViewById(R.id.tr_49)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_49)).setEnabled(true); break;
			case 50: ((TableRow) findViewById(R.id.tr_50)).setVisibility(View.VISIBLE); ((EditText) findViewById(R.id.sn_50)).setEnabled(true); break;
		}
	}
    private ArrayList<String> snArray=new ArrayList<String>();
	private ArrayList<String> tmArray=new ArrayList<String>();
	private ArrayList<String> rmArray=new ArrayList<String>();

	private boolean validMarks(int id, int sn_id, int tm_id, int remarks_id) {
		if (id <= TotalCount) {
			String sn = "" + ((EditText) findViewById(sn_id)).getText().toString().trim();
			String tm = "" + ((EditText) findViewById(tm_id)).getText().toString().trim();
			String rm = "" + ((EditText) findViewById(remarks_id)).getText().toString().trim();
			if (!sn.isEmpty()) {
				if (sn.length()>=4) {
					if (!snArray.contains(sn)) {
						String ss=sn.replace("0","");
						if(ss.isEmpty()) {
							((EditText) findViewById(sn_id)).setText("");
							((EditText) findViewById(sn_id)).requestFocus();
							Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Valid Script Number", Toast.LENGTH_SHORT).show();
							return false;
						}
				} else {
					((EditText) findViewById(sn_id)).setText("");
					((EditText) findViewById(sn_id)).requestFocus();
					Toast.makeText(Eval_MarksEntryActivity.this, "Duplicate Script Number not allowed", Toast.LENGTH_SHORT).show();
					return false;
				}
			} else {
				((EditText) findViewById(sn_id)).setText("");
				((EditText) findViewById(sn_id)).requestFocus();
				Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Valid Script Number", Toast.LENGTH_SHORT).show();
				return false;
			}
			} else {
				((EditText) findViewById(sn_id)).setText("");
				((EditText) findViewById(sn_id)).requestFocus();
				Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Script Number", Toast.LENGTH_SHORT).show();
				return false;
			}

			if (!tm.isEmpty()) {
				if (!tm.equals("00") && !tm.equals("000")) {
					try {
						int marks = Integer.parseInt(tm);
						if (marks >= 0 && marks <= 80) {
							snArray.add(sn);
							tmArray.add(tm);
							rmArray.add(rm);
							return true;
						}
						else {
							((EditText) findViewById(tm_id)).setText("");
							((EditText) findViewById(tm_id)).requestFocus();
							Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Valid Marks", Toast.LENGTH_SHORT).show();
							return false;
						}
					} catch (Exception e) {
						((EditText) findViewById(tm_id)).setText("");
						((EditText) findViewById(tm_id)).requestFocus();
						Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Valid Marks", Toast.LENGTH_SHORT).show();
						return false;
					}
				} else {
					((EditText) findViewById(tm_id)).setText("");
					((EditText) findViewById(tm_id)).requestFocus();
					Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Valid Marks", Toast.LENGTH_SHORT).show();
					return false;
				}
			} else {
				((EditText) findViewById(tm_id)).setText("");
				((EditText) findViewById(tm_id)).requestFocus();
				Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Marks", Toast.LENGTH_SHORT).show();
				return false;
			}
		} else {
			return true;
		}
	}
	// call this method when clicked on submit button

	private void submit1() {
		snArray.clear();
		tmArray.clear();
		rmArray.clear();
		if(validMarks(1,R.id.sn_1, R.id.tm_1,R.id.rm_1)
				&&validMarks(2,R.id.sn_2, R.id.tm_2,R.id.rm_2)
				&&validMarks(3,R.id.sn_3, R.id.tm_3,R.id.rm_3)
				&&validMarks(4,R.id.sn_4, R.id.tm_4,R.id.rm_4)
				&&validMarks(5,R.id.sn_5, R.id.tm_5,R.id.rm_5)
				&&validMarks(6,R.id.sn_6, R.id.tm_6,R.id.rm_6)
				&&validMarks(7,R.id.sn_7, R.id.tm_7,R.id.rm_7)
				&&validMarks(8,R.id.sn_8, R.id.tm_8,R.id.rm_8)
				&&validMarks(9,R.id.sn_9, R.id.tm_9,R.id.rm_9)
				&&validMarks(10,R.id.sn_10, R.id.tm_10,R.id.rm_10)
				&&validMarks(11,R.id.sn_11, R.id.tm_11,R.id.rm_11)
				&&validMarks(12,R.id.sn_12, R.id.tm_12,R.id.rm_12)
				&&validMarks(13,R.id.sn_13, R.id.tm_13,R.id.rm_13)
				&&validMarks(14,R.id.sn_14, R.id.tm_14,R.id.rm_14)
				&&validMarks(15,R.id.sn_15, R.id.tm_15,R.id.rm_15)
				&&validMarks(16,R.id.sn_16, R.id.tm_16,R.id.rm_16)
				&&validMarks(17,R.id.sn_17, R.id.tm_17,R.id.rm_17)
				&&validMarks(18,R.id.sn_18, R.id.tm_18,R.id.rm_18)
				&&validMarks(19,R.id.sn_19, R.id.tm_19,R.id.rm_19)
				&&validMarks(20,R.id.sn_20, R.id.tm_20,R.id.rm_20)
				&&validMarks(21,R.id.sn_21, R.id.tm_21,R.id.rm_21)
				&&validMarks(22,R.id.sn_22, R.id.tm_22,R.id.rm_22)
				&&validMarks(23,R.id.sn_23, R.id.tm_23,R.id.rm_23)
				&&validMarks(24,R.id.sn_24, R.id.tm_24,R.id.rm_24)
				&&validMarks(25,R.id.sn_25, R.id.tm_25,R.id.rm_25)
				&&validMarks(26,R.id.sn_26, R.id.tm_26,R.id.rm_26)
				&&validMarks(27,R.id.sn_27, R.id.tm_27,R.id.rm_27)
				&&validMarks(28,R.id.sn_28, R.id.tm_28,R.id.rm_28)
				&&validMarks(29,R.id.sn_29, R.id.tm_29,R.id.rm_29)
				&&validMarks(30,R.id.sn_30, R.id.tm_30,R.id.rm_30)
				&&validMarks(31,R.id.sn_31, R.id.tm_31,R.id.rm_31)
				&&validMarks(32,R.id.sn_32, R.id.tm_32,R.id.rm_32)
				&&validMarks(33,R.id.sn_33, R.id.tm_33,R.id.rm_33)
				&&validMarks(34,R.id.sn_34, R.id.tm_34,R.id.rm_34)
				&&validMarks(35,R.id.sn_35, R.id.tm_35,R.id.rm_35)
				&&validMarks(36,R.id.sn_36, R.id.tm_36,R.id.rm_36)
				&&validMarks(37,R.id.sn_37, R.id.tm_37,R.id.rm_37)
				&&validMarks(38,R.id.sn_38, R.id.tm_38,R.id.rm_38)
				&&validMarks(39,R.id.sn_39, R.id.tm_39,R.id.rm_39)
				&&validMarks(40,R.id.sn_40, R.id.tm_40,R.id.rm_40)
				&&validMarks(41,R.id.sn_41, R.id.tm_41,R.id.rm_41)
				&&validMarks(42,R.id.sn_42, R.id.tm_42,R.id.rm_42)
				&&validMarks(43,R.id.sn_43, R.id.tm_43,R.id.rm_43)
				&&validMarks(44,R.id.sn_44, R.id.tm_44,R.id.rm_44)
				&&validMarks(45,R.id.sn_45, R.id.tm_45,R.id.rm_45)
				&&validMarks(46,R.id.sn_46, R.id.tm_46,R.id.rm_46)
				&&validMarks(47,R.id.sn_47, R.id.tm_47,R.id.rm_47)
				&&validMarks(48,R.id.sn_48, R.id.tm_48,R.id.rm_48)
				&&validMarks(49,R.id.sn_49, R.id.tm_49,R.id.rm_49)
				&&validMarks(50,R.id.sn_50, R.id.tm_50,R.id.rm_50)){
			alertMessageForCharge();
		}
	}
	// method for calling webservices

	private void setTotalScriptCount(Boolean first){
		final Dialog dialog = new Dialog(Eval_MarksEntryActivity.this);
		dialog.setContentView(R.layout.coustom_dialog);
		dialog.setTitle("Enter Script Count");

		final EditText text = (EditText) dialog.findViewById(R.id.count_s);
		Button image = (Button) dialog.findViewById(R.id.bt_submit);

		image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String count=text.getText().toString().trim();
				if(!count.isEmpty()) {
					try {
						int c = Integer.parseInt(count);
						if (c > 0 && c <= 50) {
							TotalCount=c;
							uiChnage();
							dialog.dismiss();
						}else{
							text.setText("");
							Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter valid Script Count", Toast.LENGTH_SHORT).show();
						}
					} catch (Exception e) {
						e.printStackTrace();
						text.setText("");
						Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter valid Script Count", Toast.LENGTH_SHORT).show();
					}
				}else {
					text.setText("");
					Toast.makeText(Eval_MarksEntryActivity.this, "Please Enter Script Count", Toast.LENGTH_SHORT).show();
				}
				
				
			}
		});
		Button image1 = (Button) dialog.findViewById(R.id.bt_cancel);
		if(first)
			image1.setVisibility(View.GONE);
		image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}
	private void uiChnage(){
		for (int TotalCount1=TotalCount-1;TotalCount1<=50;TotalCount1++) {
			setInvisibilView(TotalCount1);
		}
		for (int count=1;count<=TotalCount;count++) {
			setVisibilView(count);
		}
	}

	private void setInvisibilView(int no){

		switch (no){
			case 1: ((TableRow) findViewById(R.id.tr_1)).setVisibility(View.GONE);  break;
			case 2: ((TableRow) findViewById(R.id.tr_2)).setVisibility(View.GONE);  break;
			case 3: ((TableRow) findViewById(R.id.tr_3)).setVisibility(View.GONE);  break;
			case 4: ((TableRow) findViewById(R.id.tr_4)).setVisibility(View.GONE);  break;
			case 5: ((TableRow) findViewById(R.id.tr_5)).setVisibility(View.GONE);  break;
			case 6: ((TableRow) findViewById(R.id.tr_6)).setVisibility(View.GONE);  break;
			case 7: ((TableRow) findViewById(R.id.tr_7)).setVisibility(View.GONE);  break;
			case 8: ((TableRow) findViewById(R.id.tr_8)).setVisibility(View.GONE);  break;
			case 9: ((TableRow) findViewById(R.id.tr_9)).setVisibility(View.GONE);  break;
			case 10: ((TableRow) findViewById(R.id.tr_10)).setVisibility(View.GONE);break;
			case 11: ((TableRow) findViewById(R.id.tr_11)).setVisibility(View.GONE);break;
			case 12: ((TableRow) findViewById(R.id.tr_12)).setVisibility(View.GONE);break;
			case 13: ((TableRow) findViewById(R.id.tr_13)).setVisibility(View.GONE);break;
			case 14: ((TableRow) findViewById(R.id.tr_14)).setVisibility(View.GONE);break;
			case 15: ((TableRow) findViewById(R.id.tr_15)).setVisibility(View.GONE);break;
			case 16: ((TableRow) findViewById(R.id.tr_16)).setVisibility(View.GONE);break;
			case 17: ((TableRow) findViewById(R.id.tr_17)).setVisibility(View.GONE);break;
			case 18: ((TableRow) findViewById(R.id.tr_18)).setVisibility(View.GONE);break;
			case 19: ((TableRow) findViewById(R.id.tr_19)).setVisibility(View.GONE);break;
			case 20: ((TableRow) findViewById(R.id.tr_20)).setVisibility(View.GONE);break;
			case 21: ((TableRow) findViewById(R.id.tr_21)).setVisibility(View.GONE);break;
			case 22: ((TableRow) findViewById(R.id.tr_22)).setVisibility(View.GONE);break;
			case 23: ((TableRow) findViewById(R.id.tr_23)).setVisibility(View.GONE);break;
			case 24: ((TableRow) findViewById(R.id.tr_24)).setVisibility(View.GONE);break;
			case 25: ((TableRow) findViewById(R.id.tr_25)).setVisibility(View.GONE);break;
			case 26: ((TableRow) findViewById(R.id.tr_26)).setVisibility(View.GONE);break;
			case 27: ((TableRow) findViewById(R.id.tr_27)).setVisibility(View.GONE);break;
			case 28: ((TableRow) findViewById(R.id.tr_28)).setVisibility(View.GONE);break;
			case 29: ((TableRow) findViewById(R.id.tr_29)).setVisibility(View.GONE);break;
			case 30: ((TableRow) findViewById(R.id.tr_30)).setVisibility(View.GONE);break;
			case 31: ((TableRow) findViewById(R.id.tr_31)).setVisibility(View.GONE);break;
			case 32: ((TableRow) findViewById(R.id.tr_32)).setVisibility(View.GONE);break;
			case 33: ((TableRow) findViewById(R.id.tr_33)).setVisibility(View.GONE);break;
			case 34: ((TableRow) findViewById(R.id.tr_34)).setVisibility(View.GONE);break;
			case 35: ((TableRow) findViewById(R.id.tr_35)).setVisibility(View.GONE);break;
			case 36: ((TableRow) findViewById(R.id.tr_36)).setVisibility(View.GONE);break;
			case 37: ((TableRow) findViewById(R.id.tr_37)).setVisibility(View.GONE);break;
			case 38: ((TableRow) findViewById(R.id.tr_38)).setVisibility(View.GONE);break;
			case 39: ((TableRow) findViewById(R.id.tr_39)).setVisibility(View.GONE);break;
			case 40: ((TableRow) findViewById(R.id.tr_40)).setVisibility(View.GONE);break;
			case 41: ((TableRow) findViewById(R.id.tr_41)).setVisibility(View.GONE);break;
			case 42: ((TableRow) findViewById(R.id.tr_42)).setVisibility(View.GONE);break;
			case 43: ((TableRow) findViewById(R.id.tr_43)).setVisibility(View.GONE);break;
			case 44: ((TableRow) findViewById(R.id.tr_44)).setVisibility(View.GONE);break;
			case 45: ((TableRow) findViewById(R.id.tr_45)).setVisibility(View.GONE);break;
			case 46: ((TableRow) findViewById(R.id.tr_46)).setVisibility(View.GONE);break;
			case 47: ((TableRow) findViewById(R.id.tr_47)).setVisibility(View.GONE);break;
			case 48: ((TableRow) findViewById(R.id.tr_48)).setVisibility(View.GONE);break;
			case 49: ((TableRow) findViewById(R.id.tr_49)).setVisibility(View.GONE);break;
			case 50: ((TableRow) findViewById(R.id.tr_50)).setVisibility(View.GONE);break;
		}
	}
}
