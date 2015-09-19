package com.example.fashion4men;




import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class db extends Activity{
	Button btn1,btn2;
	EditText ed1,ed2;
	TextView tv, tvid, tvname;
	int currpos;
 	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db);
	
		btn1=(Button)findViewById(R.id.btn1);
		ed1=(EditText)findViewById(R.id.ed1);
		ed2=(EditText)findViewById(R.id.ed2);
		tv=(TextView)findViewById(R.id.tv);
		tvid=(TextView)findViewById(R.id.tvid);
		tvname=(TextView)findViewById(R.id.tvname);
		btn2=(Button)findViewById(R.id.btn2);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db= openOrCreateDatabase("order", MODE_PRIVATE, null);
				try{
				db.execSQL("CREATE TABLE IF NOT EXISTS ordertb(ID INT(5), Name varchar(20))");
				db.execSQL("INSERT INTO ordertb values("+ed1.getText().toString()+",'"+ed2.getText().toString()+"')");
				db.close();
				ed1.setText("");
				ed2.setText("");
				
				Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
				}
				catch(Exception ex)
				{
					Toast.makeText(getApplicationContext(), "Not Saved", Toast.LENGTH_LONG).show();
					}
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				SQLiteDatabase db = openOrCreateDatabase("order", MODE_PRIVATE, null);
				try{
				Cursor c =db.rawQuery("select * from ordertb", null);
				c.moveToFirst();
				currpos=c.getPosition();
				tvid.setText(c.getString(c.getColumnIndex("ID")));
				tvname.setText(c.getString(c.getColumnIndex("Name")));
				db.close();
				Toast.makeText(db.this, "" , Toast.LENGTH_SHORT).show();
				}
				catch(Exception ex)
				{
					Toast.makeText(getApplicationContext(), "Oh No!", Toast.LENGTH_LONG).show();
					
					}
				
			}
		});
	}
}
