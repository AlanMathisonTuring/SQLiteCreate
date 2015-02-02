package com.nutegg.sqlitecreate.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.domain.Person;

public class PersonDao {
	private PersonSQLiteOpenHelper helper;
	public PersonDao(Context context){
		helper = new PersonSQLiteOpenHelper(context);
	}
	
	public void add(String name, String number,int account){
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into person(name,number,account) values(?,?,?)", new Object[]{name,number,account});
		db.close();
	}
	public void update(String name, String number){
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update person set number =? where name =?", new Object[]{name,number});
		db.close();
	}
	public void delete(int id){
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from person where id =?", new Object[]{id});
		db.close();
	}
	public boolean find(String name){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person where name =?", new String[]{name});
		boolean isFind = cursor.moveToNext();
		cursor.close();
		db.close();
		return isFind;
	}
	
	public List<Person> findAll(){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person", null);
		List<Person> persons = new ArrayList<Person>();
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String number = cursor.getString(cursor.getColumnIndex("number"));
			int account = cursor.getInt(cursor.getColumnIndex("account"));
			Person p = new Person(id,name,number,account);
			persons.add(p);
		}
		cursor.close();
		db.close();
		return persons;
	}
	
}
