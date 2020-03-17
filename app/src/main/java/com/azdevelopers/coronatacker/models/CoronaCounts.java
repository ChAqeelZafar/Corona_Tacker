package com.azdevelopers.coronatacker.models;

public class CoronaCounts {

    private String totalCasesCount, deathCount, recoverCounts;
    private String activeCasesCount, closedCasesCount;
    private String mildCasesCount, seriousCasesCount;
    private String currentTime;


    public CoronaCounts(String totalCasesCount, String deathCount, String recoverCounts, String activeCasesCount, String closedCasesCount, String mildCasesCount, String seriousCasesCount, String currentTime) {
        this.totalCasesCount = totalCasesCount;
        this.deathCount = deathCount;
        this.recoverCounts = recoverCounts;
        this.activeCasesCount = activeCasesCount;
        this.closedCasesCount = closedCasesCount;
        this.mildCasesCount = mildCasesCount;
        this.seriousCasesCount = seriousCasesCount;
        this.currentTime = currentTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public CoronaCounts(){

    }

    public String getTotalCasesCount() {
        return totalCasesCount;
    }

    public void setTotalCasesCount(String totalCasesCount) {
        this.totalCasesCount = totalCasesCount;
    }

    public String getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(String deathCount) {
        this.deathCount = deathCount;
    }

    public String getRecoverCounts() {
        return recoverCounts;
    }

    public void setRecoverCounts(String recoverCounts) {
        this.recoverCounts = recoverCounts;
    }

    public String getActiveCasesCount() {
        return activeCasesCount;
    }

    public void setActiveCasesCount(String activeCasesCount) {
        this.activeCasesCount = activeCasesCount;
    }

    public String getClosedCasesCount() {
        return closedCasesCount;
    }

    public void setClosedCasesCount(String closedCasesCount) {
        this.closedCasesCount = closedCasesCount;
    }

    public String getMildCasesCount() {
        return mildCasesCount;
    }

    public void setMildCasesCount(String mildCasesCount) {
        this.mildCasesCount = mildCasesCount;
    }

    public String getSeriousCasesCount() {
        return seriousCasesCount;
    }

    public void setSeriousCasesCount(String seriousCasesCount) {
        this.seriousCasesCount = seriousCasesCount;
    }
}
