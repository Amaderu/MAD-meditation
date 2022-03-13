package com.example.mad_meditationtv;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.example.mad_meditationtv.databinding.ActivityMainBinding;
import com.example.mad_meditationtv.databinding.ActivitySignInBinding;
import com.example.mad_meditationtv.databinding.FragmentMainBinding;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    /*ActivityMainBinding binding;*/
    FragmentMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }*/
    }
}