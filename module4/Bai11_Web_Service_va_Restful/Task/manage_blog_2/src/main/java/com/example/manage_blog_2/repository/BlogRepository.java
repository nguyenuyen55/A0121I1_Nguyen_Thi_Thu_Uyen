package com.example.manage_blog_2.repository;

//import codegym.bean.Blog;
import com.example.manage_blog_2.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
 Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select * from blog  where category_id = :id",nativeQuery = true)
    Page<Blog> findAllByCategory(Pageable pageable,@Param("id") int id);
}
