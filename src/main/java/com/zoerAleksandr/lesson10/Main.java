package com.zoerAleksandr.lesson10;

import java.util.*;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 05.04.2021 15:00
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("9");
        list.add("8");
        list.add("7");
        list.add("6");
        list.add("5");
        list.add("5");
        list.add("5");
        list.add("5");

        // удалили повторы
        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        System.out.println(set);
        ArrayList<String> list2 = new ArrayList<>(set);

        // считаем количество повторов
        // создаю Мар в который key - значение из list, value - количество повторений
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list2) {
            int count = 0;
            for (String value : list) {
                if (value.equals(s)) {
                    count++;
                }
                map.put(s, count);
            }
        }
        System.out.println(map);
    }
}

