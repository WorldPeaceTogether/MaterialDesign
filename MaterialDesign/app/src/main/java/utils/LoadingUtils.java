package utils;


import android.content.Context;
import android.content.DialogInterface;

import com.design.material.materialdesign.R;


public class LoadingUtils {
	private static LoadingDialog dialog;

	public static void show(Context context) {
		dialog = new LoadingDialog(context, R.style.ActionSheetDialogStyle, R.layout.view_tips_loading);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();

	}

	public static void dismiss() {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	public static void setDismissListener(DialogInterface.OnDismissListener dismissListener){
		dialog.setOnDismissListener(dismissListener);
	}

}
