package utils;

import android.util.Log;

public class LogUtils {
	private static boolean isDebug = true;
	public static void e(Class<?> clzz,String msg){
		if (isDebug) {
			Log.e(clzz.getSimpleName(), msg);
		}
	}
}
