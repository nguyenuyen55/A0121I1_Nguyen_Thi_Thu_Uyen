package service;

import bean.DichVu;
import bean.ThongtinTiecCuoi;

import java.util.List;

public interface IServiceThongtin {
    void createThongtin(ThongtinTiecCuoi thongtinTiecCuoi);

    void update(ThongtinTiecCuoi thongtinTiecCuoi,int id);

    List<ThongtinTiecCuoi> thongtinList();

    boolean delete(int id);

    ThongtinTiecCuoi selectById(int id);

    ThongtinTiecCuoi searchById(int id);
    List<DichVu> dichVuList();

    DichVu selectByIdDicVu(int id);

}
