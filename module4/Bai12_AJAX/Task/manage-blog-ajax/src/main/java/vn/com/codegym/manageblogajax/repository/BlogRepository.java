package vn.com.codegym.manageblogajax.repository;

//import codegym.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.codegym.manageblogajax.bean.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
 Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select * from blog  where category_id = :id",nativeQuery = true)
    Page<Blog> findAllByCategory(Pageable pageable, @Param("id") int id);
    List<Blog> findByTitleContaining(String search);
   @Query(value="SELECT  * FROM blog ORDER BY id asc LIMIT :id ,1", nativeQuery = true)
    List<Blog> findTop1(@Param("id") int id);
}
