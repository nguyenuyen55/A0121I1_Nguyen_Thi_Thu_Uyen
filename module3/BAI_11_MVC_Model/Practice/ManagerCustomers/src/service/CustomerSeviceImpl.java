package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerSeviceImpl implements CustomerService {
   private static Map<Integer,Customer> customerMap;

   static {
       customerMap = new HashMap<>();
       customerMap.put(1,new Customer(1,"uyen","uyen@gmail.com","Quảng Ngãi"));
       customerMap.put(2,new Customer(2,"tam","tam@gmail.com","hải phòng"));
       customerMap.put(3,new Customer(3,"như","nhu@gmail.com","hà nội"));
       customerMap.put(4,new Customer(4,"phat","phat@gmail.com","Đà Nẵng"));
       customerMap.put(5,new Customer(5,"khương","khuong@gmail.com","Bình Định"));
       customerMap.put(6,new Customer(6,"linh","linh@gmail.com","Phú Yên"));
       customerMap.put(7,new Customer(7,"nga","nga@gmail.com","Lào Cai"));
       customerMap.put(8,new Customer(8,"tram","tram@gmail.com","SaPa"));
   }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(Customer customer, int id) {
customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
