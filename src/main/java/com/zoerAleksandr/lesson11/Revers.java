package com.zoerAleksandr.lesson11;

import java.util.Arrays;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 07.04.2021 17:33
 */
public class Revers {
    public static void main(String[] args) {
        String[] s = {"1", "2"};
        Integer[] i = {1, 2, 3};

        System.out.println(Arrays.toString(revers(s)));
        System.out.println(Arrays.toString(revers(i)));
    }

    private static <S> S[] revers(S[] arr) {
        S s0 = arr[0];
        S s1 = arr[1];
        arr[0] = s1;
        arr[1] = s0;
        return arr;
    }
}
