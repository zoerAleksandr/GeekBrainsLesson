package com.zoerAleksandr.lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 06.04.2021 17:19
 */
public class PhoneDirectory {

    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        add(123, "Николаев");
        add(1234, "Васильев");
        add(12345, "Александров");
        add(12, "Александров");
        add(123456, "Петров");
        add(1234567, "Сергеев");
        add(1231, "Григорьев");

        System.out.println(get());

    }

    private static void add(int i, String s) {
        map.put(i, s);
    }

    private static HashMap<Integer, String> get() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Integer, String> hm = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(s)) {
                hm.put(entry.getKey(), entry.getValue());
            }
        }
        if (hm.isEmpty()) System.out.println("Совпадений не найдено");
        return hm;
    }
}
