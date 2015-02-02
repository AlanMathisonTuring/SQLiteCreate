package com.nutegg.sqlitecreate.test;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.dao.PersonDao;
import com.nutegg.sqlitecreate.dao.PersonSqliteApiDao;
import com.nutegg.sqlitecreate.domain.Person;

public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	public void	testCreateDB() throws Exception{
		//getContext():���Կ���ṩ��������
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();//����һ����д�����ݿ�		
	}
	
	public void	testAdd() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());

		personDao.add("Sky", "13575757159");

			
	}
	
	public void	testDelete() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.delete("���³�");	
	}

	
	public void	testUpdate() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.update("LoonFly", "110");	
	}
	
	public void	testFind() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		boolean isFind = personDao.find("���³�");
		assertEquals(isFind, true);
	}
	
	public void	testFindAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());	
		List<Person> persons = personDao.findAll();
		if(persons.size()>0){
			for(Person p : persons){
				System.out.println("id:"+p.getId()+",����:"+p.getName()+",�绰����:"+p.getNumber());
			}
		}
	}
	
}
