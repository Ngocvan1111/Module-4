package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where blog.title like CONCAT('%', :title, '%') order by blog.start_day_write", nativeQuery = true)
    Page<Blog> findByTitle(@Param("title") String title, Pageable pageable);
    @Query(value = "select * from blog b join category c on b.category_id = c.id where b.category_id = :id", nativeQuery = true)

    List<Blog> blogListEqualCategory(@Param("id") int id);
//    @Query(value = "select * from blog where blog.name like concat('%', :name, '%') or blog.author like concat('%', :author, '%') order by day_of_write ", nativeQuery = true)
//    Page<Blog> findByNameOrAuthor(String name, String author, Pageable pageable);
}
