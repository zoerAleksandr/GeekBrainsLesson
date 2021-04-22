package com.zoerAleksandr.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 20.04.2021 14:53
 */
/*Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
*/
public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Integer[] a2 = {1, 1, 1, 1, 4};
        System.out.println(Arrays.toString(myMethod(a)));
        System.out.println(myMethod2(a2));

    }

    static Integer[] myMethod(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        if (!list.contains(4)) throw new RuntimeException();
        list.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 4) list.add(0, arr[i]);
            else if (arr[i] == 4) break;
        }
        list.trimToSize();
        return list.toArray(new Integer[0]);
    }

    static boolean myMethod2(Integer[] arr) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        if (list.contains(1) && !list.contains(4)) return false;
        else if (!list.contains(1) && list.contains(4)) return false;
        for (Integer i : list) {
            if (i != 1 && i != 4) return false;
        }
        return true;
    }
}
