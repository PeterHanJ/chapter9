package com.smart.spel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class User {

    private String userName;
    private Date lastVisit;
    private int credits;
    private PlaceOfBirth placeOfBirth;

    private String[] interestsArray;
    private List interestsList;
    private Map interestsMap;

    public boolean isVIP(String name){
        if("Peter".equals(name)){
            return true;
        }
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String[] getInterestsArray() {
        return interestsArray;
    }

    public void setInterestsArray(String[] interestsArray) {
        this.interestsArray = interestsArray;
    }

    public List getInterestsList() {
        return interestsList;
    }

    public void setInterestsList(List interestsList) {
        this.interestsList = interestsList;
    }

    public Map getInterestsMap() {
        return interestsMap;
    }

    public void setInterestsMap(Map interestsMap) {
        this.interestsMap = interestsMap;
    }
}
