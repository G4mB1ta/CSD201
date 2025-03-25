/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import constant.IMessage;
import java.util.List;
import utils.Validate;

/**
 *
 * @author kminh
 */
public class Product {

    private int id;
    private String name;
    private String origin;
    private int price;
    private int quantity;
    private int amount;

    public Product() {
    }

    public Product(int id, String name, String origin, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
        this.amount = this.quantity * this.price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.amount = this.price * this.quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean input(List<Product> plist, final String ACTION) {
        this.id = Validate.getInt("Enter id: ",
                IMessage.INVALID,
                IMessage.OOB, 1, Integer.MAX_VALUE);

        for (int i = 0; i < plist.size(); i++) {
            if (plist.get(i).getId() == this.id) {
                this.quantity = Validate.getInt("Enter quantity: ",
                        IMessage.INVALID,
                        IMessage.OOB, 1, Integer.MAX_VALUE);

                if (ACTION.equals(IConstant.RESTOCK)) {
                    plist.get(i).setQuantity(plist.get(i).getQuantity() + quantity);
                } else {
                    this.name = plist.get(i).getName();
                    this.price = plist.get(i).getPrice();
                    this.origin = plist.get(i).getOrigin();
                    this.amount = this.price * this.quantity;
                    plist.get(i).setQuantity(plist.get(i).getQuantity() - quantity);
                }
                return true;
            }
        }
        if (ACTION.equals(IConstant.RESTOCK)) {
            this.name = Validate.getString("Enter name: ",
                    IMessage.INVALID, IConstant.REGEX_NAME);
            this.origin = Validate.getString("Enter name: ",
                    IMessage.INVALID, IConstant.REGEX_NAME);
            this.quantity = Validate.getInt("Enter quantity: ",
                    IMessage.INVALID, IMessage.OOB, 1, Integer.MAX_VALUE);
            this.price = Validate.getInt("Enter price: ",
                    IMessage.INVALID, IMessage.OOB, 1, Integer.MAX_VALUE);

            this.amount = this.quantity * this.price;
        } else {
            System.out.print("Product not found!\n");
        }

        return false;
    }

    @Override
    public String toString() {
        String s = String.format("%d %25s %10s %5d %5d %5d\n", this.id, this.name, this.origin, this.price, this.quantity, this.amount);
        return s;
    }

}
