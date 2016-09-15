package com.firman.tugas;

/**
 * Created by Firmanz on 8/6/2016.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class RequestHandler {
    // Metode untuk mengirim httpPostRequest
    // Metode ini mengambil dua argumen
    // Argumen Pertama adalah URL dari script yang kami akan mengirimkan permintaan
    // Lainnya adalah HashMap dengan nilai pasangan nama yang berisi data yang akan dikirim dengan permintaan

    public String sendPostRequest(String requestURL,
                                  HashMap<String, String> postDataParams) {

    //Creating URL
        URL url;
        //Objek StringBuilder
        StringBuilder sb = new StringBuilder();
        try {

            //Initializing URL
            url = new URL(requestURL);

            //Membuat Koneksi
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            //Konfigurasi Properti
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Make Output
            OutputStream os = conn.getOutputStream();

            //Menulis parameter untuk permintaan
            // Menggunakan Post Data
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if(responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                sb = new StringBuilder();
                String response;
                //Reading server Response
                while ((response = br.readLine()) != null){
                    sb.append(response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String sendGetRequest(String requestURL) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(requestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String s;
            while((s=bufferedReader.readLine())!=null){
                sb.append(s+"\n");
            }
        }catch(Exception e){
        }
        return sb.toString();
    }

    public String sendGetRequestParam(String requestURL, String id) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(requestURL+id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String s;
            while((s = bufferedReader.readLine())!= null) {
                sb.append(s+"\n");
            }
        } catch (Exception e){
    }
        return sb.toString();
    }


    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
    StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));

        }

        return result.toString();
    }
}


