package com.alisafarzadeh.rejimghazaei.Retrofit;

import com.alisafarzadeh.rejimghazaei.Adapters.Article;
import com.alisafarzadeh.rejimghazaei.Adapters.QuizItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApi {

    @GET("Stevia/new1.php")
    Call<List<Article>> getArticle();


    @FormUrlEncoded
    @POST("Stevia/savemessage.php")
    Call<String> IsSend(@Field("userid") String user,
                         @Field("msg") String message);

    @FormUrlEncoded
    @POST("Stevia/getmessage.php")
    Call<List<QuizItem>> getMessage(@Field("userid") String user);


}
