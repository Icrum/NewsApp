package com.example.noticias;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {

    String title;
    String description;
    String url;
    String urlToImage;

    public Post(String title, String description, String url, String urlToImage) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public Post() {
        this.title = "";
        this.description = "";
        this.url = "";
        this.urlToImage = "";
    }


    public static Post parseJson(JSONObject jsonObject){
        Post post = new Post();
        try {
            post.title = jsonObject.getString("title");
            post.description = jsonObject.getString("description");
            post.url = jsonObject.getString("url");
            post.urlToImage = jsonObject.getString("urlToImage");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return post;
    }
}
