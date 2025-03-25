package bo;

import constant.IConstant;
import constant.IMessage;
import entity.Order;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import utils.Printer;
import utils.Validate;

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

    public void add(List<Product> pl) {
        Order o = new Order();

        String check = "Y";
        while (check.equals("Y")) {

            Product p = new Product();
            Printer.printList(IMessage.PRODUCTS_DISPLAY_HEADER, pl);
            if (p.input(pl, IConstant.BUY)) {
                o.add(p);
            }
            check = Validate.getString(
                "Do you want to order now?(Y/N); ",
                IMessage.INVALID, IConstant.REGEX_YESNO);
        }
        orders.add(o);
    }

    public void display() {
        System.out.print(IMessage.ORDER_DISPLAY_HEADER);
        orders.forEach((o) -> {
            System.out.print(o.toString());
        });
    }
}
