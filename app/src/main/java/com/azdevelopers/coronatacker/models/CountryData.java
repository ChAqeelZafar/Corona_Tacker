package com.azdevelopers.coronatacker.models;

public class CountryData {
    String countryName, totalCases, newCases, totalDeaths, newDeaths, totalRecoverd, activeCases, seriousCases, totCases;

    public CountryData(){

    }

    public CountryData(String countryName, String totalCases, String newCases, String totalDeaths, String newDeaths, String totalRecoverd, String activeCases, String seriousCases, String totCases) {
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecoverd = totalRecoverd;
        this.activeCases = activeCases;
        this.seriousCases = seriousCases;
        this.totCases = totCases;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalRecoverd() {
        return totalRecoverd;
    }

    public void setTotalRecoverd(String totalRecoverd) {
        this.totalRecoverd = totalRecoverd;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getSeriousCases() {
        return seriousCases;
    }

    public void setSeriousCases(String seriousCases) {
        this.seriousCases = seriousCases;
    }

    public String getTotCases() {
        return totCases;
    }

    public void setTotCases(String totCases) {
        this.totCases = totCases;
    }
}
