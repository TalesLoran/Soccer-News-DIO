package me.dio.soccernewsdio.data;


import androidx.room.Room;

import me.dio.soccernewsdio.App;
import me.dio.soccernewsdio.data.local.SoccerNewsDb;
import me.dio.soccernewsdio.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://talesloran.github.io/soccer-news-api/";
    private static final String LOCAL_DO_NAME = "soccer-news-dio";
    //endregion

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room),
    private SoccerNewsApi remoteApi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi() {return remoteApi;}

    public SoccerNewsDb getLocalDb() {return localDb;}
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DO_NAME).build();
        }
        public static SoccerNewsRepository getInstance() {return  LazyHolder.INSTANCE;}

        private static class LazyHolder {
            private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
        }
        //endregion
}
