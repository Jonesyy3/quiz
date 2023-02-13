package quizApi.springbootrestapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DisneyCharacterModel {
    public List<String> films;
    public List<String> shortFilms;
    public List<String> tvShows;
    public List<String> videoGames;
    public List<String> parkAttractions;
    public List<Object> allies;
    public List<Object> enemies;
    public int _id;
    public String name;
    public String imageUrl;
    public String url;

    @JsonProperty("films")
    public List<String> getFilms() {
        return this.films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }


    @JsonProperty("shortFilms")
    public List<String> getShortFilms() {
        return this.shortFilms;
    }

    public void setShortFilms(List<String> shortFilms) {
        this.shortFilms = shortFilms;
    }


    @JsonProperty("tvShows")
    public List<String> getTvShows() {
        return this.tvShows;
    }

    public void setTvShows(List<String> tvShows) {
        this.tvShows = tvShows;
    }


    @JsonProperty("videoGames")
    public List<String> getVideoGames() {
        return this.videoGames;
    }

    public void setVideoGames(List<String> videoGames) {
        this.videoGames = videoGames;
    }


    @JsonProperty("parkAttractions")
    public List<String> getParkAttractions() {
        return this.parkAttractions;
    }

    public void setParkAttractions(List<String> parkAttractions) {
        this.parkAttractions = parkAttractions;
    }


    @JsonProperty("allies")
    public List<Object> getAllies() {
        return this.allies;
    }

    public void setAllies(List<Object> allies) {
        this.allies = allies;
    }


    @JsonProperty("enemies")
    public List<Object> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(List<Object> enemies) {
        this.enemies = enemies;
    }


    @JsonProperty("_id")
    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @JsonProperty("url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

