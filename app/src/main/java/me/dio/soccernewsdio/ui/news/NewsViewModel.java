package me.dio.soccernewsdio.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernewsdio.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {

        this.news = new MutableLiveData<>();

        //TODO remover Mock de Notícias
        List<News>news = new ArrayList<>();
        news.add(new News("Ferroviaria Tem Desfalque Importante", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."));
        news.add(new News("Ferrinha Joga no Sábado", " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"));
        news.add(new News("Copa do Mundo Feminina Está Terminando", " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}