package http;



import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jumpbox on 16/5/2.
 */
public class RxHttp<T> {

    public void send(Observable<T> observable, Subscriber<T> subscription) {
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscription);
    }
/*
* 当成功请求完一个URL后，继续下一个URL请求。
*
* */
    public void sendTest(Observable<T> observable, Subscriber<T> subscription) {

    }
}
