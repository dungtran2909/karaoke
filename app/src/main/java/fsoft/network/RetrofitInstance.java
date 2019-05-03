package fsoft.network;



import java.util.List;

import fsoft.model.Music;
import fsoft.model.Post;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://www.mocky.io/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public interface GetKaratDataService {
        @GET("v2/5c8dd349310000672b4c2715")
        Call<List<Music>> getKaraData();
    }
}
