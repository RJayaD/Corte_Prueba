package com.example.corteprueba.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datum {
    private String name;
    private String alpha2Code;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlpha2Code() {
        String data= " http://www.geognos.com/api/en/countries/flag/"+alpha2Code+".png";
        return alpha2Code;
    }
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }



}
