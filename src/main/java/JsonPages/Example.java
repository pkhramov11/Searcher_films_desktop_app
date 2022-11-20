package JsonPages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Example {
    private SearchEx [] search;

    private String totalresults;
    private String response;

//    public SearchEx [] showSearchEx(){
//        for (SearchEx emp :
//                search) {
//            System.out.println();
//        }
//    }
//    public void toStringSearch(){
//        System.out.println("Найдено: "+"\n"+"\n");
//        for (SearchEx ex :
//                search ) {
//            System.out.println(ex.toString());
//            System.out.println("------------------------------------------------");
//        }
//        System.out.println("\n");
//        System.out.println("Всего найдено: "+ totalresults
//        );
//    }
public String toStringSearch(){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Найдено: "+"\n"+"\n");
    for (SearchEx ex :
            search ) {
        stringBuilder.append(ex.toString());
        stringBuilder.append("------------------------------------------------"+"\n");
    }
    stringBuilder.append("\n");
    stringBuilder.append("Всего найдено: "+ totalresults
    );
    return stringBuilder.toString();
}


    @Override
    public String toString() {
        return "Example{" +
                "search=" + Arrays.toString(search) +
                ", totalresults='" + totalresults + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

    public static String returnTitle (Example ex){
        String returnStr="";
        for (SearchEx searchEx:
             ex.getSearch()) {
            returnStr=searchEx.getTitle();
        }
        return returnStr;
    }
    @JsonProperty("totalResults")
    public String getTotalresults() {
        return totalresults;
    }
    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }
    @JsonProperty("Search")
    public SearchEx[] getSearch() {
        return search;
    }
}
