package vn.codegym.managerbook.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.managerbook.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
