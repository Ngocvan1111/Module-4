package com.codegym.repository;

import com.codegym.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
private static  List<Product> productList = new ArrayList<>();
static {
    productList.add(new Product(1,"SP-001","Cà Chua",10000.0,"Đây là sản phẩm xuất xứ từ Nhật Bản","Nhật Bản"));
    productList.add(new Product(2,"SP-002","Cà Pháo",20000.0,"Đây là sản phẩm xuất xứ từ Nhật Bản","Nhật Bản"));
    productList.add(new Product(3,"SP-003","Cà Tím",30000.0,"Đây là sản phẩm xuất xứ từ Nhật Bản","Nhật Bản"));
    productList.add(new Product(4,"SP-004","Cà Cuống",40000.0,"Đây là sản phẩm xuất xứ từ Nhật Bản","Nhật Bản"));
    productList.add(new Product(5,"SP-005","Cà Phê",50000.0,"Đây là sản phẩm xuất xứ từ Nhật Bản","Nhật Bản"));
}
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        }finally {
            if(session != null){
                session.close();
            }
        }

        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product =(Product) session.createQuery("from Product p where id = :id").setParameter("id", id).getSingleResult();


        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update( Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    @Override
    public void remove(Product product) {
        Session session = null;
       Transaction transaction =null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();


        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product p where name like :name").setParameter("name","%"+name+"%").getResultList();
        }finally {
            if(session != null){
                session.close();
            }
        }

        return productList;
    }


}
