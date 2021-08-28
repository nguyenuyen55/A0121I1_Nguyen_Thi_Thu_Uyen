package respository;

import bean.DichVu;
import bean.ThongtinTiecCuoi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ImIRepositorythongtin implements IRepositoryThongTin{
    public static final String INSERT_INTO = "insert into ThongTinTiecCuoi (ngayTochuc,tenCoDau,tenChuRe,SoluongBan,DonGia,DichVuDiKiem,tienNoDatCoc,\n" +
            "TienNoThanhToan,NgayDatCoc,NgayThanhToan,ghichu,TrangThai)\n" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_THONGTIN = "update thongtintieccuoi\n" +
            "set ngayTochuc=?,tenCoDau=?,tenChuRe=?,SoluongBan=?,DonGia=?,DichVuDiKiem=?,tienNoDatCoc=?,TienNoThanhToan=?,NgayDatCoc=?,NgayThanhToan=?,ghichu=?,TrangThai=?\n" +
            "where Id =?";

    @Override
    public void createThongtin(ThongtinTiecCuoi thongtinTiecCuoi) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(INSERT_INTO);
            statement.setString(1, thongtinTiecCuoi.getNgayToChuc());
            statement.setString(2, thongtinTiecCuoi.getTenCoDau());
            statement.setString(3, thongtinTiecCuoi.getTenChuRe());
            statement.setInt(4, thongtinTiecCuoi.getSoLuongBan());
            statement.setInt(5, thongtinTiecCuoi.getDonGia());
            statement.setInt(6, thongtinTiecCuoi.getDichVuDiKem());
            statement.setInt(7, thongtinTiecCuoi.getTenNoDatCoc());
            statement.setInt(8, thongtinTiecCuoi.getTienNoThanhToan());
            statement.setString(9, thongtinTiecCuoi.getNgayDatCoc());
            statement.setString(10, thongtinTiecCuoi.getNgayThanhToan());
            statement.setString(11, thongtinTiecCuoi.getGhiChu());
            statement.setString(12, thongtinTiecCuoi.getTrangThai());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
    }

    @Override
    public void update(ThongtinTiecCuoi thongtinTiecCuoi,int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(UPDATE_THONGTIN);
            statement.setString(1, thongtinTiecCuoi.getNgayToChuc());
            statement.setString(2, thongtinTiecCuoi.getTenCoDau());
            statement.setString(3, thongtinTiecCuoi.getTenChuRe());
            statement.setInt(4, thongtinTiecCuoi.getSoLuongBan());
            statement.setInt(5, thongtinTiecCuoi.getDonGia());
            statement.setInt(6, thongtinTiecCuoi.getDichVuDiKem());
            statement.setInt(7, thongtinTiecCuoi.getTenNoDatCoc());
            statement.setInt(8, thongtinTiecCuoi.getTienNoThanhToan());
            statement.setString(9, thongtinTiecCuoi.getNgayDatCoc());
            statement.setString(10, thongtinTiecCuoi.getNgayThanhToan());
            statement.setString(11, thongtinTiecCuoi.getGhiChu());
            statement.setString(12, thongtinTiecCuoi.getTrangThai());
            statement.setInt(13, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
    }

    @Override
    public List<ThongtinTiecCuoi> thongtinList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ThongtinTiecCuoi> thongtinTiecCuois = new ArrayList<>();

        try {
            statement = connection.prepareCall("SELECT * FROM thongtintieccuoi;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ngayToChuc = resultSet.getString("ngayToChuc");
                String tenCoDau = resultSet.getString("tenCoDau");
                String tenChuRe = resultSet.getString("tenChuRe");
                int soLuongBan = resultSet.getInt("SoluongBan");
                int donGia = resultSet.getInt("DonGia");
                int dichVuDiKem = resultSet.getInt("DichVuDiKiem");
                int tenNoDatCoc = resultSet.getInt("tienNoDatCoc");
                int tienNoThanhToan = resultSet.getInt("TienNoThanhToan");
                String ngayDatCoc = resultSet.getString("NgayDatCoc");
                String ngayThanhToan = resultSet.getString("NgayThanhToan");
                String ghiChu = resultSet.getString("ghichu");
                String trangThai = resultSet.getString("TrangThai");
                int id = resultSet.getInt("id");
                thongtinTiecCuois.add(new ThongtinTiecCuoi(id, ngayToChuc, tenCoDau, tenChuRe,soLuongBan,donGia,dichVuDiKem,tenNoDatCoc,tienNoThanhToan,ngayDatCoc,ngayThanhToan,ghiChu,trangThai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();



        return thongtinTiecCuois;

    }

    @Override
    public boolean delete(int id) {
boolean rowDel=false;
        Connection  connection= DBConnection.getConnection();
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement("delete from thongtintieccuoi where Id= ? ");
            statement.setInt(1, id);
         rowDel=   statement.executeUpdate()>1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return rowDel;
    }

    @Override
    public ThongtinTiecCuoi selectById(int id) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongtinTiecCuoi thongtinTiecCuoi= null;

        try {
            statement = connection.prepareCall("SELECT * FROM thongtintieccuoi where id=?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ngayToChuc = resultSet.getString("ngayToChuc");
                String tenCoDau = resultSet.getString("tenCoDau");
                String tenChuRe = resultSet.getString("tenChuRe");
                int soLuongBan = resultSet.getInt("SoluongBan");
                int donGia = resultSet.getInt("DonGia");
                int dichVuDiKem = resultSet.getInt("DichVuDiKiem");
                int tenNoDatCoc = resultSet.getInt("tienNoDatCoc");
                int tienNoThanhToan = resultSet.getInt("TienNoThanhToan");
                String ngayDatCoc = resultSet.getString("NgayDatCoc");
                String ngayThanhToan = resultSet.getString("NgayThanhToan");
                String ghiChu = resultSet.getString("ghichu");
                String trangThai = resultSet.getString("TrangThai");
                thongtinTiecCuoi = new ThongtinTiecCuoi(id, ngayToChuc, tenCoDau, tenChuRe,soLuongBan,donGia,dichVuDiKem,tenNoDatCoc,tienNoThanhToan,ngayDatCoc,ngayThanhToan,ghiChu,trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
        return thongtinTiecCuoi;

    }

    @Override
    public ThongtinTiecCuoi searchById(int id) {
        return null;
    }

    @Override
    public List<DichVu> dichVuList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DichVu> dichVus = new ArrayList<>();

        try {
            statement = connection.prepareCall("SELECT * FROM dichvu;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tenDichVu = resultSet.getString("tenDichVu");
                int don_gia = resultSet.getInt("don_gia");

                int id = resultSet.getInt("id_dich_vu");
                dichVus.add(new DichVu(id,tenDichVu,don_gia));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();


        return dichVus;

    }

    @Override
    public DichVu selectByIdDicVu(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DichVu dichVu= null;

        try {
            statement = connection.prepareCall("SELECT * FROM dichvu where id_dich_vu =?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tenDichVu = resultSet.getString("tenDichVu");
                int don_gia = resultSet.getInt("don_gia");
            dichVu = new DichVu(id,tenDichVu,don_gia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
        return dichVu;
    }
}
