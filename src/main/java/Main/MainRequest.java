package Main;


import JsonByID.Example2;
import JsonIfBadRequest.Example3;
import JsonPages.*;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainRequest {
    public volatile static String nameOfFilm = "";
    public volatile static String ID = "";
    public volatile static String file = "";
    public volatile static String page = "";



//    public static String requestHttp = "https://www.omdbapi.com/?apikey=31f17c97&s="+nameOfFilm;


    public static String finalMethod() {
        StringBuilder stringBuilder = new StringBuilder();
        Example example = null;
        Example3 example2 = null;
        try {
            SaveJson(GetRequestJson("https://www.omdbapi.com/?apikey=31f17c97&s=" + nameOfFilm),
                    new File("test2.json"));

            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File("test2.json")));
            String result = bufferedReader.readLine();
            if (result.contains("Error")) {
                example2 = createObjectFromJsonIfError(new File("test2.json"), Example3.class);
                stringBuilder.append(example2.toString());
            } else {
                example = createObjectFromJson(new File("test2.json"), Example.class);
                stringBuilder.append(example.toStringSearch());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String finalMethodPage() {
        StringBuilder stringBuilder = new StringBuilder();
        Example example = null;
        Example3 example2 = null;
        try {
            SaveJson(GetRequestJson("https://www.omdbapi.com/?apikey=31f17c97&s=" + nameOfFilm+"&page="+page),
                    new File("test2.json"));

            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File("test2.json")));
            String result = bufferedReader.readLine();
            if (result.contains("Error")) {
                example2 = createObjectFromJsonIfError(new File("test2.json"), Example3.class);
                stringBuilder.append(example2.toString());
            } else {
                example = createObjectFromJson(new File("test2.json"), Example.class);
                stringBuilder.append(example.toStringSearch());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String finalMethodByID() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
//        File file = new File("test4.json");
//        Example3 example3 = null;
//
//        try {
//            SaveJson(GetRequestJson("https://www.omdbapi.com/?apikey=31f17c97&i=" + ID+"&plot=full"),
//                    file);
//
//
////            SavePoster(GetRequestJsonForPicture("https://www.omdbapi.com/?apikey=31f17c97&i=" + ID+"&plot=full"),
////                    new File("Data/poster.jpg"));
//
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            String result = bufferedReader.readLine();
//            if(result.contains("Error")){
//                example2 = createObjectFromJsonIfError(new File("test4.json"), Example3.class);
//                stringBuilder.append(example2.toString());
//
//
//            }
//            else{
//                example = createObjectFromJsonID(new File("test4.json"), Example2.class);
//
//                stringBuilder.append(example.toString());
//

//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }

//        String a = GetRequestJsonForPicture("https://www.omdbapi.com/?apikey=31f17c97&i=" + ID + "&plot=full");
//
//         ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                example = objectMapper.readValue(a, Example2.class);
//                while(example==null){
//                    a = GetRequestJsonForPicture("https://www.omdbapi.com/?apikey=31f17c97&i=" + ID + "&plot=full");
//                    example = objectMapper.readValue(a, Example2.class);
//                }

//
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        if (example != null) {
//            stringBuilder.append(example.toString());
//        } else {
//            stringBuilder.append("Проблема с соединением");
//        }


        Example2 example = null;
        Example3 example2 = null;
        String result = "";
        try {
            do{SaveJson(GetRequestJson("https://www.omdbapi.com/?apikey=31f17c97&i=" + ID+"&plot=full"),
                    new File("test4.json"));


            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File("test4.json")));
            result = bufferedReader.readLine();}
            while (result==null);
            if (result.contains("Error")) {
                example2 = createObjectFromJsonIfError(new File("test4.json"), Example3.class);
                stringBuilder.append(example2.toString());
            } else {
                example = createObjectFromJsonID(new File("test4.json"), Example2.class);
                double a1 = Math.random();
                downloadFiles(example.getPoster(),"photoPosterForProject"+String.valueOf(a1)+".jpg", 1);
                stringBuilder.append(example.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1");
        }


        return stringBuilder.toString();

    }



    public static String GetRequestJson(String example){

        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        try{
            connection =(HttpURLConnection) new URL(example).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            connection.connect();

            if(HttpURLConnection.HTTP_OK==connection.getResponseCode()){
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(connection.getInputStream()));

                String line;
                while((line=reader.readLine())!=null){
                    sb.append(line);
                    sb.append("\n");
                }

            }
            else {
                System.out.println("fail"+connection.getResponseCode()
                        +", " +connection.getResponseMessage());
            }
        }
        catch (Exception e){

        }
        finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return sb.toString();
    }

    public static String GetRequestJsonForPicture(String example){

        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        try{
            connection =(HttpURLConnection) new URL(example).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            connection.connect();

            if(HttpURLConnection.HTTP_OK==connection.getResponseCode()){
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(connection.getInputStream()));

                String line;
                while((line=reader.readLine())!=null){
                    sb.append(line);
                    sb.append("\n");
                }

            }
            else {
                System.out.println("fail"+connection.getResponseCode()
                        +", " +connection.getResponseMessage());
            }



        }
        catch (Exception e){

        }
        finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return sb.toString();
    }



    public static void downloadFiles(String strURL, String strPath, int buffSize)  {
        try {
            URL connection = new URL(strURL);
            HttpURLConnection urlconn;
            urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();
            InputStream in = null;
            in = urlconn.getInputStream();
            OutputStream writer = new FileOutputStream(strPath);
            byte buffer[] = new byte[buffSize];
            int c = in.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = in.read(buffer);
            }
            file = strPath;
            writer.flush();
            writer.close();
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    public static void SaveJson (String json, File file){
        BufferedWriter bufferedWriter = null;
        try {

            bufferedWriter =
                    new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void SavePoster (String json, File file){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            fileInputStream = new FileInputStream(json);
            fileOutputStream = new FileOutputStream(file);

            int i;

            while ((i=fileInputStream.read())!=-1){
                fileOutputStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static Example createObjectFromJson (File file, Class<Example> ex){
        ObjectMapper objectMapper = new ObjectMapper();
        Example3 object2 = null;
        Example object = null;
        try {
            object = objectMapper.readValue(file,
                    ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static Example2 createObjectFromJsonID (File file, Class<Example2> ex){
        ObjectMapper objectMapper = new ObjectMapper();

        Example2 object = null;
        try {
            object = objectMapper.readValue(file,
                    ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static Example3 createObjectFromJsonIfError (File file, Class<Example3> ex){
        ObjectMapper objectMapper = new ObjectMapper();
        Example3 object = null;
        try {
            object = objectMapper.readValue(file,
                    ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(object==null){
                System.out.println("1");
            }
        }
        return object;
    }



    public static Example2 createObjectFromJson2 (File file, Class<Example2> ex){
        ObjectMapper objectMapper = new ObjectMapper();
        Example2 object = null;
        try {
            object = objectMapper.readValue(file,
                    ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void deleteAllFilesOnClose(File folder){
        File [] files = folder.listFiles();
        List<File>list = new ArrayList<>();
        list.addAll(Arrays.asList(files));
        for (File file :
                files) {
            if(file.getName().contains("photoPosterForProject") ||
                    file.getName().contains("test4.json") ||
                    file.getName().contains("test2.json") ||
                    file.getName().contains("test3.json")
            ){
                file.delete();
            }

        }
        System.out.println(Arrays.toString(files));


    }



    public static void main(String[] args) throws IOException {


        JFrame jFrame = new JFrame();
        jFrame.add(new Form().getjPanel());
        jFrame.setSize(800, 600);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                File file = new File(System.getProperty("user.dir"));
                deleteAllFilesOnClose(file);
                deleteAllFilesOnClose(file);
                deleteAllFilesOnClose(file);
                deleteAllFilesOnClose(file);
            }
        });

    }
}
