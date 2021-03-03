package com.zoerAleksandr.lesson2;

import java.util.Arrays;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 03.03.2021 23:36
 */
public class lesson2 {
    public static void main(String[] args) {

// 1 task
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array1.length; i++){
            switch (array1[i]){
                case (1):
                    array1[i] = 0;
                    break;
                case (0):
                    array1[i] = 1;
                    break;
            }
        }
        System.out.println(Arrays.toString(array1));

// 2 task
        int[] array2 = new int[8];
        for (int i = 0, j = 0; i < array2.length; i++, j+= 3){
            array2[i] = j;
        }
        System.out.println(Arrays.toString(array2));

// 3 task
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array3.length; i++){
            if(array3[i] < 6){
                array3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array3));

// 4 task
        int[][] array4 = new int[5][5];
        int x = 0;
        int y = array4.length - 1;
        for (int i = 0; i < array4.length; i++){
            array4[i][x] = 1;
            array4[i][y] = 1;
            x++;
            y--;
        }
        System.out.println(Arrays.deepToString(array4));

// 5 task
        int[] array5 = {1, 4, 40, 23, 9, 0, 35, 19};
        System.out.println("Минимальное число массива = " + minimum(array5) + ", максимальное число массива = " + maximum(array5));

// 6 task
        int[] array6 = {8, 2, 2, 4, 4};
        System.out.println(task6(array6));

// 7 task

        int[] array7 = {2, 4, 5, 3};
        int n = 2;
        System.out.println(Arrays.toString(task7(array7, n)));

    }

    private static int minimum(int[] array){
        Arrays.sort(array);
        return array[0];
    }
    private static int maximum(int[] array){
        Arrays.sort(array);
        return array[array.length - 1];
    }
    private static boolean task6 (int[] array){
        int count = 1;
        boolean b = false;
// начинаем проверку между значениями с индексом 0 и 1, продолжаем пока не закончится массив
        while (count <= array.length){
            int rightSum = 0; // сумма значений справа от выбранного места
            int leftSum = 0; // сумма значений слева от выбранного места
            int[] right = Arrays.copyOfRange(array, count, array.length);
            for (int i : right){
                rightSum += i;
            }
            int[] left = Arrays.copyOfRange(array, 0, count);
            for (int i : left){
                leftSum += i;
            }
            if (rightSum == leftSum) {
                b = true;
                System.out.println("Требуемое место между значениями с индексом " + (count - 1) + " и " + count);
                break;
            }
            count++;
        }
        return b;
    }
    private static int[] task7 (int[] array, int n){
        int count = 0; // счетчик сдвигов
        while (count != n){
            int j;
            // если число n > 0 - сдвигаем массив влево
            if(n > 0){
                j = array[0];
                for (int i = 0; i < array.length; i++){
                    if(i + 1 < array.length){
                        array[i] = array[i + 1];
                    }else {
                        array[i] = j;
                    }
                }
                count++;
            }
            // если число n < 0 - сдвигаем массив вправо
            else {
                j = array[array.length - 1];
                for (int i = array.length - 1; i >= 0;i--){
                    if(i > 0){
                        array[i] = array[i - 1];

                    }else {
                        array[i] = j;
                    }
                }
                count--;
            }
        }

        return array;
    }

}

