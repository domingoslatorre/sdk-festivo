package org.example.model;

public class Query {
    private String country;
    private String year;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return "Query [country=" + country + ", year=" + year + "]";
    } 
}
