package com.alisafarzadeh.rejimghazaei.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    static Retrofit retrofit;
    static String baseURL="http://192.168.1.5/";
    public static Retrofit getRetrofit()
    {

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
