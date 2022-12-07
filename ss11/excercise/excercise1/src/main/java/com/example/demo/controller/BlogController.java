package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blog")
public class BlogController {
@Autowired
    private IBlogService iBlogService;
@Autowired
    private ICategoryService iCategoryService;
// Xem danh sách các bài biết
@GetMapping("")
    public ResponseEntity<Page<Blog>> getList(@PageableDefault(page = 0,size = 2) Pageable pageable){
    Page<Blog> blogList = iBlogService.findAll(pageable);
    if(blogList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    return  new ResponseEntity<>(blogList,HttpStatus.OK);

}
// Xem chi tiết 1 bài viết.
@GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
    Optional<Blog> blog = iBlogService.findById(id);
    if(!blog.isPresent()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blog.get(), HttpStatus.OK);

}
// Xem danh sách các bài viết của 1 catagory.
    @GetMapping("/{id}/blogs")
    public ResponseEntity<List<Blog>> showBlogsInCategory(@PathVariable int id){

        List<Blog> blogList = iBlogService.blogListEqualCategory(id);

        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }

}
