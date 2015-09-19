package com.example.fashion4men;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class pents extends Activity implements OnClickListener, android.content.DialogInterface.OnClickListener {
	ImageView imageView1;
	RotateAnimation rotation;
	Button button1;
	MediaPlayer sound;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pents);
		
		imageView1=(ImageView)findViewById(R.id.imageView1);
		button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
		rotation=new RotateAnimation(0, 360);
		rotation.setDuration(5000);
		imageView1.startAnimation(rotation);
		
		
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		sound = MediaPlayer.create(pents.this,R.raw.sound);
		sound.start();
		AlertDialog ad=new AlertDialog.Builder(this)
		.setMessage("Do you want to continue?")
		.setPositiveButton("yes", this)
		.setNegativeButton("no",this)
		.setNeutralButton("cancel",this)
		.setCancelable(false)
		.create();
		ad.show();
	}
	
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
		switch(arg1)
		{
		case DialogInterface.BUTTON_POSITIVE:
			Intent intent = new Intent(pents.this, MainActivity.class);
			startActivity(intent);
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			rotation=new RotateAnimation(0, 360);
			rotation.setDuration(5000);
			imageView1.startAnimation(rotation);
			
			Toast.makeText(getApplicationContext(), "Sorry You Can't Continue", Toast.LENGTH_LONG).show();
			break;
		case DialogInterface.BUTTON_NEUTRAL:
			rotation=new RotateAnimation(0, 360);
			rotation.setDuration(5000);
			imageView1.startAnimation(rotation);
			
			Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
			break;
		
		}
		
		
	}
	
}
