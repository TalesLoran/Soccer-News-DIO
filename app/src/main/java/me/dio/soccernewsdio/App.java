package me.dio.soccernewsdio;

import android.app.Application;

/**
 * Estudar injeção de dependências (Dagger e ou Hilt).
 * (Fiz tentativas com abas bibliotecas, não obtive sucesso, o App não rodava.)
 * (Farei mais tentavivas posteriormente.)
 */

public class App extends Application {

    private static App instance;

    public static App getInstance(){return instance;}

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
    }
}
