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

		personDao.add("����", "13575345453",6000);
		personDao.add("�ų���", "13574545453",6000);
		personDao.add("������", "13576345453",6000);
		personDao.add("������", "13575345453",6000);
		personDao.add("��ƨ", "13575345453",6000);
		personDao.add("��ɽ��", "13575345453",6000);
		personDao.add("�Ŷ�ׯ", "13575345453",6000);
		personDao.add("����", "13575345453",5000);
		personDao.add("����ү", "13575345653",6000);
		personDao.add("������", "13575345453",6000);
		personDao.add("С����", "13575686453",6000);
		personDao.add("С����", "18675345453",56000);
		personDao.add("���Ϻ�", "13575865453",5000);
		personDao.add("����ʯ", "13578345453",6000);
		personDao.add("������", "13575345453",6000);
		personDao.add("�װٺ�", "13587645453",6000);
		personDao.add("��õ��", "13577335453",6000);
		personDao.add("����ʦ", "13575465453",3000);
		personDao.add("����Ϊ", "13575465453",5000);
		personDao.add("������", "13575465453",6000);
		personDao.add("������", "13575465453",5000);
		personDao.add("Ϳѻ", "13575465453",3000);
		personDao.add("֣ˬ", "13575465453",4000);
		personDao.add("����", "13575465453",6000);
		personDao.add("�ɶ�", "13575465453",6500);
		personDao.add("ţ����", "13575465453",7000);
		personDao.add("����", "13575465453",6000);
		personDao.add("�й�÷��", "13575465453",8000);
		personDao.add("���滺", "13575465453",9000);
		personDao.add("���ɿ�", "13575465453",4560);
		personDao.add("����", "13575465453",6750);
		personDao.add("���ʹ", "13575465453",56000);
		personDao.add("º��", "13575465453",60560);
		personDao.add("ë��", "13575465453",6560);
		personDao.add("����", "13575465453",60560);
		personDao.add("ϣ��˹", "13575465453",600560);
		personDao.add("Ǯ����", "13575465453",656000);

			
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
