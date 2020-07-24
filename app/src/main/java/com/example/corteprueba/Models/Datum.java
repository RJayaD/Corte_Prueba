package com.example.corteprueba.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datum {
    private String name;
    private String alpha2Code;

    public Datum(JSONObject a)throws JSONException {
        name = a.getString("name").toString();
        alpha2Code = "http://www.geognos.com/api/en/countries/flag/"+a.getString("alpha2Code").toString()+".png";
                //a.getString("alpha2Code").toString();

    }

    public static ArrayList<Datum> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Datum> data = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            data.add(new Datum(datos.getJSONObject(i)));
        }
        return data;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlpha2Code() {
        return alpha2Code;
    }
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }



}
