package com.nutegg.sqlitecreate.personprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;

public class PersonProvider extends ContentProvider {

	PersonSQLiteOpenHelper helper;
	private static final int QUERY = 1;
	private static final int INSERT = 1;
	private static final int UPDATE = 1;
	private static final int DELETE = 1;
	//定义uri匹配器,如果不匹配,返回-1
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	//定义一组匹配规则
	static{
		matcher.addURI("com.nutegg.personprovider", "query", QUERY);
		matcher.addURI("com.nutegg.personprovider", "query", INSERT);
		matcher.addURI("com.nutegg.personprovider", "query", UPDATE);
		matcher.addURI("com.nutegg.personprovider", "query", DELETE);
	}
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		System.out.println("开启PersonProvider内容控制器!");
		helper = new PersonSQLiteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] zd, String where, String[] value,
			String order) {
		
		
		// TODO Auto-generated method stub
		if(matcher.match(uri) == 1){
			System.out.println("路径匹配成功,正在进行查询操作!");
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("person", zd, where, value, null, null, order);	
			return cursor;
		}else{
			System.out.println("路径匹配失败,不能进行查询操作!");
			throw new IllegalArgumentException("路径匹配失败,不能进行查询操作!");
		}

	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
