package com.nutegg.sqlitecreate.test;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;

import android.test.AndroidTestCase;

public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	public void	testCreateDB() throws Exception{
		//getContext():���Կ���ṩ��������
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		helper.getWritableDatabase();//����һ����д�����ݿ�
	}
	
}
