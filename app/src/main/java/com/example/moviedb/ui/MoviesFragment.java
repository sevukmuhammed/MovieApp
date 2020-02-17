package com.example.moviedb.ui;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.moviedb.Api.APIService;
import com.example.moviedb.Api.Const;
import com.example.moviedb.adapter.MoviesAdapter;
import com.example.moviedb.model.TopRated;
import com.example.moviedb.model.VeriListem;
import com.example.moviedb.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private List<TopRated> dat;
    public RecyclerView recyclerView;
    Context context;
    private MoviesAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.top_rated);
        getAtenciones();

        return rootView;
    }

    public void getAtenciones() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        APIService apis = retrofit.create(APIService.class);
        Call<VeriListem> call = apis.verilerimilistele();
        call.enqueue(new Callback<VeriListem>() {
            @Override
            public void onResponse(Call<VeriListem> call, Response<VeriListem> response) {
                List<TopRated> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies,context));
                recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onFailure(Call<VeriListem> call, Throwable t) {
                Log.d("snow", "asda");
            }
        });
    }
}

