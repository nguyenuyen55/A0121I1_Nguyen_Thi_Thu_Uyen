package iOJava.baiTap;

public class Country {
    private  String startIp;
    private String endIp;
    private String countryCode;
    private String country;

    public Country() {
    }

    public Country(String startIp, String endIp, String countryCode, String country) {
        this.startIp = startIp;
        this.endIp = endIp;
        this.countryCode = countryCode;
        this.country = country;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
