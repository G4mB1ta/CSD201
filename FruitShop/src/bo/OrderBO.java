package bo;
import entity.Order;
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
public class OrderBO {
    private List<Order> orders;

    public OrderBO() {
        orders = new ArrayList<>();
    }

    public OrderBO(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
    public boolean add(Order o) {
        return orders.add(o);
    }
}
