/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import entity.Order;
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
        list.add(new Product(1, "Apple", "Vietnam", 10, 100));
        list.add(new Product(2, "Banana", "China", 15, 50));
        list.add(new Product(3, "Grapes", "France", 12, 20));
        list.add(new Product(4, "Kiwi", "Italia", 9, 20));
        list.add(new Product(5, "Dog", "Vietnam", 14, 10));
        return list;
    }
    
    public static List<Order> mockOrdersList() { 
        ArrayList<Order> list = new ArrayList();
        return list;
    }
}
