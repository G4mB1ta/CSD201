/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.OrderBO;
import bo.ProductBO;
import constant.IConstant;
import constant.IMessage;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import java.util.List;
import mock.Data;
import utils.Validate;

public class Main {

    public static void main(String[] args) {

        OrderBO orderBo = new OrderBO(Data.mockOrdersList());
        ProductBO productBo = new ProductBO(Data.mockProductsList());

        int choice = 0;
        do {
            System.out.println("1. Create\n");
            System.out.println("2. View Orders\n");
            System.out.println("3. Shopping (for Buyers)\n");
            System.out.println("4. Exit\n");
            choice = Validate.getInt("Enter choice: ",
                    IMessage.INVALID, IMessage.OOB, 1, 4);

            switch (choice) {
                case 1:
                    {
                        int id = Validate.getInt("Enter id: ",
                                IMessage.INVALID,
                                IMessage.OOB, 1, Integer.MAX_VALUE);
                        String name = Validate.getString("Enter name: ",
                                IMessage.INVALID, IConstant.REGEX_NAME);
                        String origin = Validate.getString("Enter origin: ",
                                IMessage.INVALID, IConstant.REGEX_NAME);
                        int price = Validate.getInt("Enter price: ",
                                IMessage.INVALID,
                                IMessage.OOB, 1, Integer.MAX_VALUE);
                        Product p = new Product(id, name, origin, price);
                        
                        if (productBo.add(p)) {
                            System.out.print(IMessage.ADDED_SUCCESS);
                        } else {
                            System.out.print(IMessage.ADDED_FAILED);
                        }
                        
                    }
                    break;
                case 2:
                    List<Order> ol = orderBo.getOrders();
                    displayOrders(ol);
                    break;
                case 3:
                    {
                        Order o = new Order();
                        List<Product> pl = productBo.getProducts();
                        String check = "N";
                        while (check.equals("N")) {
                            OrderItem oi = new OrderItem();
                            displayProducts(pl);
                            int id = Validate.getInt("Enter product id: ", 
                                    IMessage.INVALID, 
                                    IMessage.OOB, 1, Integer.MAX_VALUE);
                            
                            Product p = productBo.getProductById(id);
                            
                            if (p != null) {
                                oi.setId(p.getId());
                                oi.setName(p.getName());
                                oi.setOrigin(p.getOrigin());
                                oi.setPrice(p.getPrice());
                                int q = Validate.getInt("Enter quantity: ", 
                                        IMessage.INVALID, 
                                        IMessage.OOB, 1, Integer.MAX_VALUE);
                                oi.setQuantity(q);
                                o.add(oi);
                            } else {
                                System.out.print("Product not found!");
                            }   
                            
                            check = Validate.getString(
                                    "Do you want to order now?(Y/N); ",
                                    IMessage.INVALID, IConstant.REGEX_YESNO);
                        }
                        
                        System.out.print(o.toString());
                        
                        String name = Validate.getString("Enter customer: ", 
                                IMessage.INVALID, IConstant.REGEX_NAME);
                        o.setCustomer(name);
                        orderBo.add(o);
                    }
                    break;
                case 4:
                    break;
            }

        } while (choice != 4);
    }

    private static void displayProducts(List<Product> list) {
        System.out.print(IMessage.PRODUCTS_DISPLAY_HEADER);
        list.forEach((p) -> {
            System.out.print(p.toString());
        });
    }

    private static void displayOrders(List<Order> list) {
        System.out.print(IMessage.ORDER_DISPLAY_HEADER);
        list.forEach((o) -> {
            System.out.print(o.toString());
        });

    }

}
