package vn.com.codegym.manageblogajax.repository;

//import codegym.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.codegym.manageblogajax.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
