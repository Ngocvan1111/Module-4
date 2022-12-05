package com.excercise.excercise.dto;



import com.excercise.excercise.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto,Integer> products) {
        this.products = products;
    }

    public Map<ProductDto,Integer> getProducts() {
        return products;
    }
    /// kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
    private boolean checkItemInCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(productDto.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(productDto.getId())){
                return entry;
            }
        }
        return null;
    }
    // Thêm sản phẩm vào giỏ hàng
    public void addProduct(ProductDto productDto){
        if (!checkItemInCart(productDto)){
            products.put(productDto,1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    //đếm số lượng của từng sản phẩm
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }
    // Tính tổng số tiền cần phải thanh toán
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void pay() {
        products.clear();
    }
}