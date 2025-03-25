package bo;

import constant.IConstant;
import constant.IMessage;
import entity.Product;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kminh
 */
public class ProductBO {

    private List<Product> products;

    public ProductBO() {
        products = new ArrayList<>();
    }

    public ProductBO(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void add() {
        Product p = new Product();
        if (!p.input(products, IConstant.RESTOCK)) {
            products.add(p);
        }
    }
    
    public void display() {
        System.out.print(IMessage.PRODUCTS_DISPLAY_HEADER);
        products.forEach((p) -> {
            System.out.print(p.toString());
        });
    }
    
    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
