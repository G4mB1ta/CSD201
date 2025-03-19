/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author kminh
 */
public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInt(String msginfo, String msginvalid, String msgoob, int min, int max) {
        while (true) {
            try {
                System.out.print(msginfo);
                int x = Integer.parseInt(SCANNER.nextLine());
                if (x >= min && x <= max) {
                    return x;
                } else {
                    System.err.print(msgoob);
                }
            } catch (NumberFormatException e) {
                System.err.print(msginvalid);
            }
        }
    }

    public static String getString(String msginfo, String msginvalid, String regex) {
        while (true) {
            try {
                System.out.print(msginfo);
                String x = SCANNER.nextLine();
                if (x.matches(regex)) {
                    return x;
                } else {
                    System.err.print(msginvalid);
                }
            } catch (Exception e) {
                System.err.print(msginvalid);
            }
        }
    }
}
