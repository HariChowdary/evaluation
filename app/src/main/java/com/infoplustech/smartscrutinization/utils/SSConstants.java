package com.infoplustech.smartscrutinization.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;

public class SSConstants {

	// ============================================
	// variables used for onetime service
	public static final String SCRUTINY = "scrutiny";
	public static final String SCRUTINY_CORRECTION = "scrutiny_correction";
	public static final String MODE = "mode";
	public static final String POSTED_MARKS_TO_SERVER = "marks_posted";
	public static final String NOTIFICATION = "com.infoplustech.smartscrutinization.ShowGrandTotalSummaryTable.receiver";
	public static final String MODE_NETWORK_FAILS = "network_fails";
	// =====================================================
	public static final String APK_VERSION = " 1";
	public static final int TABLET_CHARGE = 2;
	public static final int SUCCESS = 100;
	public static final int TimeLimit = 30000;//30000
	public static final int FAILURE = 101;
	public static final int SUCCESS1 = 111;
	public static final int FAILURE1 = 222;
	public static String DB_VERSION = "db_version";
	public static final String BUNDLE_TIMER = "timer";
	public static final String NOTE_DATE = "noteDate";
	public static final String REGULATION = "regulation";

	public static final String TOTAL_SCRIPTS = "total_scripts";
	public static final String SCRUTINY_TOTAL_MARKS_FOR_SCRIPT = "total_marks_entered_in_scrutiny_for_each_script";

	public static final String FROM_CLASS_SHOW_GRAND_TOTAL_SUMMARY_TABLE = "ShowGrandTotalSummaryTable";
	public static final String FROM_CLASS_MISS_MATCH_SCRIPT_WITH_DB = "MissMatchScriptWithDB";

	public static final String TABLE_DATE_CONFIGURATION = "table_date_configuration";
	public static final String TABLET_IMEI = "tablet_IMEI";
	public static final String DUPLICATES_CURSOR = "duplicates";
	public static final String CURRENT_ANSWER_BOOK = "CurrentAnswerBook";
	public static final String SCRUTINIZE_STATUS = "scrutinize_status";
	public static final String SCRUTINIZED_ON = "scrutinized_on";
	public static final String CORRECTED_ON = "corrected_on";
	public static final String IS_CORRECTED = "is_corrected";
	public static final String IS_SCRUTINIZED = "is_scrutinized";
	public static final String IS_UPDATED_SERVER = "is_updated_server";
	public static final int IS_UPDATED_SERVER_STATUS = 1;
	public static final String ADD_SCRIPT_CASE = "add_script";
	public static final String SCRUTINIZED_BY = "scrutinized_by";
	public static final String BARCODE_STATUS = "barcode_status";
	public static final String MAX_MARK = "max_total";

	public static final String NAVIGATION_FROM_SHOW_GRAND_TOTAL_ACTIVITY = "nav_from_show_grand_total_activity";

	public static final String REMARK_COUNT = "remark_count";
	public static final String ORANGE_COLOR = "1";
	public static final String GREEN_COLOR = "2";
	public static final String RED_COLOR = "3";

	public static final int SCRUTINY_STATUS_1_NOT_EVALUATED = 1;
	public static final int SCRUTINY_STATUS_2_BARCODE_AND_SLNO_MISMATCH = 2;
	public static final int SCRUTINY_STATUS_3_CORRECTION_REQUIRED = 3;
	public static final int SCRUTINY_STATUS_4_NO_CORRECTION = 4;
	public static final int SCRUTINY_STATUS_5_NEXT_OBSERVATION = 5;
	public static final int SCRUTINY_STATUS_6_SCRIPT_COMPLETED = 6;
	public static final int SCRUTINY_STATUS_7_SCRIPT_MISMATCH_WITH_DB = 7;

	public static String SHARED_PREF_MAX_TOTAL = "shared_pref_max_total";
	public static final String SD_CARD_FOLDER_NAME = "SmartEvaluation";
	public final static File DATABASE_FILE_PATH_TO_SSCRUTINY = new File(
			Environment.getExternalStoragePublicDirectory(SD_CARD_FOLDER_NAME),
			"SScrutinization.db");
	public static String SSCRUTINY_DB_PATH = DATABASE_FILE_PATH_TO_SSCRUTINY
			.getPath().toString();
	public static String TABLE_SCRUTINY_SAVE = "table_marks_scrutinize";
	public static String TABLE_EVALUATION_SAVE = "table_marks_scrutinize_entry";
	public static String TABLE_SCRUTINY_REQUEST = "table_marks";
	public static String TABLE_USER = "table_user";

	public static final String COL_ID = "col_id";
	
	public static final String MODE_SCRUTINY = "mode_scrutiny";
	public static final String MODE_CORRECTION = "mode_correction";
	public static final String MODE_ERROR = "error";
	// database table table_marks columns

	public static final String USER_ID = "user_id";
	public static final String ANS_BOOK_BARCODE = "barcode";
	public static final String BUNDLE_NO = "bundle_no";
	public static final String SUBJECT_CODE = "subject_code";
	public static final String BUNDLE_SERIAL_NO = "bundle_serial_no";
	public static final String ENTER_ON = "enter_on";

	public static final String MARK1A = "mark1a";
	public static final String MARK1B = "mark1b";
	public static final String MARK1C = "mark1c";
	public static final String MARK1D = "mark1d";
	public static final String MARK1E = "mark1e";

	public static final String MARK1F = "mark1f";
	public static final String MARK1G = "mark1g";
	public static final String MARK1H = "mark1h";
	public static final String MARK1I = "mark1i";
	public static final String MARK1J = "mark1j";

	public static final String MARK2A = "mark2a";
	public static final String MARK2B = "mark2b";
	public static final String MARK2C = "mark2c";
	public static final String MARK2D = "mark2d";
	public static final String MARK2E = "mark2e";

	public static final String MARK3A = "mark3a";
	public static final String MARK3B = "mark3b";
	public static final String MARK3C = "mark3c";
	public static final String MARK3D = "mark3d";
	public static final String MARK3E = "mark3e";

	public static final String MARK4A = "mark4a";
	public static final String MARK4B = "mark4b";
	public static final String MARK4C = "mark4c";
	public static final String MARK4D = "mark4d";
	public static final String MARK4E = "mark4e";

	public static final String MARK5A = "mark5a";
	public static final String MARK5B = "mark5b";
	public static final String MARK5C = "mark5c";
	public static final String MARK5D = "mark5d";
	public static final String MARK5E = "mark5e";

	public static final String MARK6A = "mark6a";
	public static final String MARK6B = "mark6b";
	public static final String MARK6C = "mark6c";
	public static final String MARK6D = "mark6d";
	public static final String MARK6E = "mark6e";

	public static final String MARK7A = "mark7a";
	public static final String MARK7B = "mark7b";
	public static final String MARK7C = "mark7c";
	public static final String MARK7D = "mark7d";
	public static final String MARK7E = "mark7e";

	public static final String MARK8A = "mark8a";
	public static final String MARK8B = "mark8b";
	public static final String MARK8C = "mark8c";
	public static final String MARK8D = "mark8d";
	public static final String MARK8E = "mark8e";

	public static final String MARK9A = "mark9a";
	public static final String MARK9B = "mark9b";
	public static final String MARK9C = "mark9c";

	public static final String MARK10A = "mark10a";
	public static final String MARK10B = "mark10b";
	public static final String MARK10C = "mark10c";

	public static final String MARK11A = "mark11a";
	public static final String MARK11B = "mark11b";
	public static final String MARK11C = "mark11c";

	public static final String R1_TOTAL = "r1_total";
	public static final String R2_TOTAL = "r2_total";
	public static final String R3_TOTAL = "r3_total";
	public static final String R4_TOTAL = "r4_total";
	public static final String R5_TOTAL = "r5_total";
	public static final String R6_TOTAL = "r6_total";
	public static final String R7_TOTAL = "r7_total";
	public static final String R8_TOTAL = "r8_total";

	// R13-B.tech
	public static final String R2_3TOTAL = "r2_total";
	public static final String R4_5TOTAL = "r4_total";
	public static final String R6_7TOTAL = "r6_total";
	public static final String R8_9TOTAL = "r8_total";
	public static final String R10_11TOTAL = "r10_total";
	
	//R13-B.tech-Special case
		public static final String R1_2TOTAL = "r1_total";
		public static final String R3_4TOTAL = "r3_total";
		public static final String R5_6TOTAL = "r5_total";
		public static final String R7_8TOTAL = "r7_total";
		public static final String R9_10TOTAL = "r9_total";

	public static final String M1A_REMARK = "remark_1a";
	public static final String M1B_REMARK = "remark_1b";
	public static final String M1C_REMARK = "remark_1c";
	public static final String M1D_REMARK = "remark_1d";
	public static final String M1E_REMARK = "remark_1e";

	public static final String M1F_REMARK = "remark_1f";
	public static final String M1G_REMARK = "remark_1g";
	public static final String M1H_REMARK = "remark_1h";
	public static final String M1I_REMARK = "remark_1i";
	public static final String M1J_REMARK = "remark_1j";

	public static final String M2A_REMARK = "remark_2a";
	public static final String M2B_REMARK = "remark_2b";
	public static final String M2C_REMARK = "remark_2c";
	public static final String M2D_REMARK = "remark_2d";
	public static final String M2E_REMARK = "remark_2e";

	public static final String M3A_REMARK = "remark_3a";
	public static final String M3B_REMARK = "remark_3b";
	public static final String M3C_REMARK = "remark_3c";
	public static final String M3D_REMARK = "remark_3d";
	public static final String M3E_REMARK = "remark_3e";

	public static final String M4A_REMARK = "remark_4a";
	public static final String M4B_REMARK = "remark_4b";
	public static final String M4C_REMARK = "remark_4c";
	public static final String M4D_REMARK = "remark_4d";
	public static final String M4E_REMARK = "remark_4e";

	public static final String M5A_REMARK = "remark_5a";
	public static final String M5B_REMARK = "remark_5b";
	public static final String M5C_REMARK = "remark_5c";
	public static final String M5D_REMARK = "remark_5d";
	public static final String M5E_REMARK = "remark_5e";

	public static final String M6A_REMARK = "remark_6a";
	public static final String M6B_REMARK = "remark_6b";
	public static final String M6C_REMARK = "remark_6c";
	public static final String M6D_REMARK = "remark_6d";
	public static final String M6E_REMARK = "remark_6e";

	public static final String M7A_REMARK = "remark_7a";
	public static final String M7B_REMARK = "remark_7b";
	public static final String M7C_REMARK = "remark_7c";
	public static final String M7D_REMARK = "remark_7d";
	public static final String M7E_REMARK = "remark_7e";

	public static final String M8A_REMARK = "remark_8a";
	public static final String M8B_REMARK = "remark_8b";
	public static final String M8C_REMARK = "remark_8c";
	public static final String M8D_REMARK = "remark_8d";
	public static final String M8E_REMARK = "remark_8e";

	public static final String M9A_REMARK = "remark_9a";
	public static final String M9B_REMARK = "remark_9b";
	public static final String M9C_REMARK = "remark_9c";

	public static final String M10A_REMARK = "remark_10a";
	public static final String M10B_REMARK = "remark_10b";
	public static final String M10C_REMARK = "remark_10c";

	public static final String M11A_REMARK = "remark_11a";
	public static final String M11B_REMARK = "remark_11b";
	public static final String M11C_REMARK = "remark_11c";

	public static final String R1_REMARK = "remark_r1_total";
	public static final String R2_REMARK = "remark_r2_total";
	public static final String R3_REMARK = "remark_r3_total";
	public static final String R4_REMARK = "remark_r4_total";
	public static final String R5_REMARK = "remark_r5_total";
	public static final String R6_REMARK = "remark_r6_total";
	public static final String R7_REMARK = "remark_r7_total";
	public static final String R8_REMARK = "remark_r8_total";
	public static final String R9_REMARK = "remark_r9_total";
	public static final String R10_REMARK = "remark_r10_total";
	public static final String R11_REMARK = "remark_r11_total";

	public static final String GRAND_TOTAL_REMARK = "remark_grand_total";
	public static final String GRAND_TOTAL_MARK = "total_mark";
	public static final String SCRUTINY_SELECTED = "scrutiny_selected";


}
