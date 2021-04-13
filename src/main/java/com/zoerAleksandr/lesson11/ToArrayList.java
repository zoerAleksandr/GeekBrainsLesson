package com.zoerAleksandr.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 07.04.2021 17:48
 */
public class ToArrayList {
    public static void main(String[] args) {
        Integer[] arr1 = {
                1, 2, 3, 4
        };
        String[] arr2 = {
                "1","2","3"
        };
        System.out.println(toArrayList(arr1));
        System.out.println(toArrayList(arr2));
        System.out.println(toArrayList(arr1).getClass().getName());
    }
    private static <L> ArrayList<L> toArrayList(L[] arr){
        ArrayList<L> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }
}
