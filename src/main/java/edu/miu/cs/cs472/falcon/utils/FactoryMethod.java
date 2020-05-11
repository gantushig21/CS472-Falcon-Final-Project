package edu.miu.cs.cs472.falcon.utils;

import java.util.*;

public class FactoryMethod {
    private static LinkedList<String> ids = new LinkedList<>();

    public static void generateIds() {
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int index = (int) Math.floor(Math.random() * ch.length);
            char temp = ch[i];
            ch[i] = ch[index];
            ch[index] = temp;
        }
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                for (int k = 0; k < ch.length; k++) {
                    ids.add(ch[i] + "" + ch[j] + "" + ch[k]);
                }
            }
        }
        Collections.shuffle(ids);
    }

    public static String getUniqueId() {
        return ids.removeFirst();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
