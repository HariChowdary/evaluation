package com.infoplustech.smartscrutinization.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.infoplustech.smartscrutinization.utils.SSConstants;

public class SScrutinyDatabase extends SQLiteOpenHelper {

	static Context mContext;


	private static SScrutinyDatabase scrutinyDatabase;
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Sscrutinization";

	public SScrutinyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	public static SScrutinyDatabase getInstance(Context context) {
		mContext = context;
		return scrutinyDatabase == null ? new SScrutinyDatabase(context)
				: scrutinyDatabase;

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	public Cursor executeSQLQuery(String sqlQuery, String[] selectionArgs) {
		Cursor _cursor = null;
		try {
			SQLiteDatabase _database = SQLiteDatabase.openDatabase(
					SSConstants.SSCRUTINY_DB_PATH, null,
					SQLiteDatabase.OPEN_READWRITE);
			_cursor = _database.rawQuery(sqlQuery, selectionArgs);
			_cursor.moveToFirst();
			_database.close();
		} catch (SQLiteException sqle) {

		}

		return _cursor;
	}



	@Override
	public void onCreate(SQLiteDatabase arg0) {
	}


}
