package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        var cityBool = false;
        var countryBool = false;
        var streetBool = false;
        int counter = 0;

        if (obj == null || getClass() != obj.getClass()) return false;
        Location that = (Location) obj;
        if (that.city == null && city == null) {
            cityBool = true;
        } else if (that.city == null || city == null) {
            return false;
        }
        if (that.country == null && country == null) {
            countryBool = true;
        } else if (that.country == null || country == null) {
            return false;
        }
        if (that.street == null && street == null) {
            streetBool = true;
        } else if (that.street == null || street == null) {
            return false;
        }

        if (streetBool) {
            counter += 1;
        } else if (street.equals(that.street)) {
            counter += 1;
        }
        if (countryBool) {
            counter += 1;
        } else if (country.equals(that.country)) {
            counter += 1;
        }
        if (cityBool) {
            counter += 1;
        } else if (city.equals(that.city)) {
            counter += 1;
        }
        if (builing == that.builing) {
            counter += 1;
        }
        if (counter == 4) {
            return true;
        } else {
            return false;
        }
    }
}
