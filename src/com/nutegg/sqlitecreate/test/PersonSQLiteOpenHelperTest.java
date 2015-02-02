package com.nutegg.sqlitecreate.test;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.dao.PersonDao;
import com.nutegg.sqlitecreate.domain.Person;

public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	public void	testCreateDB() throws Exception{
		//getContext():���Կ���ṩ��������
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();//����һ����д�����ݿ�		
	}
	
	public void	testAdd() throws Exception{
		PersonDao personDao= new PersonDao(getContext());
		personDao.add("Jack", "13575757151");
		personDao.add("LoonFly", "13575757152");
		personDao.add("Mr.Yang", "13575757153");
		personDao.add("�ϸ�", "13575757154");
		personDao.add("�´�", "13575757155");
		personDao.add("����", "13575757156");
		personDao.add("Manager.Yu", "13575757157");
			
	}
	
	public void	testDelete() throws Exception{
		PersonDao personDao= new PersonDao(getContext());
		personDao.delete(1);	
	}
	
	public void	testUpdate() throws Exception{
		PersonDao personDao= new PersonDao(getContext());
		personDao.update("���³�", "18069676589");	
	}
	
	public void	testFind() throws Exception{
		PersonDao personDao= new PersonDao(getContext());
		boolean isFind = personDao.find("���³�");
		assertEquals(isFind, true);
	}
	
	public void	testFindAll() throws Exception{
		PersonDao personDao= new PersonDao(getContext());	
		List<Person> persons = personDao.findAll();
		if(persons.size()>0){
			for(Person p : persons){
				System.out.println("id:"+p.getId()+",����:"+p.getName()+",�绰����:"+p.getNumber());
			}
		}
	}
	
}
