package com.app.moviedbt;
import  retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {
    private  static  Retrofit retrofit;
    private static final String BASEURL = "https://my-json-server.typicode.com/horizon-code-academy/fake-movies-api/";

    public static Retrofit getRetrofit() {

        if(retrofit == null){
            retrofit  = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
