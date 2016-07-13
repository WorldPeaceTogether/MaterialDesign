package utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.design.material.materialdesign.R;


/**
 * 自定义toast
 * 
 * @author dongsy
 * @version 创建时间：2015年10月23日 下午12:08:52
 */
public class ToastCommom {
	private static ToastCommom toastCommom;

	private Toast toast;

	private ToastCommom() {
	}

	public static ToastCommom createToastConfig() {
		if (toastCommom == null) {
			toastCommom = new ToastCommom();
		}
		return toastCommom;
	}

	/**
	 * 显示Toast
	 * 
	 * @param context
	 * @param tvString
	 */

	public void ToastShow(Context context, String tvString) {
		View layout = LayoutInflater.from(context).inflate(R.layout.toast_dialog2, null);
		TextView text = (TextView) layout.findViewById(R.id.toast_des);
		text.setText(tvString);
		if (toast == null) {
			toast = new Toast(context);
			toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(layout);
			toast.show();
		} else {
			toast.setView(layout);
			toast.show();
		}

	}

}
