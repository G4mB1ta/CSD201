/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customer;
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList();
    }

    public Order(String customer, List<OrderItem> items) {
        this.customer = customer;
        this.items = items;
    }
    
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getTotal() {
        int total = 0;
        for(OrderItem oi: items) {
            total += oi.getAmount();
        }
        return total;
    }
    
    public boolean add(OrderItem newOrderItem) {
        for(OrderItem oi : items) {
            if (oi.getId() == newOrderItem.getId()) {
                oi.setQuantity(oi.getQuantity() + newOrderItem.getQuantity());
                return true;
            }
        }
        return items.add(newOrderItem);
    }
    
    @Override
    public String toString() {
        String s = String.format("Customer: %s\nProduct | Quantity | Price | Amount\n", this.customer);
        for (int i=0; i < this.items.size(); i++) {
            s += String.format("%d.%s %10d %10d$ %10d\n", 
                    i+1, items.get(i).getName(),items.get(i).getQuantity(), items.get(i).getPrice(), items.get(i).getAmount());
        }
        s+= String.format("Total: %d\n", getTotal());
        return s;
    }
}
