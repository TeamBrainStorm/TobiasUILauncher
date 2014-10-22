package com.androidbegin.launcher;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
 
public class Transparent extends LinearLayout 
{

	private Paint innerPaint;
    
	public Transparent(Context context, AttributeSet as) {
		super(context, as);
		init();
	}
	
	public Transparent(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		innerPaint = new Paint();
		innerPaint.setColor(Color.WHITE);
		innerPaint.setAlpha(29000000);
		innerPaint.setAntiAlias(true);
		
	}
	
	public void setInnerPaint(Paint innerPaint) {
		this.innerPaint = innerPaint;
	}
	
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		RectF drawRect = new RectF();
		drawRect.set(0,0, getMeasuredWidth(), getMeasuredHeight());
		canvas.drawRoundRect(drawRect, 5, 5, innerPaint);
		super.dispatchDraw(canvas);
        }
}