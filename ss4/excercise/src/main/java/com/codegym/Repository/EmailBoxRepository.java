package com.codegym.Repository;

import com.codegym.model.EmailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailBoxRepository implements IEmailBoxRepository {

    private static List<EmailBox> emailBoxList = new ArrayList<>();
    static {
        emailBoxList.add(new EmailBox(1,"English",25,true,"Ngoc")) ;
        emailBoxList.add(new EmailBox(2,"Vietnamese",5,true,"Nam")) ;
        emailBoxList.add(new EmailBox(3,"Japanese",15,true,"Nhan")) ;
        emailBoxList.add(new EmailBox(4,"Chinese",50,true,"Nham")) ;
    }
    private static List<String> languages = new ArrayList<>();
    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("chinese");

    }
    private static List<Integer> pageSizes = new  ArrayList();
    static {
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }



    @Override
    public List<EmailBox> findAllEmailBox() {
        return emailBoxList;
    }

    @Override
    public List<String> findAllLanguages() {
        return languages;
    }

    @Override
    public List<Integer> findAllPageSize() {
        return pageSizes;
    }

    @Override
    public boolean delete(int id) {
        for(int i = 0;i<emailBoxList.size();i++){
            if(emailBoxList.get(i).getId() == id){
                emailBoxList.remove(i);
                return true;
            }
        }
        return false;
    }
}
