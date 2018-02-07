package com.example.pmohale.mycloset.entity;

import com.example.pmohale.mycloset.entity.internal.PersistableEntity;

import java.util.Date;

/**
 * Created by PMohale on 2018/02/05.
 */

public class WeatherObject extends PersistableEntity {

    private int icon;

    private Date date;

    private Double minimum;

    private Double maximum;

    private Double humidity;

    private Double pressure;

    private Double wind;

    private Double degrees;

    public WeatherObject(int icon, Date date, Double minimum, Double maximum, Double humidity, Double pressure, Double wind, Double degrees) {
        this.icon = icon;
        this.date = date;
        this.minimum = minimum;
        this.maximum = maximum;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
        this.degrees = degrees;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public Double getDegrees() {
        return degrees;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }
}
