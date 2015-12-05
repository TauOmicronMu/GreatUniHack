package com.aranscope;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aranscope on 05/12/15.
 */
public class Server {
    public Color getColor(){
        Color trace = Color.decode("0xffffff");
        try{
            trace = Color.decode(getHTML("http://drone.bk.wtf/color"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return trace;
    }
    
    private String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
