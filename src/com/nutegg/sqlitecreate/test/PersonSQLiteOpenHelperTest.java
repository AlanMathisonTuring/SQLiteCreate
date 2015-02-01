package com.nutegg.sqlitecreate.test;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;

import android.test.AndroidTestCase;

public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	public void	testCreateDB() throws Exception{
		//getContext():测试框架提供的上下文
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		helper.getWritableDatabase();//创建一个可写的数据库
	}
	
}
