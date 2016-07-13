package http;




import java.util.ArrayList;
import java.util.Map;

import bean.BaseResult;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by jumpbox on 16/5/2.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST(HttpUrl.IMG)
    Observable<BaseResult> getImageTitle();

   /* @FormUrlEncoded
    @POST(HttpUrl.REGISTER)
    Observable<BaseResult> register(@Field("CellPhone") String phone, @Field("Password") String Password
            , @Field("UserName") String UserName, @Field("Result") String Result, @Field("Cn") String cn);

    @FormUrlEncoded
    @POST(HttpUrl.LOGIN)
    Observable<BaseResult<LoginBean>> login(@Field("CellPhone") String phone, @Field("Password") String Password
            , @Field("UserName") String UserName, @Field("Cn") String cn);*/


}
