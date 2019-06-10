package com.sample.comcast.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.comcast.moviesapp.R;
import com.sample.comcast.model.RelatedTopic;
import com.sample.comcast.view.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

import static android.support.constraint.Constraints.TAG;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>
        implements Filterable {

    private Context context;
    private ArrayList<RelatedTopic> data;
    private ArrayList<RelatedTopic> dataFiltered;


    public DataAdapter(Context context, ArrayList<RelatedTopic> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.characterText.setText(data.get(position).getText());


    }

    @Override
    public int getItemCount() {

        return data.size();
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {

        public TextView characterText;


        public DataViewHolder(View itemView) {
            super(itemView);

            characterText = itemView.findViewById(R.id.text_character);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        RelatedTopic selectedCharacter = data.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("main_data", selectedCharacter);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        String charText = selectedCharacter.getText();
                        Toast.makeText(view.getContext(), charText, Toast.LENGTH_LONG).show();
                        context.startActivity(intent);
                    }

                }
            });
        }
    }


    private DisposableObserver<List<RelatedTopic>> getSearchObserver() {
        return new DisposableObserver<List<RelatedTopic>>() {
            @Override
            public void onNext(List<RelatedTopic> contacts) {
                data.clear();
                data.addAll(contacts);
//                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    dataFiltered = data;
                } else {
                    ArrayList<RelatedTopic> filteredList = new ArrayList<>();
                    for (RelatedTopic item : data) {

                        if (item.getText().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }

                    dataFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = dataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                dataFiltered = (ArrayList<RelatedTopic>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
