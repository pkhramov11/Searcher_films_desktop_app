package JsonByID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    private String source;
    private String value;
    @JsonProperty("Source")
    public String getSource() {
        return source;
    }
    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return source  +
                " : " + value;
    }
}
