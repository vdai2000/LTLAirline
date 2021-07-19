package com.example.bookingfilght.Models;

public class CovidDTO {

//    private Long Confirmed;
//    private Long Recovered;
//    private Long Active;

    private Long deaths;
    private Long recovered;
    private Long active;
    private Long todayCases;
    private Long todayRecovered;
    private Long cases;

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Long todayCases) {
        this.todayCases = todayCases;
    }

    public Long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

//    public Long getConfirmed() {
//        return Confirmed;
//    }
//
//    public void setConfirmed(Long confirmed) {
//        Confirmed = confirmed;
//    }
//
//    public Long getRecovered() {
//        return Recovered;
//    }
//
//    public void setRecovered(Long recovered) {
//        Recovered = recovered;
//    }
//
//    public Long getActive() {
//        return Active;
//    }
//
//    public void setActive(Long active) {
//        Active = active;
//    }
}
