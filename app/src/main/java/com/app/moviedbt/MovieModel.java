package com.app.moviedbt;

public class MovieModel {
    private String Title;
    private String Runtime;
    private String Poster;

    public MovieModel(String title, String runtime, String poster) {
        Title = title;
        Runtime = runtime;
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
