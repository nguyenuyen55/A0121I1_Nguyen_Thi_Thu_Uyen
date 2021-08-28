package bean;

public class DichVu {
    private int id_DichVu;
    private String TenDichVu;
    private int DonGia;

    public DichVu(int id_DichVu, String tenDichVu, int donGia) {
        this.id_DichVu = id_DichVu;
        TenDichVu = tenDichVu;
        DonGia = donGia;
    }

    public int getId_DichVu() {
        return id_DichVu;
    }

    public void setId_DichVu(int id_DichVu) {
        this.id_DichVu = id_DichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        TenDichVu = tenDichVu;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }
}
