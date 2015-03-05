package com.ghatnandurkar.myspecs.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {

	public static int getDeviceHeight(Context context) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

		int height = displayMetrics.heightPixels;
		return height;
	}

	public static int getDeviceWidth(Context context) {

		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int width = displayMetrics.widthPixels;

		return width;
	}

}
