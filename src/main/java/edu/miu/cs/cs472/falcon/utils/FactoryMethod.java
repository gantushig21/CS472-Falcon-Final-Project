package edu.miu.cs.cs472.falcon.utils;

import java.util.*;

public class FactoryMethod {
    private static final LinkedList<String> ids = new LinkedList<>();

    static {
        init();
    }

    private static void init() {
        generateIds();
    }

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
        if (ids.size() > 0) {
            return ids.removeFirst();
        }
        return null;
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

    public static String capitalizeFirstLetter(String str) {
        String[] s = str.split("\\s+");

        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
            s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1);
        }

        return String.join(" ", s);
    }
}
