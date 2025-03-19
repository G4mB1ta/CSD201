/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import entity.Order;
import entity.OrderItem;
import entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kminh
 */
public class Data {
    public static List<Product> mockProductsList() {
        ArrayList<Product> list = new ArrayList();
        list.add(new Product(1, "Apple", "Vietnam", 10));
        list.add(new Product(2, "Banana", "China", 15));
        list.add(new Product(3, "Grapes", "France", 12));
        list.add(new Product(4, "Kiwi", "Italia", 9));
        list.add(new Product(5, "Dog", "Vietnam", 14));
        return list;
    }
    
    public static List<Order> mockOrdersList() {
        
        Product p1 = new Product(1, "Apple", "Vietnam", 10);
        Product p2 = new Product(2, "Banana", "China", 15);
        Product p3 = new Product(3, "Grapes", "France", 12);
        Product p4 = new Product(4, "Kiwi", "Italia", 9);
        Product p5 = new Product(5, "Dog", "Vietnam", 14);
        
        ArrayList<Order> list = new ArrayList();

        Order o1 = new Order();
        o1.setCustomer("Tom");
        o1.add(new OrderItem(p1, 5));
        o1.add(new OrderItem(p5, 2));

        Order o2 = new Order();
        o2.setCustomer("John");
        o2.add(new OrderItem(p3, 10));
        o2.add(new OrderItem(p2, 4));


        list.add(o1);
        list.add(o2);
        return list;
    }
}
