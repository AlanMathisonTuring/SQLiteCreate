package com.nutegg.sqlitecreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {
	
	public PersonSQLiteOpenHelper(Context context) {
		//最后一个参数为版本号,如果版本号改变将会执行下面的onUpgrade
		super(context, "person.db", null, 2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table person (id integer primary key autoincrement,name varchar(20),number varchar(20))");
	}
	//如果版本号改变会执行该方法,该方法主要是用来更新数据库的表结构
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("alter table person add account varchar(20)");
	}

}
