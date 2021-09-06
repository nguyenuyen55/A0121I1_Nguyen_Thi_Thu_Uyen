package service;

import bean.Service;

import java.util.List;

public interface IService_Service {
    List<Service> listService();
    void create(Service service);
}
