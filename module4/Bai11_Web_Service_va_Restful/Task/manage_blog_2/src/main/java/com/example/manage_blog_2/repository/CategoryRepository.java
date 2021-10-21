package com.example.manage_blog_2.repository;

//import codegym.bean.Category;
import com.example.manage_blog_2.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
