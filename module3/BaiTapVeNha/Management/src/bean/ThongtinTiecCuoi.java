package bean;

public class ThongtinTiecCuoi {
    private int id;
    private String NgayToChuc;
    private String tenCoDau;
    private String tenChuRe;
    private int soLuongBan;
    private int donGia;
    private int dichVuDiKem;
    private int tenNoDatCoc;
    private int TienNoThanhToan;
    private String ngayDatCoc;
    private String NgayThanhToan;
    private String ghiChu;
    private String trangThai;

    public ThongtinTiecCuoi(String ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tenNoDatCoc, int tienNoThanhToan, String ngayDatCoc, String ngayThanhToan, String ghiChu, String trangThai) {
        NgayToChuc = ngayToChuc;
        this.tenCoDau = tenCoDau;
        this.tenChuRe = tenChuRe;
        this.soLuongBan = soLuongBan;
        this.donGia = donGia;
        this.dichVuDiKem = dichVuDiKem;
        this.tenNoDatCoc = tenNoDatCoc;
        TienNoThanhToan = tienNoThanhToan;
        this.ngayDatCoc = ngayDatCoc;
        NgayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public ThongtinTiecCuoi(int id, String ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tenNoDatCoc, int tienNoThanhToan, String ngayDatCoc, String ngayThanhToan, String ghiChu, String trangThai) {
        this.id = id;
        NgayToChuc = ngayToChuc;
        this.tenCoDau = tenCoDau;
        this.tenChuRe = tenChuRe;
        this.soLuongBan = soLuongBan;
        this.donGia = donGia;
        this.dichVuDiKem = dichVuDiKem;
        this.tenNoDatCoc = tenNoDatCoc;
        TienNoThanhToan = tienNoThanhToan;
        this.ngayDatCoc = ngayDatCoc;
        NgayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayToChuc() {
        return NgayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        NgayToChuc = ngayToChuc;
    }

    public String getTenCoDau() {
        return tenCoDau;
    }

    public void setTenCoDau(String tenCoDau) {
        this.tenCoDau = tenCoDau;
    }

    @Override
    public String toString() {
        return "ThongtinTiecCuoi{" +
                "id=" + id +
                ", NgayToChuc='" + NgayToChuc + '\'' +
                ", tenCoDau='" + tenCoDau + '\'' +
                ", tenChuRe='" + tenChuRe + '\'' +
                ", soLuongBan=" + soLuongBan +
                ", donGia=" + donGia +
                ", dichVuDiKem=" + dichVuDiKem +
                ", tenNoDatCoc=" + tenNoDatCoc +
                ", TienNoThanhToan=" + TienNoThanhToan +
                ", ngayDatCoc='" + ngayDatCoc + '\'' +
                ", NgayThanhToan='" + NgayThanhToan + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

    public String getTenChuRe() {
        return tenChuRe;
    }

    public void setTenChuRe(String tenChuRe) {
        this.tenChuRe = tenChuRe;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(int dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }

    public int getTenNoDatCoc() {
        return tenNoDatCoc;
    }

    public void setTenNoDatCoc(int tenNoDatCoc) {
        this.tenNoDatCoc = tenNoDatCoc;
    }

    public int getTienNoThanhToan() {
        return TienNoThanhToan;
    }

    public void setTienNoThanhToan(int tienNoThanhToan) {
        TienNoThanhToan = tienNoThanhToan;
    }

    public String getNgayDatCoc() {
        return ngayDatCoc;
    }

    public void setNgayDatCoc(String ngayDatCoc) {
        this.ngayDatCoc = ngayDatCoc;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
