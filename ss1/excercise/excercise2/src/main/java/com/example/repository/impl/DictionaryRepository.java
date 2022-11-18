package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    public static Map<String,String> list = new LinkedHashMap<>();
    static {
        list.put("dog","Dog có nghĩa là con chó");
        list.put("cat","cat có nghĩa là con mèo");
        list.put("monkey","Monkey có nghĩa là con khi");
        list.put("flower","Flower có nghĩa là hoa");
    }
    @Override
    public Map<String, String> list() {
        return list;
    }
}
