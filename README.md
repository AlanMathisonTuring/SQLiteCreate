# SQLiteCreate
创建一个移动平台的嵌入式数据库SQLite,用单元测试进行测试:
1,首先创建一个类PersonSQLiteOpenHelper继承了SQLite的帮助类去创建一个数据库
2,创建dao层,其中有两个类,分别是SQL语句对数据库进行操作,和系统API操作数据库
3,test包中单元测试类,引用了系统API操作数据库的dao,进行CRUD测试和事务的测试
4,通过ListView方式展示数据库的数据列表