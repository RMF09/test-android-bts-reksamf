package com.rmf.testingid;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiInterface {
//    @GET("auth")
//    Call<GetKontak> getKontak();


    @POST("login")
    Call<LoginResult> login(@Body LoginData body);
    @POST("Register")
    Call<LoginResult> register(@Body Register body);

}
