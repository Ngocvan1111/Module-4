package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

   @Autowired
   private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);

    }

    @Override
    public Page<Blog> findByTitle(String title, Pageable pageable) {
        return blogRepository.findByTitle(title,pageable);
    }

    @Override
    public List<Blog> blogListEqualCategory(int id) {
        List<Blog> blogList = blogRepository.blogListEqualCategory(id);
//        List<Blog> blogList1 = new ArrayList<>();
//        for(int i=0;i<blogList.size();i++){
//            if(blogList.get(i).getCategory().getName().equals(categoryName)){
//                blogList1.add(blogList.get(i));
//            }
//        }

        return blogList;
    }
}
