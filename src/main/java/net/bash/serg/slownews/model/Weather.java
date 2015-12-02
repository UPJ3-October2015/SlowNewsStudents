package net.bash.serg.slownews.model;

import java.util.List;

/**
 * Created by serega on 24.11.2015.
 */
public class Weather {
    private List <String> coord;
    private List <String> weather;
    private String base;
    private List <String> main;
    private List <String> wind;
    private List <String> clouds;
    private String dt;
    private List <String> sys;
    private String id;
    private String name;
    private String code;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCoord() {
        return coord;
    }

    public void setCoord(List<String> coord) {
        this.coord = coord;
    }

    public List<String> getWeather() {
        return weather;
    }

    public void setWeather(List<String> weather) {
        this.weather = weather;
    }

    public List<String> getMain() {
        return main;
    }

    public void setMain(List<String> main) {
        this.main = main;
    }

    public List<String> getWind() {
        return wind;
    }

    public void setWind(List<String> wind) {
        this.wind = wind;
    }

    public List<String> getClouds() {
        return clouds;
    }

    public void setClouds(List<String> clouds) {
        this.clouds = clouds;
    }

    public List<String> getSys() {
        return sys;
    }

    public void setSys(List<String> sys) {
        this.sys = sys;
    }
}