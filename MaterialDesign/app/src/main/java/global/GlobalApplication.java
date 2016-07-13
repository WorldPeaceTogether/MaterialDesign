package global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.design.material.materialdesign.R;


public class GlobalApplication extends Application {
	public static Context context;
	public static int mScreenWidth, mScreenHeight;
	public static Handler mhandler;

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		mScreenHeight = display.getHeight();
		mScreenWidth = display.getWidth();



		mhandler = new Handler();

	}


	public static void runOnUIThread(Runnable runnable) {
		mhandler.post(runnable);
	}


	public static void loadImage(String url,ImageView imageView){
		Glide.with(context).load(url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(imageView);
	}


}
