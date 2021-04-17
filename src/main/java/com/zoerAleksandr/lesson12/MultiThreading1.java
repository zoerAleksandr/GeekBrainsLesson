package com.zoerAleksandr.lesson12;

import java.util.Arrays;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 13.04.2021 13:28
 */

public class MultiThreading1 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr1 = newArr(SIZE);
        method1(arr1);

        float[] arr2 = newArr(SIZE);
        method2(arr2);

        if(Arrays.equals(arr1, arr2)) System.out.println("Массивы одинаковые");
        else System.out.println("Массивы не одинаковые");

    }

    private static void method2(float[] arr) {
        float[] arr2_1 = new float[HALF];
        float[] arr2_2 = new float[HALF];

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr2_1, 0, HALF);
        System.arraycopy(arr, HALF, arr2_2, 0, HALF);

        Thread t1 = new Thread(() -> initialization(arr2_1, 0));
        Thread t2 = new Thread(() -> initialization(arr2_2, HALF));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr2_1, 0, arr, 0, HALF);
        System.arraycopy(arr2_2, 0, arr, HALF, HALF);
        System.out.println("Время выполнения в двух потоках - " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void method1(float[] arr) {
        long start = System.currentTimeMillis();
        initialization(arr, 0);
        System.out.println("Время выполнения в одном потоке - " + (System.currentTimeMillis() - start) + "ms.");
    }

    private static float[] newArr(int s) {
        float[] arr = new float[s];
        Arrays.fill(arr, 1.0f);
        return arr;
    }

    private static void initialization(float[] floats, int i) {
        for (int j = 0; j < floats.length; j++) {
            floats[j] = (float) (floats[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            i++;
        }
    }
}
