package http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;


public class ApiManager {

    private static ApiManager mInstance;

    private ApiService mApiService;

    public ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    //单例模式
    public static ApiService getService() {
        if (mInstance == null) {
            mInstance = new ApiManager();
        }
        return mInstance.mApiService;
    }

}
