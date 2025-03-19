/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kminh
 */
public class Product {

    private int id;
    private String name;
    private String origin;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String origin, int price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = String.format("%d %25s %10s %5d\n", this.id, this.name, this.origin, this.price);
        return s;
    }
    
}
