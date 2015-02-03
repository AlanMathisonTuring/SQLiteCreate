package com.nutegg.sqlitecreate.test;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.nutegg.sqlitecreate.PersonSQLiteOpenHelper;
import com.nutegg.sqlitecreate.dao.PersonDao;
import com.nutegg.sqlitecreate.dao.PersonSqliteApiDao;
import com.nutegg.sqlitecreate.domain.Person;
/**
 * 该类是测试系统API来操作SQLite的CRUD操作
 * 并且粗略介绍了SQLite事务的使用
 * @author GaryChen
 *
 */
public class PersonSQLiteOpenHelperTest extends AndroidTestCase {

	//创建数据库的方法
	public void	testCreateDB() throws Exception{
		//getContext():测试框架提供的上下文
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();//创建一个可写的数据库		
	}
	//增
	public void	testAdd() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());

		personDao.add("Phodes", "13575753453",6000);

			
	}
	//删
	public void	testDelete() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.delete("吴新超");	
	}

	//改
	public void	testUpdate() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.update("LoonFly", "110");	
	}
	//这个是我增加了一个字段后,更新数据库的这个值的操作
	public void	testUpdateAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		personDao.updateAll();	
	}
	//查询
	public void	testFind() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());
		boolean isFind = personDao.find("吴新超");
		assertEquals(isFind, true);
	}
	//查询
	public void	testFindAll() throws Exception{
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(getContext());	
		List<Person> persons = personDao.findAll();
		if(persons.size()>0){
			for(Person p : persons){
				System.out.println("id:"+p.getId()+",姓名:"+p.getName()+",电话号码:"+p.getNumber()+",银行存款:"+p.getAccount());
			}
		}
	}
	
	//此方法演示了SQLite数据库的事务
	public void testTransaction() throws Exception{
		PersonSQLiteOpenHelper helper = new PersonSQLiteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();
		//开启事务
		db.beginTransaction();
		try{
			db.execSQL("update person set account = account-2000 where name =?", new Object[]{"Jack"});
			db.execSQL("update person set account = account+2000 where name =?", new Object[]{"LoonFly"});
			//全部代码执行成功后标记事务成功
			db.setTransactionSuccessful();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//最后在结束事务时查看是否被标记,如果标记了就commit,如果没标记就回滚
			db.endTransaction();
			db.close();
		}
		
	}
	
}
