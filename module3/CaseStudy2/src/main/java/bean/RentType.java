package bean;

public class RentType {
    private int rentTypeId;
    private String rentName;
    private double rentTypeCost;

    public RentType(int rentTypeId, String rentName, double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentName = rentName;
        this.rentTypeCost = rentTypeCost;
    }

    public RentType(String rentName, double rentTypeCost) {
        this.rentName = rentName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }
}
