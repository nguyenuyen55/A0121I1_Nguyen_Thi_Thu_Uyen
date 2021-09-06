package bean;

public class CustomerType {
    private int customertypeId;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(int customertypeId, String customerTypeName) {
        this.customertypeId = customertypeId;
        this.customerTypeName = customerTypeName;
    }

    public int getCustomertypeId() {
        return customertypeId;
    }

    public void setCustomertypeId(int customertypeId) {
        this.customertypeId = customertypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
