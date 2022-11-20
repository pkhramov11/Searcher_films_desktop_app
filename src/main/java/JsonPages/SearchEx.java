package JsonPages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchEx {
    private String title;
    private String year;
    private String imdbid;
    private String type;
    private String poster;

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("Year")
    public String getYear() {
        return year;
    }
    @JsonProperty("imdbID")
    public String getImdbid() {
        return imdbid;
    }
    @JsonProperty("Type")
    public String getType() {
        return type;
    }
    @JsonProperty("Poster")
    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "Название: "+"\n" + title + '\n' +
                "Год: " + year + '\n' +
                "ID: " + imdbid + '\n' +
                "Тип: " + type + '\n';
    }
}
