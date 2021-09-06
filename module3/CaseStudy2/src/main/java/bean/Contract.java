package bean;

import java.util.Date;

public class Contract {
    private int contacId;
    private Date dateStart;
    private Date dateEnd;
    private double deposit;
    private double contractTotal;
    private int employeeId;
    private int customerId;
    private int serviceId;

    public Contract(Date dateStart, Date dateEnd, double deposit, double contractTotal, int employeeId, int customerId, int serviceId) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.contractTotal = contractTotal;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(int contacId, Date dateStart, Date dateEnd, double deposit, double contractTotal, int employeeId, int customerId, int serviceId) {
        this.contacId = contacId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.contractTotal = contractTotal;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public int getContacId() {
        return contacId;
    }

    public void setContacId(int contacId) {
        this.contacId = contacId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(double contractTotal) {
        this.contractTotal = contractTotal;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }


}
