package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryService iDictionaryService;
    @Override
    public Map<String, String> list() {
        return iDictionaryService.list();
    }
}
