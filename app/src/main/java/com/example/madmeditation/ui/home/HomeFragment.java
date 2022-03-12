package com.example.madmeditation.ui.home;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.common.adapter.FeelingsAdapter;
import com.example.madmeditation.common.adapter.QuotesAdapter;
import com.example.madmeditation.network.mApiService;

import com.example.madmeditation.R;
import com.example.madmeditation.common.MyDialog;
import com.example.madmeditation.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    List<Quotes> quotesList = new ArrayList<>();
    List<Feelings> feelingsList = new ArrayList<>();
    MyDialog dialog = new MyDialog(requireActivity());

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        LinearLayoutManager l =
        new LinearLayoutManager(requireContext());
        l.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.quote.setLayoutManager(l);
        binding.quote.setAdapter(new QuotesAdapter(requireContext(), quotesList));
        homeViewModel.getQuotes().observe(getViewLifecycleOwner(), quotes -> ((QuotesAdapter)binding.quote.getAdapter()).setLocalDataSet(quotes));
        binding.feelings.setAdapter(new FeelingsAdapter(feelingsList));
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadQuotes();

        //dialog.CreateDialog("","").show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void loadQuotes(){
        mApiService.getInstance().getApi().getQuotes().enqueue(new Callback<List<Quotes>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<Quotes>> call, Response<List<Quotes>> response) {
                if(response.isSuccessful()){
                    switch (response.code()){
                        case 200: {
                            dialog.CreateDialog("Успех",String.valueOf(response.body().size())).show();
                            quotesList = response.body();
                            /*QuotesAdapter adapter =
                            (QuotesAdapter)binding.quote.getAdapter();
                            adapter.setLocalDataSet(quotesList);
                            adapter.notifyDataSetChanged();*/
                        }break;
                        case 300:{

                        }break;
                    }
                }
                else{
                    dialog.CreateDialog("Неполадки",response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<List<Quotes>> call, Throwable t) {
                dialog.CreateDialog("Неполадки",t.getStackTrace().toString());
            }
        });
    }
    void loadFeelings(){
        mApiService.getInstance().getApi().getFeelings().enqueue(new Callback<List<Feelings>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<Feelings>> call, Response<List<Feelings>> response) {
                if(response.isSuccessful()){
                    switch (response.code()){
                        case 200: {
                            dialog.CreateDialog("Успех",String.valueOf(response.body().size())).show();
                            feelingsList = response.body();
                            final FeelingsAdapter adapter =
                                    (FeelingsAdapter)binding.feelings.getAdapter();
                            adapter.setLocalDataSet(feelingsList);
                            adapter.notifyDataSetChanged();
                        }break;
                        case 300:{

                        }break;
                    }
                }
                else{
                    dialog.CreateDialog("Неполадки",response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<List<Feelings>> call, Throwable t) {
                dialog.CreateDialog("Неполадки",t.getStackTrace().toString());
            }
        });
    }
}