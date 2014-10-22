package com.androidbegin.launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.androidbegin.launcher.SimpleGestureFilter.SimpleGestureListener;
import com.d4a.tobiaslauncherphone1.R;
import com.viewpagerindicator.PageIndicator;

import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyActivity extends FragmentActivity implements
		SimpleGestureListener {
	public PageIndicator mIndicator;
	private ViewPager awesomePager;
	private SimpleGestureFilter detector;
	private PagerAdapter pm;
	private PackageManager packageManager = null;
	public List<ApplicationInfo> applist = null;
	ImageView call, browse, music, email;
	String calling, browsing, player, emailsend;
	LinearLayout lay;
	ImageView b_t, w_fi, brigthness, m_data, speaker;
	WifiManager wifi;
	BluetoothAdapter bluetooth;
	// TextView d_t,m_t,b_t,mu_t;
	boolean isEnabled;
	AudioManager mobilemode;
	int brightness = 0;
	private Window window;
	ContentResolver cResolver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Detect touched area
		cResolver = getContentResolver();
		window = getWindow();
		detector = new SimpleGestureFilter(this, this);
		bluetooth = BluetoothAdapter.getDefaultAdapter();
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
		LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(
				width / 4, width / 6);
		parms.gravity = Gravity.CENTER_HORIZONTAL;
		awesomePager = (ViewPager) findViewById(R.id.pager);
		mIndicator = (PageIndicator) findViewById(R.id.pagerIndicator);

		
		// d_t=(TextView)findViewById(R.id.d_t);
		// m_t=(TextView)findViewById(R.id.m_t);
		// b_t=(TextView)findViewById(R.id.b_t);
		// mu_t=(TextView)findViewById(R.id.mu_t);
		// Typeface face =
		// Typeface.createFromAsset(getAssets(),"lightfont.otf");
		// if(width==320){
		// d_t.setTextSize(10);
		// m_t.setTextSize(10);
		// b_t.setTextSize(10);
		// mu_t.setTextSize(10);
		// }
		// if(width>320){
		// d_t.setTextSize(15);
		// m_t.setTextSize(15);
		// b_t.setTextSize(15);
		// mu_t.setTextSize(15);
		// }
		// if(width<320){
		// d_t.setTextSize(8);
		// m_t.setTextSize(8);
		// b_t.setTextSize(8);
		// mu_t.setTextSize(8);
		// }
		// d_t.setText("Call");
		// m_t.setText("Email");
		// b_t.setText("Browser");
		// mu_t.setText("Music");
		// b_t.setTypeface(face);
		// mu_t.setTypeface(face);
		// d_t.setTypeface(face);
		// m_t.setTypeface(face);
		launcherstart();

	}

//	protected void brigthadjst() {
//
//		// Variable to store brightness value
//
//		// Content resolver used as a handle to the system's settings
//
//		View layout = View.inflate(this, R.layout.dialog_layout, null);
//		AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
//		builder.setTitle("Alert Dialog");
//		builder.setView(layout);
//		builder.setMessage("This is Example of Alert Dialog with three Buttons");
//		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface arg0, int arg1) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Ok is clicked",
//						Toast.LENGTH_LONG).show();
//				System.putInt(cResolver, System.SCREEN_BRIGHTNESS, 0);
//			}
//		});
//		builder.setNegativeButton("Cancel",
//				new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface arg0, int arg1) {
//						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"Cancel is clicked", Toast.LENGTH_LONG).show();
//						System.putInt(cResolver, System.SCREEN_BRIGHTNESS, 100);
//						// Get the current window attributes
//						LayoutParams layoutpars = window.getAttributes();
//						// Set the brightness of this window
//						layoutpars.screenBrightness = 100 / (float) 255;
//						// Apply attribute changes to this window
//						window.setAttributes(layoutpars);
//					}
//				});
//		builder.setNeutralButton("Close",
//				new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface arg0, int arg1) {
//						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"Close is clicked", Toast.LENGTH_LONG).show();
//						// Set the system brightness using the brightness
//						// variable value
//						System.putInt(cResolver, System.SCREEN_BRIGHTNESS,
//								brightness);
//						// Get the current window attributes
//						LayoutParams layoutpars = window.getAttributes();
//						// Set the brightness of this window
//						layoutpars.screenBrightness = brightness / (float) 255;
//						// Apply attribute changes to this window
//						window.setAttributes(layoutpars);
//
//					}
//				});
//		builder.show(); // To show the AlertDialog
//
//		// Set the seekbar range between 0 and 255
//
//	}

	@Override
	protected void onResume() {
			launcherstart();
//			if (getIntent().getAction (). equals ("android.intent.action.PACKAGE_ADDED")) {
//				
//				String packageName = getIntent().getDataString ();
//				java.lang.System.out.println ("installed:" + packageName + "package name of the program");
//				//getpackgename(packageName);
//
//
//				}   
//				if (getIntent().getAction (). equals ("android.intent.action.PACKAGE_REMOVED")) {
//					
//				String packageName = getIntent().getDataString ();
//				java.lang.System.out.println ("uninstall:" + packageName + "package name of the program");
//				//getpackgename(packageName);
//				}
		super.onResume();
		
		
	}

	public void launcherstart() {
		packageManager = getPackageManager();
		applist = checkForLaunchIntent(packageManager
				.getInstalledApplications(PackageManager.GET_META_DATA));
		Iterator<ApplicationInfo> it = applist.iterator();
		List<GridFragment> gridFragments = new ArrayList<GridFragment>();
		it = applist.iterator();
		int i = 0;
		// NormalFragment normalFragments;
		while (it.hasNext()) {
			ArrayList<GridItems> itmLst = new ArrayList<GridItems>();
			GridItems itm = new GridItems(0, it.next());
			itmLst.add(itm);
			i = i + 1;

			if (it.hasNext()) {
				GridItems itm1 = new GridItems(1, it.next());
				itmLst.add(itm1);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm2 = new GridItems(2, it.next());
				itmLst.add(itm2);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm3 = new GridItems(3, it.next());
				itmLst.add(itm3);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm4 = new GridItems(4, it.next());
				itmLst.add(itm4);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm5 = new GridItems(5, it.next());
				itmLst.add(itm5);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm6 = new GridItems(6, it.next());
				itmLst.add(itm6);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm7 = new GridItems(7, it.next());
				itmLst.add(itm7);
				i = i + 1;
			}

			if (it.hasNext()) {
				GridItems itm8 = new GridItems(8, it.next());
				itmLst.add(itm8);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm9 = new GridItems(9, it.next());
				itmLst.add(itm9);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm10 = new GridItems(10, it.next());
				itmLst.add(itm10);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm11 = new GridItems(11, it.next());
				itmLst.add(itm11);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm12 = new GridItems(12, it.next());
				itmLst.add(itm12);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm13 = new GridItems(13, it.next());
				itmLst.add(itm13);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm14 = new GridItems(14, it.next());
				itmLst.add(itm14);
				i = i + 1;
			}
			if (it.hasNext()) {
				GridItems itm15 = new GridItems(15, it.next());
				itmLst.add(itm15);
				i = i + 1;
			}
			GridItems[] gp = {};
			GridItems[] gridPage = itmLst.toArray(gp);
			// normalFragments=(new NormalFragment(MyActivity.this));
			gridFragments.add(new GridFragment(gridPage, MyActivity.this));
		}
		// pm = new PagerAdapter(getSupportFragmentManager(), normalFragments);
		pm = new PagerAdapter(getSupportFragmentManager(), gridFragments);
		awesomePager.setAdapter(pm);
		mIndicator.setViewPager(awesomePager);

	}

	private class PagerAdapter extends FragmentStatePagerAdapter {
		private List<GridFragment> fragments;

		public PagerAdapter(FragmentManager fm, List<GridFragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}

		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}

	
	public List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list) {
		ArrayList<ApplicationInfo> applist = new ArrayList<ApplicationInfo>();
		for (ApplicationInfo info : list) {
			try {
				if (null != packageManager
						.getLaunchIntentForPackage(info.packageName)) {
					if ((info.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
						if (info.loadLabel(packageManager).equals("Music")
								|| info.loadLabel(packageManager).equals(
										"Google Play Music")) {
							if (player == null) {
								player = info.packageName;
							}
						}
						if (info.loadLabel(packageManager).equals("Browser")
								|| info.loadLabel(packageManager).equals(
										"Chrome")) {
							if (browsing == null) {
								browsing = info.packageName;
							}
						}
						applist.add(info);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ArrayList<ApplicationInfo> neapplist = new ArrayList<ApplicationInfo>();
		for (ApplicationInfo info : list) {
			try {
				if (null != packageManager
						.getLaunchIntentForPackage(info.packageName)) {
					if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
						neapplist.add(info);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.sort(applist, new ApplicationInfo.DisplayNameComparator(
				packageManager));
		Collections.sort(neapplist, new ApplicationInfo.DisplayNameComparator(
				packageManager));
		for (int i = 0; i < neapplist.size(); i++) {
			ApplicationInfo in = neapplist.get(i);
			applist.add(in);
		}
		return applist;
	}

	@Override
	public void onBackPressed() {
		
		
	}

	@Override
	public void onSwipe(int direction) {
		switch (direction) {

		case SimpleGestureFilter.SWIPE_RIGHT:
			break;
		case SimpleGestureFilter.SWIPE_LEFT:
			break;


		}
		// Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	@Override
	public void onDoubleTap() {
		// Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent("android.intent.action.SET_WALLPAPER");

		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			// Log.wtf(TAG, "No activity found to handle " + +
			// intent.toString());
		}
		
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
	 
	    /** Called when the user clicks the back button */
	    public void back(View view) {
	    	 Intent myIntent1 = new Intent(MyActivity.this, Home.class);
	    //	 Intent myIntent1 = new Intent(MainActivity.this, Main.class);
	    	 MyActivity.this.startActivity(myIntent1);
	    }
	    
		 /** Called when the user clicks the Phone button */
		 public void phone(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		            startActivity(intent);
		      
	}
}