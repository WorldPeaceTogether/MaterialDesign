package http;

import android.content.Context;
import android.content.DialogInterface;


import com.design.material.materialdesign.R;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import utils.LoadingUtils;
import utils.ToastCommom;

/**
 * ********************************************************
 * ******************  使用说明  ***************************
 * *************************************
 * 各个方法的使用，看注释
 * *******************
 * 此类目的是Http请求后的回调方法；
 * 正常情况下只需要重写方法onSuccess方法；
 *
 * @param <T> 返回的数据类型
 */
public class Response<T> extends Subscriber<T> {

    private Context mContext;
    private boolean mNeedDialog = false;

    public Response(Context context) {
        this.mContext = context;
    }

    public Response(Context context, boolean needDialog) {
        this.mContext = context;
        this.mNeedDialog = needDialog;
    }


    /**
     * 此方法现在onNext或者onError之后都会调用
     * 所以一般要处理请求结束时的信息是，需要重写此方法
     * 例如，loading结束时，刷新下拉刷新结果时等…………
     */
    @Override
    public void onCompleted() {
        LoadingUtils.dismiss();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onStart() {
        if (mNeedDialog) {
            LoadingUtils.show(mContext);
            LoadingUtils.setDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    unsubscribe();
                }
            });
        }
    }

    /**
     * 除非非要获取网络错误信息，否则一般不需要重写此方法；
     * 例如：网络400，404，断网，超时，等等…………
     */
    @Override
    public void onError(Throwable e) {
        onCompleted();
        if (e == null || mContext == null)
            return;
        try {
            if (e instanceof ConnectException || e instanceof UnknownHostException) {
                ToastCommom.createToastConfig().ToastShow(mContext, mContext.getResources().getString(R.string.network_error));
            } else if (e instanceof SocketTimeoutException) {
                ToastCommom.createToastConfig().ToastShow(mContext, mContext.getResources().getString(R.string.network_timeout));
            } else if (e instanceof HttpException) {
                ToastCommom.createToastConfig().ToastShow(mContext, mContext.getResources().getString(R.string.host_error));
            }
        } catch (Exception ignored) {

        }
        if (e.getMessage() != null) ;
    }

}