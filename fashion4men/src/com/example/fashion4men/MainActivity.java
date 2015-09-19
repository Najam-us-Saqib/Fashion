package com.example.fashion4men;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
//Button button1;
TextView tv;
//ImageView imageView1;
RotateAnimation rotation;
ListView listview1;
ArrayAdapter<String> ad;
ScaleAnimation scale;
MediaPlayer sound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//button1=(Button)findViewById(R.id.button1);
		//imageView1=(ImageView)findViewById(R.id.imageView1);
		tv=(TextView)findViewById(R.id.tv);
		listview1=(ListView)findViewById(R.id.listView1);
		
		tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			scale=new ScaleAnimation(0,2,0,2);
			scale.setDuration(2000);
			tv.startAnimation(scale);
				//rotation=new RotateAnimation(0, 360);
				//rotation.setDuration(2000);
				//tv.startAnimation(rotation);
				//imageView1.startAnimation(rotation);
				
				
			}
		});
		
		String[] values = new String[] { "Pents", 
		        "Shirts",
		        "Watches",
		        "Order Online"
		        
		       };


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, android.R.id.text1, values);

		listview1.setAdapter(adapter);
		
		listview1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				// TODO Auto-generated method stub
				if(position==0)
				{
					
						Intent intent= new Intent(MainActivity.this,pents.class);
						startActivity(intent);

						
						Toast.makeText(getApplicationContext(), "Pents", Toast.LENGTH_LONG).show();
					}
			
				else if(position==1)
				{
						Intent intent= new Intent(MainActivity.this,shirts.class);
						startActivity(intent);
					
				Toast.makeText(getApplicationContext(), "Shirts", Toast.LENGTH_LONG).show();
							}
				else if(position==2)
				{
					Intent intent=new Intent(MainActivity.this,watches.class);
					startActivity(intent);
					
				Toast.makeText(getApplicationContext(), "Watches", Toast.LENGTH_LONG).show();
				}
				else if(position==3)
				{
					Intent intent=new Intent(MainActivity.this,db.class);
					startActivity(intent);
					
				Toast.makeText(getApplicationContext(), "Database", Toast.LENGTH_LONG).show();
				
					
					
				}
				
			}
		});

			
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
