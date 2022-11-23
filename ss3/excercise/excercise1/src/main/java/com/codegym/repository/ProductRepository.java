package com.codegym.repository;

import com.codegym.model.Product;
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
        return productList;
    }

    @Override
    public void save(Product product) {
    productList.add(product);

    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
    productList.set(id,product);

    }

    @Override
    public void remove(int id) {
    productList.remove(id);

    }
}
