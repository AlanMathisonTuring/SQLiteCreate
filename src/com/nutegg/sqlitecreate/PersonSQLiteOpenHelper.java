package com.nutegg.sqlitecreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {
	
	public PersonSQLiteOpenHelper(Context context) {
		//���һ������Ϊ�汾��,����汾�Ÿı佫��ִ�������onUpgrade
		super(context, "person.db", null, 2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table person (id integer primary key autoincrement,name varchar(20),number varchar(20))");
	}
	//����汾�Ÿı��ִ�и÷���,�÷�����Ҫ�������������ݿ�ı�ṹ
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("alter table person add account varchar(20)");
	}

}
