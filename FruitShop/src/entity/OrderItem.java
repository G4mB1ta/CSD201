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
public class OrderItem extends Product {

    private int quantity;
    private int amount;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        super(product.getId(), product.getName(), product.getOrigin(), product.getPrice());
        this.quantity = quantity;
        this.amount = this.quantity * super.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.amount = this.quantity * super.getPrice();

    }

    public int getAmount() {
        return amount;
    }
    
    
}
