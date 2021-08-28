package service;

import bean.DichVu;
import bean.ThongtinTiecCuoi;

import respository.IRepositoryThongTin;
import respository.ImIRepositorythongtin;

import java.util.List;

public class ImIServiceUser implements IServiceThongtin {
    private IRepositoryThongTin repositoryUser = new ImIRepositorythongtin();

    @Override
    public void createThongtin(ThongtinTiecCuoi thongtinTiecCuoi) {
        repositoryUser.createThongtin(thongtinTiecCuoi);
    }

    @Override
    public void update(ThongtinTiecCuoi thongtinTiecCuoi,int id) {
repositoryUser.update(thongtinTiecCuoi,id);
    }

    @Override
    public List<ThongtinTiecCuoi> thongtinList() {
        return repositoryUser.thongtinList();
    }

    @Override
    public boolean delete(int id) {
        return repositoryUser.delete(id);
    }

    @Override
    public ThongtinTiecCuoi selectById(int id) {
        return repositoryUser.selectById(id);
    }

    @Override
    public ThongtinTiecCuoi searchById(int id) {
        return null;
    }

    @Override
    public List<DichVu> dichVuList() {
        return repositoryUser.dichVuList();
    }

    @Override
    public DichVu selectByIdDicVu(int id) {
        return repositoryUser.selectByIdDicVu(id);
    }
}


