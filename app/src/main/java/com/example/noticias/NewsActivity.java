package com.example.noticias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {


    List<Post> posts=new ArrayList<>();

    ListView listView;

    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        listView = findViewById(R.id.listViewPosts);

        adapter= new PostsAdapter();

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),NewsOnCLICK.class);
                intent.putExtra("Title",posts.get(position).title);
                intent.putExtra("Description",posts.get(position).description);
                intent.putExtra(NewsOnCLICK.URL_POST, posts.get(position).url);
                startActivity(intent);
            }
        });

        Intent intent=getIntent();
        final String value= intent.getStringExtra("category");


        String categoria = value;
        String url= "https://newsapi.org/v2/top-headlines?category="+categoria+"&language=pt&country=pt&apiKey=1aee768fcfe945e9bc8e8a689668ec67";

        VolleyHelper.getAllData(this, url, new VolleyHelper.OnGetAllDataListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    if (jsonObject.getString("status").compareTo("ok") == 0) {
                        //Log.d("Noticias",jsonObject.toString());

                        JSONArray jsonArray = jsonObject.getJSONArray("articles");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            Post post = Post.parseJson((JSONObject) jsonArray.get(i));
                            posts.add(post);
                        }
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public class PostsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return posts.size();
        }

        @Override
        public Object getItem(int position) {
            return posts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_post,null);
            TextView textViewTitle = view.findViewById(R.id.textViewTitle);
            TextView textViewDescription = view.findViewById(R.id.textViewDiscription);
            ImageView imageView=view.findViewById(R.id.imageView);
            textViewTitle.setText(posts.get(position).title);
            textViewDescription.setText(posts.get(position).description);
            //loadImageFromUrl(urlToImage);
            Picasso.with(NewsActivity.this).load(posts.get(position).urlToImage).into(imageView);

            return view;
        }
    }
}
