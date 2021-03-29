package com.zoerAleksandr.lesson8;


/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 29.03.2021 14:27
 */
public class Main {
    public static void main(String[] args) {

        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "щ", "3", "3"},
                {"4", "4", "4", "4"},
                // {"4", "4", "4", "4"},
        };

        try {
            System.out.println(myMethod(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Что-то пошло не так!");
            e.printStackTrace();
        }
    }

    private static int myMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int i, j;
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неверное количество столбцов");
            for (j = 0; j < arr[i].length; j++) {
                // Здесь не придумал более короткой проверки, поэтому NumberFormatException бросает мое MyArrayDataException.
                // Смысла в этом нету но условие выполнено))
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат числа в " + (i + 1) + " строке, " + (j + 1) + " столбце");
                }
            }
        }
        return sum;
    }

    static class MyArraySizeException extends RuntimeException {
        MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends RuntimeException {
        MyArrayDataException(String message) {
            super(message);
        }
    }
}
