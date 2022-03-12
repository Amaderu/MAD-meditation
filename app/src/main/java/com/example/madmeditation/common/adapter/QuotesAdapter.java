package com.example.madmeditation.common.adapter;

import android.content.Context;
import android.content.QuickViewConstants;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madmeditation.R;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.databinding.FragmentHomeBinding;
import com.example.madmeditation.databinding.QuotesViewBinding;
import com.example.madmeditation.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {

    Context context;
    private List<Quotes> localDataSet;

    public List<Quotes> getLocalDataSet() {
        return localDataSet;
    }

    public void setLocalDataSet(List<Quotes> localDataSet) {
        this.localDataSet = localDataSet;
        //notifyDataSetChanged();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        QuotesViewBinding binding;

        public ViewHolder(QuotesViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            // Define click listener for the ViewHolder's View
            textView = binding.textView;
            imageView = binding.imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     * @param context Context is require Context
     * @param localDateSet List<Quotes> containing the data to populate views to be used
     * by RecyclerView.
     */
    public QuotesAdapter(Context context, List<Quotes> localDateSet) {
        super();
        this.context = context;
        this.localDataSet = localDataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        QuotesViewBinding binding;
        // Create a new view, which defines the UI of the list item
        binding = QuotesViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Picasso.with(context).load(localDataSet.get(position).getImageUrl()).into(viewHolder.getImageView());
        viewHolder.getTextView().setText(localDataSet.get(position).getTittle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet == null ? 0 : localDataSet.size();
    }
}
