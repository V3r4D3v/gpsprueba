package com.desafio.gps.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GpsData {
    @JsonProperty("loginCode")
    private String loginCode;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("gpsDop")
    private double gpsDop;
    @JsonProperty("speed")
    private double speed;
    @JsonProperty("reportDate")
    private String reportDate;
    @JsonProperty("reportType")
    private String reportType;
    @JsonProperty("gpsSatellites")
    private int gpsSatellites;
    @JsonProperty("heading")
    private int heading;
    @JsonProperty("speedLabel")
    private String speedLabel;
    @JsonProperty("text")
    private String text;
    @JsonProperty("textLabel")
    private String textLabel;

    public GpsData() {}

    public GpsData(String loginCode, double latitude, double longitude, double gpsDop, double speed, String reportDate, String reportType, int gpsSatellites, int heading, String speedLabel, String text, String textLabel) {
        this.loginCode = loginCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gpsDop = gpsDop;
        this.speed = speed;
        this.reportDate = reportDate;
        this.reportType = reportType;
        this.gpsSatellites = gpsSatellites;
        this.heading = heading;
        this.speedLabel = speedLabel;
        this.text = text;
        this.textLabel = textLabel;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGpsDop() {
        return gpsDop;
    }

    public void setGpsDop(double gpsDop) {
        this.gpsDop = gpsDop;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public int getGpsSatellites() {
        return gpsSatellites;
    }

    public void setGpsSatellites(int gpsSatellites) {
        this.gpsSatellites = gpsSatellites;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public String getSpeedLabel() {
        return speedLabel;
    }

    public void setSpeedLabel(String speedLabel) {
        this.speedLabel = speedLabel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextLabel() {
        return textLabel;
    }

    public void setTextLabel(String textLabel) {
        this.textLabel = textLabel;
    }

    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al serializar el objeto GpsData a JSON", e);
        }
    }


    
}