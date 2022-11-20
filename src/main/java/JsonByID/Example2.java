package JsonByID;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Example2 {
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private Rating [] ratings;
    private String metascore;
    private String imdbvotes;
    private String imdbrating;
    private String imdbid;
    private String type;
    private String dvd;
    private String boxoffice;
    private String production;
    private String website;
    private String response;
    private String totalSeasons;

    @JsonProperty("totalSeasons")
    public String getTotalSeasons() {
        return totalSeasons;
    }

    public StringBuilder getPlot2 (){
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < plot.length(); i++) {
            if(i%60==0){
                stringBuilder.append("\n");
            }
            stringBuilder.append(String.valueOf(plot.charAt(i)));
        }
        return stringBuilder;
    }

    @Override
    public String toString() {
        return "Название фильма: " + title + '\n' +
                "Год выпуска: " + year + '\n' +
                "Rated: " + rated + '\n' +
                "Дата выпуска: " + released + '\n' +
                "Продолжительность: " + runtime + '\n' +
                "Жанр: " + genre + '\n' +
                "Режиссер: " + director + '\n' +
                "Сценарист: " + writer + '\n' +
                "В главных ролях: " + actors + '\n' +
                "Сюжет: " + getPlot2() + '\n' +
                "Язык: " + language + '\n' +
                "Страна: " + country + '\n' +
                "Награды: " + awards + '\n' +
                "Ссылка на постер: " + poster + '\n' +
                "Рейтинги: " + Arrays.toString(ratings) +'\n'+
                "ID: " + imdbid + '\n' +
                "Тип: " + type + '\n' +
                "Выход на dvd: " + dvd + '\n' +
                "Выручка денег: " + boxoffice + '\n' +
                "Расход на производство: " + production + '\n' +
                "Сайт: " + website + '\n';
    }
    @JsonProperty("imdbVotes")
    public String getImdbvotes() {
        return imdbvotes;
    }
    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("Year")
    public String getYear() {
        return year;
    }
    @JsonProperty("Rated")
    public String getRated() {
        return rated;
    }
    @JsonProperty("Released")
    public String getReleased() {
        return released;
    }
    @JsonProperty("Runtime")
    public String getRuntime() {
        return runtime;
    }
    @JsonProperty("Genre")
    public String getGenre() {
        return genre;
    }
    @JsonProperty("Director")
    public String getDirector() {
        return director;
    }
    @JsonProperty("Writer")
    public String getWriter() {
        return writer;
    }
    @JsonProperty("Actors")
    public String getActors() {
        return actors;
    }
    @JsonProperty("Plot")
    public String getPlot() {
        return plot;
    }
    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }
    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }
    @JsonProperty("Awards")
    public String getAwards() {
        return awards;
    }

    @JsonProperty("Poster")
    public String getPoster() {
        return poster;
    }
    @JsonProperty("Ratings")
    public Rating[] getRatings() {
        return ratings;
    }
    @JsonProperty("Metascore")
    public String getMetascore() {
        return metascore;
    }
    @JsonProperty("imdbRating")
    public String getImdbrating() {
        return imdbrating;
    }
    @JsonProperty("imdbID")
    public String getImdbid() {
        return imdbid;
    }
    @JsonProperty("Type")
    public String getType() {
        return type;
    }
    @JsonProperty("DVD")
    public String getDvd() {
        return dvd;
    }
    @JsonProperty("BoxOffice")
    public String getBoxoffice() {
        return boxoffice;
    }
    @JsonProperty("Production")
    public String getProduction() {
        return production;
    }
    @JsonProperty("Website")
    public String getWebsite() {
        return website;
    }
    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }
}
