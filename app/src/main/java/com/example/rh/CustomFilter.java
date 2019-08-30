package com.example.rh;

import android.widget.Filter;

import com.example.rh.models.Job;

import java.util.ArrayList;

public class CustomFilter extends Filter {
        JobAdapter adapter;
        ArrayList<Job> filterList;
        public CustomFilter(ArrayList<Job> filterList, JobAdapter adapter)
        {
            this.adapter=adapter;
            this.filterList=filterList;
        }
        //FILTERING OCURS
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            //CHECK CONSTRAINT VALIDITY
            if(constraint != null && constraint.length() > 0)
            {
                //CHANGE TO UPPER
                constraint=constraint.toString().toUpperCase();
                //STORE OUR FILTERED PLAYERS
                ArrayList<Job> filteredPlayers=new ArrayList<>();
                for (int i=0;i<filterList.size();i++)
                {
                    //CHECK
                    if(filterList.get(i).getLabel().toUpperCase().contains(constraint))
                    {
                        //ADD PLAYER TO FILTERED PLAYERS
                        filteredPlayers.add(filterList.get(i));
                    }
                }
                results.count=filteredPlayers.size();
                results.values=filteredPlayers;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.mJob= (ArrayList<Job>) results.values;
            //REFRESH
            adapter.notifyDataSetChanged();

}
    }
