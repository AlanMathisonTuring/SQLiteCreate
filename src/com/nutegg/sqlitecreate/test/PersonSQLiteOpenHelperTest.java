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
		//getContext():测试框架提供的上下文
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();//创建一个可写的数据库		
	}
	
	public void	testAdd() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());

		personDao.add("Sky", "13575757159");

			
	}
	
	public void	testDelete() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.delete("吴新超");	
	}

	
	public void	testUpdate() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.update("LoonFly", "110");	
	}
	
	public void	testFind() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		boolean isFind = personDao.find("吴新超");
		assertEquals(isFind, true);
	}
	
	public void	testFindAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());	
		List<Person> persons = personDao.findAll();
		if(persons.size()>0){
			for(Person p : persons){
				System.out.println("id:"+p.getId()+",姓名:"+p.getName()+",电话号码:"+p.getNumber());
			}
		}
	}
	
}
