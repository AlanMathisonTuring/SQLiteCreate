package com.nutegg.sqlitecreate.test;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.dao.PersonDao;
import com.nutegg.sqlitecreate.dao.PersonSqliteApiDao;
import com.nutegg.sqlitecreate.domain.Person;
/**
 * �����ǲ���ϵͳAPI������SQLite��CRUD����
 * ���Ҵ��Խ�����SQLite�����ʹ��
 * @author GaryChen
 *
 */
public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	//�������ݿ�ķ���
	public void	testCreateDB() throws Exception{
		//getContext():���Կ���ṩ��������
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();//����һ����д�����ݿ�		
	}
	//��
	public void	testAdd() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());

		personDao.add("Phodes", "13575753453",6000);

			
	}
	//ɾ
	public void	testDelete() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.delete("���³�");	
	}

	//��
	public void	testUpdate() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.update("LoonFly", "110");	
	}
	//�������������һ���ֶκ�,�������ݿ�����ֵ�Ĳ���
	public void	testUpdateAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.updateAll();	
	}
	//��ѯ
	public void	testFind() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		boolean isFind = personDao.find("���³�");
		assertEquals(isFind, true);
	}
	//��ѯ
	public void	testFindAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());	
		List<Person> persons = personDao.findAll();
		if(persons.size()>0){
			for(Person p : persons){
				System.out.println("id:"+p.getId()+",����:"+p.getName()+",�绰����:"+p.getNumber()+",���д��:"+p.getAccount());
			}
		}
	}
	
	//�˷�����ʾ��SQLite���ݿ������
	public void testTransaction() throws Exception{
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();
		//��������
		db.beginTransaction();
		try{
			db.execSQL("update person set account = account-2000 where name =?", new Object[]{"Jack"});
			db.execSQL("update person set account = account+2000 where name =?", new Object[]{"LoonFly"});
			//ȫ������ִ�гɹ���������ɹ�
			db.setTransactionSuccessful();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//����ڽ�������ʱ�鿴�Ƿ񱻱��,�������˾�commit,���û��Ǿͻع�
			db.endTransaction();
			db.close();
		}
		
	}
	
}
