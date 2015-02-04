package com.nutegg.sqlitecreate;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nutegg.sqlitecreate.dao.PersonSqliteApiDao;
import com.nutegg.sqlitecreate.domain.Person;

public class MainActivity extends Activity {
	ListView lv ;
	List<Person> persons;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		PersonSqliteApiDao personDao= new PersonSqliteApiDao(this);		
		persons = personDao.findAll();
		lv = (ListView)this.findViewById(R.id.lv);
		lv.setAdapter(new myAdapter());
	}

	public class myAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return persons.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View v, ViewGroup vg) {
			// TODO Auto-generated method stub
			Person person = persons.get(position);
			//直接将数据放到TextView中
//			TextView tv = new TextView(getApplicationContext());
//			tv.setTextSize(20);
//			tv.setTextColor(Color.BLACK);			
//			tv.setText(person.toString());
//			return tv;
			//利用layoutInflater打气筒创建一个View对象
			View view = View.inflate(MainActivity.this, R.layout.list_item, null);
			
			TextView tv_id = (TextView)view.findViewById(R.id.tv_id);
			tv_id.setText("ID："+person.getId());
			
			TextView tv_name = (TextView)view.findViewById(R.id.tv_name);
			tv_name.setText("姓名："+person.getName());
			
			TextView tv_number = (TextView)view.findViewById(R.id.tv_number);
			tv_number.setText("VIP卡余额："+person.getNumber());
			
			TextView tv_account = (TextView)view.findViewById(R.id.tv_account);
			tv_account.setText("电话号码："+person.getAccount());
			
			return view;
		}
		
	}

}
