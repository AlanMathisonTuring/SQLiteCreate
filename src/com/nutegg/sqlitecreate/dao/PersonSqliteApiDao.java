package com.nutegg.sqlitecreate.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.domain.Person;
/**
 * 此类是系统API执行增删改查操作
 * @author GaryChen
 *
 */
public class PersonSqliteApiDao {
	private PersonSQLiteOpenHelper helper;
	public PersonSqliteApiDao(Context context){
		helper = new PersonSQLiteOpenHelper(context);
	}
	
	public void add(String name, String number,int account){
		SQLiteDatabase db = helper.getWritableDatabase();
		//db.execSQL("insert into person(name,number) values(?,?)", new Object[]{name,number});
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("number", number);
		values.put("account", account);
		long num = db.insert("person", null, values);
		if(num != -1){
			System.out.println("添加成功!");
		}
		db.close();
	}
	public void update(String name, String number){
		SQLiteDatabase db = helper.getWritableDatabase();
		//db.execSQL("update person set number =? where name =?", new Object[]{name,number});
		ContentValues values = new ContentValues();
		values.put("number", number);
		int num = db.update("person", values, "name =?", new String[]{name});
		if(num > 0){
			System.out.println("更新了"+num+"条记录!");
		}else{
			System.out.println("更新失败!");
		}
		db.close();
	}
	
	public void updateAll(){
		SQLiteDatabase db = helper.getWritableDatabase();
		//db.execSQL("update person set number =? where name =?", new Object[]{name,number});
		ContentValues values = new ContentValues();
		values.put("account", 5000);
		int num = db.update("person", values, null, null);
		if(num > 0){
			System.out.println("更新了"+num+"条记录!");
		}else{
			System.out.println("更新失败!");
		}
		db.close();
	}
	public void delete(String name){
		SQLiteDatabase db = helper.getWritableDatabase();
		//db.execSQL("delete from person where id =?", new Object[]{id});
		int num = db.delete("person", "name =?", new String[]{name});
		if(num > 0){
			System.out.println("删除了"+num+"条记录!");
		}else{
			System.out.println("删除失败!");
		}
		db.close();
	}
	public boolean find(String name){
		SQLiteDatabase db = helper.getReadableDatabase();
		//Cursor cursor = db.rawQuery("select * from person where name =?", new String[]{name});
		Cursor cursor = db.query("person", null, "name =?", new String[]{name}, null, null, null);
		boolean isFind = cursor.moveToNext();
		cursor.close();
		db.close();
		return isFind;
	}
	
	public List<Person> findAll(){
		SQLiteDatabase db = helper.getReadableDatabase();
		//Cursor cursor = db.rawQuery("select * from person", null);
		Cursor cursor = db.query("person", null, null, null, null, null, null);

		List<Person> persons = new ArrayList<Person>();
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			int account = cursor.getInt(cursor.getColumnIndex("account"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String number = cursor.getString(cursor.getColumnIndex("number"));
			Person p = new Person(id,name,number,account);
			persons.add(p);
		}
		cursor.close();
		db.close();
		return persons;
	}
	
}
