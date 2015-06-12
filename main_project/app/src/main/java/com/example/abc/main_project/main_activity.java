package com.example.abc.main_project;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
//http://api.themoviedb.org/3/movie/popular?api_key=8496be0b2149805afa458ab8ec27560c
//http://jsonformatter.curiousconcept.com/

/**
 * Created by abc on 6/3/2015.
 */
public class main_activity extends ListActivity {

    private ProgressDialog pDialog;

 ListView lv;

    private static String url = "http://api.themoviedb.org/3/movie/popular?api_key=8496be0b2149805afa458ab8ec27560c";
    // JSON Node names
    static final String TAG_RESULT="results";
  static final String TAG_ID = "id";

 static final String TAG_TITLE = "title";
   static final String TAG_RELEASE_DATE = "release_date";
     static final String TAG_POPULARITY="popularity";
     static final String TAG_RATING="vote_average";
    JSONArray results=null;

    /* Hashmap for ListView */
    ArrayList<HashMap<String,String>> movie_list;

    public main_activity() {
        movie_list = new ArrayList<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       lv = getListView();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

               /* String name = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                String date = ((TextView) view.findViewById(R.id.date))
                        .getText().toString();
                RatingBar rating=(RatingBar)view.findViewById(R.id.rating_movie);*/


                Intent in = new Intent(getApplicationContext(),Singlemovieactivity.class);
                in.putExtra(TAG_TITLE, movie_list.get(position).get(TAG_TITLE));
                in.putExtra(TAG_RELEASE_DATE,movie_list.get(position).get(TAG_RELEASE_DATE));

                startActivity(in);

            }
        });

        new Getresults().execute();
    }

    private class Getresults extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(main_activity.this);
            pDialog.setMessage("Please wait...");
                      pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            service_handler sh = new service_handler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, service_handler.GET);

            Log.d("Response: ", "> " + jsonStr);

            HashMap<String, String> result;
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);


                    results = jsonObj.getJSONArray(TAG_RESULT);


                    for (int i = 0; i < results.length(); i++) {
                        JSONObject m = results.getJSONObject(i);

                        String id = m.getString(TAG_ID);
                        String name = m.getString(TAG_TITLE);
                        String date = m.getString(TAG_RELEASE_DATE);
                        String rating=m.getString(TAG_RATING);

        //retrieve rating value and assign the int variable and divide by 2

                        result = new HashMap<String, String>();
                        result.put(TAG_ID, id);
                        result.put(TAG_TITLE, name);
                        result.put(TAG_RELEASE_DATE, date);
                        result.put(TAG_RATING,rating);
                        ///assign rating value to hash map object reference

                        movie_list.add(result);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {

                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

@Override
            protected void onPostExecute (Void res){
                super.onPostExecute(res);
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

               /* ListAdapter adapter = new SimpleAdapter(
                        main_activity.this, movie_list,
                        R.layout.list_item, new String[]{TAG_TITLE, TAG_RELEASE_DATE, String.valueOf(TAG_RATING)  //Have rating Tag defined here too
                }, new int[]{
                        R.id.name, R.id.date,R.id.rating_movie}); //add rating id

                setListAdapter(adapter);*/
    MyAdapter adapter=new MyAdapter(main_activity.this,movie_list);
    lv.setAdapter(adapter);


}

        }

}
