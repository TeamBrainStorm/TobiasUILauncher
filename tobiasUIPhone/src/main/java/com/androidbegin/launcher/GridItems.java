package com.androidbegin.launcher;

import android.content.pm.ApplicationInfo;

public class GridItems {
	public int id;
	public ApplicationInfo title;

	public GridItems(int id, ApplicationInfo applicationInfo) {
		this.id = id;
		this.title = applicationInfo;
	}
}
