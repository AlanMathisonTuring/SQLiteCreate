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
	private static final int INSERT = 2;
	private static final int UPDATE = 3;
	private static final int DELETE = 4;
	//����uriƥ����,�����ƥ��,����-1
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	//����һ��ƥ�����
	static{
		matcher.addURI("com.nutegg.personprovider", "query", QUERY);
		matcher.addURI("com.nutegg.personprovider", "insert", INSERT);
		matcher.addURI("com.nutegg.personprovider", "update", UPDATE);
		matcher.addURI("com.nutegg.personprovider", "delete", DELETE);
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
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		if(matcher.match(uri) == INSERT){
			System.out.println("·��ƥ��ɹ�,���ڽ�����������!");
			Uri url = Uri.parse("content://com.nutegg.doing/insert");
			SQLiteDatabase db = helper.getReadableDatabase();
			db.insert("person",null, values);
			this.getContext().getContentResolver().notifyChange(url, null);
		}else{
			System.out.println("·��ƥ��ʧ��,���ܽ�����������!");
			throw new IllegalArgumentException("·��ƥ��ʧ��,���ܽ�����������!");
		}
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		System.out.println("����PersonProvider���ݿ�����!");
		helper = new PersonSQLiteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] zd, String where, String[] value,
			String order) {
		
		
		// TODO Auto-generated method stub
		if(matcher.match(uri) == 1){
			System.out.println("·��ƥ��ɹ�,���ڽ��в�ѯ����!");
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("person", zd, where, value, null, null, order);	
			return cursor;
		}else{
			System.out.println("·��ƥ��ʧ��,���ܽ��в�ѯ����!");
			throw new IllegalArgumentException("·��ƥ��ʧ��,���ܽ��в�ѯ����!");
		}

	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
