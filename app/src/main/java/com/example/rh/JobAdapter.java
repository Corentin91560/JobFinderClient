package com.example.rh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rh.models.Job;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_job_offer, viewGroup, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Job contact = mJob.get(i);

        // Set item views based on your views and data model
        TextView labeltv = viewHolder.labeljobTV;
        labeltv.setText(contact.getLabel());


    }

    @Override
    public int getItemCount() {
        return mJob.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView labeljobTV;
        public TextView locateTV;
        public TextView CompagnieNameTV;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            labeljobTV = (TextView) itemView.findViewById(R.id.labelJobTV);
            locateTV = (TextView) itemView.findViewById(R.id.locateTV);
            CompagnieNameTV = (TextView) itemView.findViewById(R.id.CompagnieNameTV);
        }
    }
    private List<Job> mJob;

    // Pass in the contact array into the constructor
    public JobAdapter(List<Job> contacts) {
        mJob = contacts;
    }

}
