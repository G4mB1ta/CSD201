package bo;

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

    public boolean add(Product newProduct) {
        for (Product p : products) {
            if (p.getId() == newProduct.getId() || p.getName().equals(newProduct.getName())) {
                return false;
            }
        }
        return products.add(newProduct);
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
