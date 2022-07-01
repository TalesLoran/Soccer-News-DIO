package me.dio.soccernewsdio.ui.favorites;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import me.dio.soccernewsdio.data.SoccerNewsRepository;
import me.dio.soccernewsdio.databinding.FragmentFavoritesBinding;
import me.dio.soccernewsdio.domain.News;
import me.dio.soccernewsdio.ui.adpters.NewsAdapter;

public class FavoritesViewModel extends ViewModel {

    private FragmentFavoritesBinding binding;


    public FavoritesViewModel() {
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }


    public void saveNews(News news){
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}