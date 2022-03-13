package com.example.madmeditation.common.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.madmeditation.R;
import com.example.madmeditation.common.Feelings;
import com.example.madmeditation.common.Quotes;
import com.example.madmeditation.databinding.FeelingsViewBinding;
import com.example.madmeditation.databinding.QuotesViewBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeelingsAdapter extends RecyclerView.Adapter<FeelingsAdapter.ViewHolder> {
    Context context;
    private List<Feelings> localDataSet;

    public List<Feelings> getLocalDataSet() {
        return localDataSet;
    }

    public void setLocalDataSet(List<Feelings> localDataSet) {
        this.localDataSet = localDataSet;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        FeelingsViewBinding binding;

        public ViewHolder(FeelingsViewBinding binding) {
            super(binding.getRoot());
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
     *
     * @param localDateSet List<Feelings> containing the data to populate views to be used
     * by RecyclerView.
     */
    public FeelingsAdapter(Context context, List<Feelings> localDateSet) {
        super();
        this.context = context;
        this.localDataSet = localDataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        FeelingsViewBinding binding;
        // Create a new view, which defines the UI of the list item
        binding = FeelingsViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        for(Feelings f : localDataSet){
            if(f.getPosition()-1 == position){
                Picasso.with(context).load(f.getImageUrl()).into(viewHolder.getImageView());
                viewHolder.getTextView().setText(f.getTittle());
                Log.i("DataChanged", "onBindViewHolder: "+f.getTittle());
            }
        }
        /*Picasso.with(context).load(localDataSet.get(position).getImageUrl()).into(viewHolder.getImageView());
        viewHolder.getTextView().setText(localDataSet.get(position).getTittle());*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet == null ? 0 : localDataSet.size();
    }
}