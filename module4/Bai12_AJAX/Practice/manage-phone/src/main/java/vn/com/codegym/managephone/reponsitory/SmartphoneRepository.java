package vn.com.codegym.managephone.reponsitory;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.codegym.managephone.model.Smartphone;
//@EnableJpaRepositories
public interface SmartphoneRepository extends CrudRepository<Smartphone,Integer> {
}
