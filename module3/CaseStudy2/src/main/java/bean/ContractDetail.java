package bean;

public class ContractDetail {
    private int idDetail;
    private int contractId;
    private int serviceid;
    private int quantity;

    public ContractDetail(int idDetail, int contractId, int serviceid, int quantity) {
        this.idDetail = idDetail;
        this.contractId = contractId;
        this.serviceid = serviceid;
        this.quantity = quantity;
    }

    public ContractDetail(int contractId, int serviceid, int quantity) {
        this.contractId = contractId;
        this.serviceid = serviceid;
        this.quantity = quantity;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
