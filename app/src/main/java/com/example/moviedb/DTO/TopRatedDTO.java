package com.example.moviedb.DTO;



public class TopRatedDTO  {
    private int id;
    private String title;
    private String releaseDate;
    private String posterPath;
    public TopRatedDTO(int id, String title,String releaseDate,String posterPath)
    {
        this.id= id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

}
