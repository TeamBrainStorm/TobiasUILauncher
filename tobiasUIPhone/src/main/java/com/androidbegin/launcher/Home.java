package com.androidbegin.launcher;


import com.d4a.tobiaslauncherphone1.R;
import com.d4a.tobiaslauncherphone1.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

@SuppressLint("NewApi")
public class Home extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		

	}
	
	
	 /** Called when the user clicks the sms button */
	 public void sms(View view) {
	 	Intent i = new Intent(Intent.ACTION_MAIN);
	     PackageManager manager = getPackageManager();
	     try {
	        i = manager.getLaunchIntentForPackage("com.google.android.talk");
	     if (i == null)
	         throw new PackageManager.NameNotFoundException();
	     i.addCategory(Intent.CATEGORY_LAUNCHER);
	     startActivity(i);
	     } catch (PackageManager.NameNotFoundException e) {
	    	 
	     }

}
	 
	    /** Called when the user clicks the apps button */
	    public void apps(View view) {
	    	 Intent myIntent1 = new Intent(Home.this, MyActivity.class);
	    //	 Intent myIntent1 = new Intent(MainActivity.this, Main.class);
	     	Home.this.startActivity(myIntent1);
	    }
	    
		 /** Called when the user clicks the Phone button */
		 public void phone(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		            startActivity(intent);
		      
	}
		 
		 
		 /** Called when the user clicks the facebook button */
		 public void facebook(View view) {
		 	Intent i = new Intent(Intent.ACTION_MAIN);
		 	PackageManager manager = getPackageManager();
		 	try {
		 	   i = manager.getLaunchIntentForPackage("com.facebook.katana");
		 	if (i == null)
		 	    throw new PackageManager.NameNotFoundException();
		 	i.addCategory(Intent.CATEGORY_LAUNCHER);
		 	startActivity(i);
		 	} catch (PackageManager.NameNotFoundException e) {

		 	}
		    	 
		     }
		 
		 
		 /** Called when the user clicks the twitter button */
		 public void twitter(View view) {
		 	Intent i = new Intent(Intent.ACTION_MAIN);
		 	PackageManager manager = getPackageManager();
		 	try {
		 	   i = manager.getLaunchIntentForPackage("com.twitter.android");
		 	if (i == null)
		 	    throw new PackageManager.NameNotFoundException();
		 	i.addCategory(Intent.CATEGORY_LAUNCHER);
		 	startActivity(i);
		 	} catch (PackageManager.NameNotFoundException e) {

		 	}
		    	
		 	
		 	
		 	
		 	
		     }
		 
		 
		 
		 /** Called when the user clicks the instagram button */
		 public void gram(View view) {
		 	Intent i = new Intent(Intent.ACTION_MAIN);
		 	PackageManager manager = getPackageManager();
		 	try {
		 	   i = manager.getLaunchIntentForPackage("com.instagram.android");
		 	if (i == null)
		 	    throw new PackageManager.NameNotFoundException();
		 	i.addCategory(Intent.CATEGORY_LAUNCHER);
		 	startActivity(i);
		 	} catch (PackageManager.NameNotFoundException e) {

		 	}
		    	
		 	
		 	
		 	
		 	
		     }
}
