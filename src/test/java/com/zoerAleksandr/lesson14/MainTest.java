package com.zoerAleksandr.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 24.04.2021 18:00
 */
class MainTest {

    // метод не работает, не нашел как записать массив в csv
/*
    @CsvFileSource(files = {"Test_Source/test.csv"})
    @ParameterizedTest
    void paramTest(Integer[] arr1, Integer[] arr2){
        Assertions.assertArrayEquals(arr1, Main.myMethod(arr2));
    }*/

    @Test
    void myMethodTest1() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        Integer[] arr1_1 = {5, 6};
        Assertions.assertArrayEquals(arr1_1, Main.myMethod(arr1));

        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 4};
        Integer[] arr2_1 = {};
        Assertions.assertArrayEquals(arr2_1, Main.myMethod(arr2));

        Integer[] arr3 = new Integer[0];
        Assertions.assertArrayEquals(null, Main.myMethod(arr3));
    }

    @Test
    void myMethodTest2() {
        Integer[] arr2 = {1, 2, 3, 5, 6};
        Assertions.assertThrows(RuntimeException.class, () -> Main.myMethod(arr2));
    }

    @Test
    void myMethod2Test() {
        Integer[] arr1 = {1, 1, 1, 4, 4, 1};
        Integer[] arr2 = {2, 1, 1, 4, 4, 1};
        Integer[] arr3 = {1, 1, 1, 1, 1, 1, 1};
        Integer[] arr4 = {4, 4, 4, 4, 4, 4, 4};

        Assertions.assertTrue(Main.myMethod2(arr1));
        Assertions.assertFalse(Main.myMethod2(arr2));
        Assertions.assertFalse(Main.myMethod2(arr3));
        Assertions.assertFalse(Main.myMethod2(arr4));
    }
}