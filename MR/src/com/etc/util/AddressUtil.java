package com.etc.util;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class AddressUtil {


    public static String getAddress(String ip) throws MalformedURLException, IOException, JSONException {
       InputStream is = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+ip).openStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1){
                sb.append((char) cp);
            }
            String jsonText =sb.toString();
            JSONObject json = new JSONObject(jsonText);
            return (String)((JSONObject)json.get("data")).get("region");
        } finally {
            is.close();
        }
    }
}