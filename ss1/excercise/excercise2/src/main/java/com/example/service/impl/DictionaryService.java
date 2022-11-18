package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository iDictionaryRepository;
    @Override
    public String translate(String inputWord) {
        Map<String, String> listWord = iDictionaryRepository.list();

        boolean flag = true;
        String result ="";
        for (int i=0;i<listWord.size();i++){
            if(listWord.containsKey(inputWord)){
                result = listWord.get(inputWord);
                flag = false;
            }
        }
        if(flag){
      result = "Không có từ cần dịch";
        }return result;
    }
}
