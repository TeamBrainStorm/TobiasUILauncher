package com.androidbegin.launcher;

import com.androidbegin.launcher.SimpleGestureFilter.SimpleGestureListener;
import com.d4a.tobiaslauncherphone1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class SwipeScreenExample extends Activity implements SimpleGestureListener{
		    private SimpleGestureFilter detector;
		 
		@Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main);
		 
		        // Detect touched area 
		        detector = new SimpleGestureFilter(this,this);
		}
		 
    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
    	// Call onTouchEvent of SimpleGestureFilter class
         this.detector.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
    }
	@Override
	 public void onSwipe(int direction) {
	  String str = "";
	 
	  switch (direction) {
	 
	  case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
	                                           break;
	  case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
	                                                 break;
	  case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
	                                                 break;
	  case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
	                                                 break;
	 
	  }
	   Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	 }
	 
	 @Override
	 public void onDoubleTap() {
	    Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	 }
		 
  }