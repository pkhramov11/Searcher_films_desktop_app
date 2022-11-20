package JsonIfBadRequest;

import Main.MainRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Example3 {


    private String response;
    private String error;
    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }
    @JsonProperty("Error")
    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "Вашего запроса нет в базе данных";
    }
}
