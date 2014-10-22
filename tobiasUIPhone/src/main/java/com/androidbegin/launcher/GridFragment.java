package com.androidbegin.launcher;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.Toast;
import com.d4a.tobiaslauncherphone1.R;

@SuppressLint({ "ValidFragment", "InlinedApi" })
public class GridFragment extends Fragment implements OnItemLongClickListener,OnItemClickListener {
int PICK_CONTACT=1;
	private GridView mGridView;
	private GridAdapter mGridAdapter;
	GridItems[] gridItems = {};
	private Activity activity;

	public GridFragment(GridItems[] gridItems, Activity activity) {
		this.gridItems = gridItems;
		this.activity = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view;
		view = inflater.inflate(R.layout.grid, container, false);
		mGridView = (GridView) view.findViewById(R.id.gridView);
		mGridView.setVerticalScrollBarEnabled(false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (activity != null) {

			mGridAdapter = new GridAdapter(activity, gridItems);
			if (mGridView != null) {
				mGridView.setAdapter(mGridAdapter);
			}

		mGridView.setOnItemClickListener(this);
		//{
//				@Override
//				public void onItemClick(AdapterView parent, View view,
//						int position, long id) {
//					
//				}
//			});
			mGridView.setOnItemLongClickListener(this);

//				@Override
//				public boolean onItemLongClick(AdapterView parent, View view,
//						int position, long id) {
//					
//					return true;
//				}
//			});
		}
	}

	protected void onGridItemLongClick(GridView parent, View view,
			int position, long id) {
		packageManager = activity.getPackageManager();
		ApplicationInfo info = gridItems[position].title;
		if (null != packageManager.getLaunchIntentForPackage(info.packageName)) {
			if ((info.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
				Toast.makeText(activity, "Not Uninstall", Toast.LENGTH_LONG)
						.show();
			} else {
				Intent intent = new Intent(Intent.ACTION_DELETE);
				intent.setData(Uri.parse("package:" + info.packageName));
				startActivity(intent);
			}
		}
	}
	public PackageManager packageManager = null;

	public void onGridItemClick(GridView g, View v, int position, long id) {
		packageManager = activity.getPackageManager();
		ApplicationInfo info = gridItems[position].title;
		if(info.packageName.equals("com.android.contacts")){
			Intent i = new Intent();
		    i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
		    i.setAction("android.intent.action.MAIN");
		    i.addCategory("android.intent.category.LAUNCHER");
		    i.addCategory("android.intent.category.DEFAULT");
		    startActivity(i);
		}else{
		Intent i = packageManager.getLaunchIntentForPackage(info.packageName);
		Log.e("TAG", "POSITION CLICKED " + info.packageName);
		if (null != i) {
			startActivity(i);
		}
		}
		Log.e("TAG", "POSITION CLICKED " + position);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		onGridItemLongClick((GridView) parent, view, position, id);
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		onGridItemClick((GridView) parent, view, position, id);
		
	}
	
}
