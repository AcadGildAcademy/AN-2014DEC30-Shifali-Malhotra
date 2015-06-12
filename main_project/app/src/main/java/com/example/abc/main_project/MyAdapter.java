package com.example.abc.main_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abc on 6/12/2015.
 */
public class MyAdapter extends BaseAdapter {
    private Activity activity;
    private static LayoutInflater inflater=null;
    private ArrayList<HashMap<String, String>> movieList=new ArrayList<HashMap<String,String>>();



    public MyAdapter(Activity a, ArrayList<HashMap<String, String>> movieList) {
        activity = a;
        this.movieList = movieList;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    public int getCount() { return movieList.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{

        public TextView name;
        public TextView date;


        public RatingBar ratingBar;



    }
@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;
        ViewHolder holder;

        if(convertView==null){

            vi = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.name = (TextView) vi.findViewById(R.id.name);
            holder.date=(TextView)vi.findViewById(R.id.date);


            holder.ratingBar=(RatingBar)vi.findViewById(R.id.rating_movie);



            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

    holder.name .setText(movieList.get(position).get(main_activity.TAG_TITLE));
    holder.date.setText("Released on : "+movieList.get(position).get(main_activity.TAG_RELEASE_DATE));


        holder.ratingBar.setRating(Float.parseFloat(movieList.get(position).get(main_activity.TAG_RATING))/2);



        return vi;
    }

}
