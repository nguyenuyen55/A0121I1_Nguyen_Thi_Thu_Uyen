package vn.codegym.managerbook.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.managerbook.entity.Book;
import vn.codegym.managerbook.entity.Borrow;

public interface BorrowRepository extends CrudRepository<Borrow,String> {

}
