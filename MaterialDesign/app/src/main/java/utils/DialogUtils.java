package utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class DialogUtils {


    private static PopupWindow dialogPopup;
    private static PopupWindow popup;


    public static void showView(Context context, View view, final Window window, View parent) {
        popup = new PopupWindow(context);
        popup.setHeight(LayoutParams.WRAP_CONTENT);
        popup.setWidth(LayoutParams.MATCH_PARENT);
        popup.setContentView(view);
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.setFocusable(true);
        backgroundAlpha(window, 0.5f);
        popup.showAsDropDown(parent);
        popup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(window, 1f);
            }
        });
    }

    public static PopupWindow showViewAtBottom(Context context, View view, final Window window, View parent) {
        popup = new PopupWindow(context);
        popup.setHeight(LayoutParams.WRAP_CONTENT);
        popup.setWidth(LayoutParams.MATCH_PARENT);
        popup.setContentView(view);
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.setFocusable(true);
        backgroundAlpha(window, 0.5f);


        popup.showAtLocation(parent, Gravity.BOTTOM, 0, SystemBarUtils.getNavigationBarHeight(context));
        popup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(window, 1f);
            }
        });
        return popup;
    }

    public static PopupWindow showViewAtCenter(Context context, View view, final Window window, View parent) {
        return showViewAtCenter(context, view, window, parent, null);
    }

    public static PopupWindow showViewAtCenter(Context context, View view, final Window window, View parent,
                                               final OnMessageDismissListener listener) {
        dialogPopup = new PopupWindow(context);
        dialogPopup.setHeight(LayoutParams.WRAP_CONTENT);
        dialogPopup.setWidth(LayoutParams.MATCH_PARENT);
        dialogPopup.setContentView(view);
        dialogPopup.setBackgroundDrawable(new BitmapDrawable());
        dialogPopup.setFocusable(true);
        backgroundAlpha(window, 0.5f);
        dialogPopup.showAtLocation(parent, Gravity.CENTER, 0, 0);
        dialogPopup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(window, 1f);
                if (listener != null) {
                    listener.onDismiss();
                }
            }
        });
        return dialogPopup;
    }

    public static PopupWindow showRecordView(Context context, View view, final Window window, View parent, boolean focusable,
                                             final OnMessageDismissListener listener) {

        dialogPopup = new PopupWindow(context);
        dialogPopup.setHeight(LayoutParams.WRAP_CONTENT);
        dialogPopup.setWidth(LayoutParams.MATCH_PARENT);
        dialogPopup.setContentView(view);
        dialogPopup.setBackgroundDrawable(new BitmapDrawable());
        dialogPopup.setFocusable(focusable);
        backgroundAlpha(window, 0.5f);
        dialogPopup.showAtLocation(parent, Gravity.CENTER, 0, 0);
        dialogPopup.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(window, 1f);
                if (listener != null) {
                    listener.onDismiss();
                }
            }
        });
        return dialogPopup;
    }


    public static void backgroundAlpha(Window window, float alpha) {
        LayoutParams params = window.getAttributes();
        params.alpha = alpha;
        window.setAttributes(params);
    }


    public interface OnMessageDismissListener {
        public void onDismiss();

    }

}
