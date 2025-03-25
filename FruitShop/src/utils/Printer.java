/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;

/**
 *
 * @author kminh
 */
public class Printer {
    public static<T> void printList(String msg, List<T> list) {
        System.out.print(msg);
        for (T t : list) {
            System.out.print(t.toString());
        }
    }
}
