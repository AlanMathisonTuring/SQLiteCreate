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
			TextView tv = new TextView(getApplicationContext());
			tv.setTextSize(20);
			tv.setTextColor(Color.BLACK);
			Person person = persons.get(position);
			tv.setText(person.toString());
			return tv;
		}
		
	}

}
