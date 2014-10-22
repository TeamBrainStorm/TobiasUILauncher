package com.androidbegin.launcher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.d4a.tobiaslauncherphone1.R;

public class GridAdapter extends BaseAdapter {
	Context context;
	private PackageManager packageManager;
	public class ViewHolder {
	public ImageView imageView;
	public TextView textTitle;
	}

	private GridItems[] items;
	private LayoutInflater mInflater;

	public GridAdapter(Context context, GridItems[] locations) {

		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		items = locations;
		packageManager = context.getPackageManager();
		
	}

	public GridItems[] getItems() {
		return items;
	}

	public void setItems(GridItems[] items) {
		this.items = items;
	}

	@Override
	public int getCount() {
		if (items != null) {
			return items.length;
		}
		return 0;
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

	@Override
	public Object getItem(int position) {
		if (items != null && position >= 0 && position < getCount()) {
			return items[position];
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		if (items != null && position >= 0 && position < getCount()) {
			return items[position].id;
		}
		return 0;
	}

	public void setItemsList(GridItems[] locations) {
		this.items = locations;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder viewHolder;
		if (view == null) {
			view = mInflater.inflate(R.layout.custom, parent, false);
			DisplayMetrics metrics = context.getResources().getDisplayMetrics();
			int width = metrics.widthPixels;
			int height = metrics.heightPixels;
			Log.d("",""+width+"&"+height);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) view
					.findViewById(R.id.grid_item_image);
			LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width/6,width/6);
			parms.gravity=Gravity.CENTER;
			viewHolder.imageView.setLayoutParams(parms);
			viewHolder.textTitle = (TextView) view
					.findViewById(R.id.grid_item_label);
			if(width==320){
			viewHolder.textTitle.setTextSize(10); 
			AssetManager mgr = context.getAssets();
			Typeface face = Typeface.createFromAsset(mgr,"lightfont.otf");
			viewHolder.textTitle.setTypeface(face);
//			viewHolder.textTitle.setTextColor(Color.rgb(0,0,0));
			}
			if(width>320){
				viewHolder.textTitle.setTextSize(15); 
				AssetManager mgr = context.getAssets();
				Typeface face = Typeface.createFromAsset(mgr,"lightfont.otf");
				viewHolder.textTitle.setTypeface(face);
//				viewHolder.textTitle.setTextColor(Color.rgb(0,0,0));
				}
			if(width<320){
				viewHolder.textTitle.setTextSize(8); 
				AssetManager mgr = context.getAssets();
				Typeface face = Typeface.createFromAsset(mgr,"lightfont.otf");
				viewHolder.textTitle.setTypeface(face);
//				viewHolder.textTitle.setTextColor(Color.rgb(0,0,0));
				}
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		GridItems gridItems = items[position];
		Log.d("positemsss", "" + items[position]);
		setCatImage(position, viewHolder, gridItems.title);
		return view;
	}

	private void setCatImage(int pos, ViewHolder viewHolder,
			ApplicationInfo title) {
		if ((title.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
			if(title.loadLabel(packageManager).equals("Browser")
					||title.loadLabel(packageManager).equals("Settings")
				||title.loadLabel(packageManager).equals("Camera")
				||title.loadLabel(packageManager).equals("Calculator")
				||title.loadLabel(packageManager).equals("Contacts")
				||title.loadLabel(packageManager).equals("Email")
				||title.loadLabel(packageManager).equals("Alarm Clock")
				||title.loadLabel(packageManager).equals("Music")
				||title.loadLabel(packageManager).equals("Messaging")
				||title.loadLabel(packageManager).equals("Calendar")
				||title.loadLabel(packageManager).equals("Play Store")
				||title.loadLabel(packageManager).equals("Maps")
				||title.loadLabel(packageManager).equals("Downloads")
				||title.loadLabel(packageManager).equals("Video player")
)
				{
			if(title.loadLabel(packageManager).equals("Browser")){
			viewHolder.imageView.setImageResource(R.drawable.browser);	
			viewHolder.textTitle.setText(title.loadLabel(packageManager));
			}
			if(title.loadLabel(packageManager).equals("Calendar")){
				viewHolder.imageView.setImageResource(R.drawable.calendar);	
				
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Play Store")){
				viewHolder.imageView.setImageResource(R.drawable.appstore);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Downloads")){
				viewHolder.imageView.setImageResource(R.drawable.greatapps);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Maps")){
				viewHolder.imageView.setImageResource(R.drawable.map);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Video player")){
				viewHolder.imageView.setImageResource(R.drawable.video);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Calculator")){
				viewHolder.imageView.setImageResource(R.drawable.calculator);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Email")){
				viewHolder.imageView.setImageResource(R.drawable.mail);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Settings")){
				viewHolder.imageView.setImageResource(R.drawable.settings);
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Contacts")){
				viewHolder.imageView.setImageResource(R.drawable.contacts);
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Alarm Clock")){
				viewHolder.imageView.setImageResource(R.drawable.deskclock);
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Music")){
				viewHolder.imageView.setImageResource(R.drawable.music);
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Messaging")){
				viewHolder.imageView.setImageResource(R.drawable.mms);
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			if(title.loadLabel(packageManager).equals("Camera")){
				if(title.packageName.equals("com.android.camera")){
				viewHolder.imageView.setImageResource(R.drawable.camera);	
				viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}else{
					viewHolder.imageView.setImageResource(R.drawable.gallery);	
					viewHolder.textTitle.setText("Gallery");
				}
				}
				}else{
					viewHolder.imageView.setImageDrawable(title.loadIcon(packageManager));
					viewHolder.textTitle.setText(title.loadLabel(packageManager));
				}
			
	    }else{
		viewHolder.imageView.setImageDrawable(title.loadIcon(packageManager));
		viewHolder.textTitle.setText(title.loadLabel(packageManager));
	    }
	}
}