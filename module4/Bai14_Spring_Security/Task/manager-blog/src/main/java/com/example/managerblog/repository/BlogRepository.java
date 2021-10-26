package com.example.managerblog.repository;

import com.example.managerblog.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer> {
 Page<Blog> findAllByTitleContaining(String name,Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select * from blog  where category_id = :id",nativeQuery = true)
    Page<Blog> findAllByCategory(Pageable pageable,@Param("id") int id);
}
