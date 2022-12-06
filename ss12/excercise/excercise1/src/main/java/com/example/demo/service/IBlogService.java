package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {


    List<Blog> blogListEqualCategory(int id);
}
