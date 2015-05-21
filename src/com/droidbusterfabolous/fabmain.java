package com.droidbusterfabolous;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageButton;

public class fabmain extends ImageButton{
	Uri Myuri;
	String Myfaburi ;
	ImageButton fabimg;
	Animation animshow;

		public fabmain(final Context c, AttributeSet attrs) {
			super(c, attrs);
			// TODO Auto-generated constructor stub
			fabimg = (this);
			 SharedPreferences sharedPreferences = c.getSharedPreferences("Droidbuster",Context.MODE_PRIVATE);    
			   Boolean Netvisiblity= sharedPreferences.getBoolean("gettriggered",false);
			   if (Netvisiblity == true){
				   fabimg.setSelected(false);
			     }
			     else{
			    	 fabimg.setSelected(true); 
			     }

			   
			   
			   fabimg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 if (v.isSelected()){
			            v.setSelected(false);
						Intent intent = new Intent();
						intent.setAction("com.droidbuster.hide.fabs");
						c.sendBroadcast(intent);
		                SharedPreferences sharedPreferences = c.getSharedPreferences("Droidbuster",Context.MODE_PRIVATE);
		                SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		                editor.putBoolean("gettriggered", true); //true or false
		                editor.commit();
			        } else {
			            v.setSelected(true);
						Intent intent = new Intent();
						intent.setAction("com.droidbuster.show.fabs");
						c.sendBroadcast(intent);
		                SharedPreferences sharedPreferences = c.getSharedPreferences("Droidbuster",Context.MODE_PRIVATE);
		                SharedPreferences.Editor editor = sharedPreferences.edit(); //opens the editor
		                editor.putBoolean("gettriggered", false); //true or false
		                editor.commit();
			        }		};
			});
		
		}

	}
