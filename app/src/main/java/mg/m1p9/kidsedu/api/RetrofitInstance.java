package mg.m1p9.kidsedu.api;

import mg.m1p9.kidsedu.model.SignInBody;
import mg.m1p9.kidsedu.model.User;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface ApiInterface {

    @Headers("Content-Type:application/json")
    @POST("Connexion")
    retrofit2.Call<ResponseBody> signin(@Body SignInBody info);

    @Headers("Content-Type:application/json")
    @POST("Inscription")
    retrofit2.Call<ResponseBody> registerUser(@Body User info);
}

class RetrofitClient {

        String BASE_URL = "http://kidseducation.herokuapp.com/";

       /* HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor().apply({
            this.level = HttpLoggingInterceptor.Level.BODY;
        }

        OkHttpClient client  = new OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        Retrofit getRetrofitInstance() {
            return new Retrofit().newBuilder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }*/

}