package com.zoerAleksandr.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 15.03.2021 11:50
 */
public class lesson3{
    private static char[][] field;
    private static final char HUMAN = 'X';
    private static final char AI = 'O';
    private static final char EMPTY = '*';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int victoryCount;

    // координаты установленного значения Игрока
    private static int xH;
    private static int yH;

    // координаты установленного значения Игрока
    private static int xA;
    private static int yA;

    public static void main(String[] args) {
        settingSize();
        printField();
        while (true) {
            humanMove();
            positionGood(xH, yH, HUMAN);
            if (victory(xH, yH, HUMAN)) {
                System.out.println(".....ПОЗДРАВЛЯЮ!!! ТЫ ПОБЕДИЛ!!!.....");
                break;
            }
            if (emptyCell()) {
                System.out.println(".....НИЧЬЯ, ДАВАЙ ЕЩЕ РАЗ?!.....");
                break;
            }
            aIMove();
            positionGood(xA, yA, AI);
            if (victory(xA, yA, AI)) {
                System.out.println(".....НА ЭТОТ РАЗ Я ОКАЗАЛСЯ СИЛЬНЕЕ.....");
                break;
            }
        }
    }

    // установка размера игрового поля пользователем
    private static void settingSize() {
        // размер игрового поля
        int xSize;
        int ySize;
        do {
            System.out.println("Привет, меня зовут Геркулес! \nЯ готов сыграть по твоим правилам! \nВведи размер игрового поля (не менее 3) >>>");
            xSize = SCANNER.nextInt();
            ySize = SCANNER.nextInt();
        } while (xSize < 3 && ySize < 3);

        field = new char[xSize][ySize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                field[j][i] = EMPTY;
            }
        }
        do {
            System.out.println("Отлично! Теперь введи размер выйгрышной комбинации (не меньше 3) >>>");
            victoryCount = SCANNER.nextInt();
        } while (victoryCount > xSize || victoryCount > ySize);
    }

    // вывод текущего поля
    private static void printField() {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print("| " + aChar + " ");
            }
            System.out.println("|");
        }
    }

    // ход человека
    private static void humanMove() {
        do {
            System.out.println("Твой ход >>>");
            xH = SCANNER.nextInt() - 1;
            yH = SCANNER.nextInt() - 1;
        }
        while (xH < 0 || xH >= field[0].length || yH < 0 || yH >= field.length || field[yH][xH] != EMPTY);

        field[yH][xH] = HUMAN;
        printField();
    }

    // ход AI
    private static void aIMove() {
        int[] posGoodH = positionGood(xH, yH, HUMAN);
        int[] posGoodAi = positionGood(xA, yA, AI);
        int[] posEmpty = positionNearbyAnyVal(xA, yA);
        // если у игрока 2 и больше соседние клетки, ставим 0 в этом направлении
        if (posGoodH != null && field[posGoodH[0]][posGoodH[1]] == EMPTY) {
            field[posGoodH[0]][posGoodH[1]] = AI;
            System.out.println("Я понял, что ты задумал! ;)");
            printField();
            // если у AI 2 и больше соседние клетки, ставим 0 в этом направлении
        }else if(posGoodAi != null && yA != 0 && xA != 0){
            field[posGoodAi[0]][posGoodAi[1]] = AI;
            System.out.println("Удача на моей стороне!!");
            printField();
        }
        // если есть одна заполненная клетка, ставим 0 рядом с ней
        else if (posEmpty != null && yA != 0 && xA != 0) {
            field[posEmpty[0]][posEmpty[1]] = AI;
            System.out.println("Кажется я придумал неплохой ход!");
            printField();
            // или рандомно выбираем клетку
        } else {
            do {
                xA = RANDOM.nextInt(3);
                yA = RANDOM.nextInt(3);

            } while (field[yA][xA] != EMPTY);
            field[yA][xA] = AI;
            System.out.println("Хмм... Поставлю наугад!");
            printField();
        }
    }

    // Проверки на выход за границы поля
    private static boolean xLeft(int x) {
        return x - 1 >= 0;
    }

    private static boolean xRight(int x) {
        return x + 1 < field[0].length;
    }

    private static boolean yTop(int y) {
        return y - 1 >= 0;
    }

    private static boolean yBottom(int y) {
        return y + 1 < field.length;
    }

    // получаем координаты соседних клеток
    private static int[][] positionNearby(int x, int y) {
        // верхняя левая позиция
        if (!xLeft(x) && !yTop(y) && xRight(x) && yBottom(y)) {
            return new int[][]{{y + 1, x + 1}, {y, x + 1}, {y + 1, x}};
        }
// верхняя позиция
        else if (!yTop(y) && xLeft(x) && xRight(x) && yBottom(y)) {
            return new int[][]{{y, x - 1}, {y + 1, x - 1}, {y + 1, x}, {y + 1, x + 1}, {y, x + 1}};
        }
// верхняя правая позиция
        else if (!yTop(y) && !xRight(x) && yBottom(y) && xLeft(x)) {
            return new int[][]{{y, x - 1}, {y + 1, x - 1}, {y + 1, x}};
        }
// правая позиция
        else if (!xRight(x) && xLeft(x) && yBottom(y) && yTop(y)) {
            return new int[][]{{y - 1, x}, {y - 1, x - 1}, {y, x - 1}, {y + 1, x - 1}, {y + 1, x}};
        }
// правая нижняя позиция
        else if (!xRight(x) && !yBottom(y) && xLeft(x) && yTop(y)) {
            return new int[][]{{y - 1, x}, {y - 1, x - 1}, {y, x - 1}};
        }
// нижняя позиция
        else if (!yBottom(y) && yTop(y) && xLeft(x) && xRight(x)) {
            return new int[][]{{y, x - 1}, {y - 1, x - 1}, {y - 1, x}, {y - 1, x + 1}, {y, x + 1}};
        }
// нижняя левая позиция
        else if (!yBottom(y) && !xLeft(x) && yTop(y) && xRight(x)) {
            return new int[][]{{y - 1, x}, {y - 1, x + 1}, {y, x + 1}};
        }
// левая позиция
        else if (!xLeft(x) && xRight(x) && yTop(y) && yBottom(y)) {
            return new int[][]{{y - 1, x}, {y - 1, x + 1}, {y, x + 1}, {y + 1, x + 1}, {y + 1, x}};
        }
// средняя позиция
        else {

            return new int[][]{{y - 1, x}, {y - 1, x + 1}, {y, x + 1}, {y + 1, x + 1}, {y + 1, x}, {y - 1, x - 1}, {y, x - 1}, {y + 1, x - 1}};
        }
    }

    // получаем значения соседних клеток
    private static char[] valueNearby(int x, int y) {
        // создаем массив значений
        int[][] positionNearby = positionNearby(x, y);
        char[] valueNearby = new char[positionNearby.length];
        // заполняем массив значений
        for (int i = 0; i < positionNearby.length; i++) {
            valueNearby[i] = field[positionNearby[i][0]][positionNearby[i][1]];
        }
        return valueNearby;
    }

    // проверка наличия свободный клеток
    private static boolean emptyCell() {
        for (char[] chars : field) {
            for (char aChar : chars) {
                if (aChar == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // проверка победы
    private static boolean victory(int x, int y, char c) {
        int[] trend = new int[2];
        int[][] positionNearby = positionNearby(x, y);
        char[] valueNearby = valueNearby(x, y);
        for (int i = 0; i < valueNearby.length; i++) {
            // если значение соседа совпадает, проверить если ли дальше клетка
            if (valueNearby[i] == c) {
                trend[0] = y - positionNearby[i][0];
                trend[1] = x - positionNearby[i][1];
                // двигаемся по тренду пока не сменится значение клетки или не закончится поле
                int count1 = 0;
                int y1;
                int x1;
                do {
                    count1++;
                    y1 = y + trend[0] * count1;
                    x1 = x + trend[1] * count1;
                }
                while (y1 >= 0 && y1 < field.length && x1 >= 0 && x1 < field[1].length && field[y1][x1] == c);

                // после этого разворачиваемся и считаем количество совпадений
                int count2 = 0;
                int y2;
                int x2;
                do {
                    count2++;
                    y2 = y1 - trend[0] * count2;
                    x2 = x1 - trend[1] * count2;
                }
                while (y2 >= 0 && y2 < field.length && x2 >= 0 && x2 < field[1].length && field[y2][x2] == c);
                // если количество совпадений == выйгрышной комбинации - победа
                if (count2 - 1 == victoryCount) return true;
            }
        }
        return false;
    }

    // удачный ход
    private static int[] positionGood(int x, int y, char c) {
        int[][] positionNearby = positionNearby(x, y);
        char[] valueNearby = valueNearby(x, y);
        int[] positionGood = null;
        for (int i = 0; i < valueNearby.length; i++) {
            // если значение соседа совпадает, проверить если ли дальше клетка
            if (valueNearby[i] == c) {
                int[] trend = new int[2];
                trend[0] = y - positionNearby[i][0];
                trend[1] = x - positionNearby[i][1];
                // двигаемся по тренду пока не сменится значение клетки или не закончится поле
                int count1 = 0;
                int y1;
                int x1;
                do {
                    count1++;
                    y1 = y + trend[0] * count1;
                    x1 = x + trend[1] * count1;
                }
                while (y1 >= 0 && y1 < field.length && x1 >= 0 && x1 < field[1].length && field[y1][x1] == c);

                // после этого разворачиваемся и считаем количество совпадений
                int count2 = 0;
                int y2;
                int x2;
                positionGood = new int[2];
                do {
                    count2++;
                    y2 = y1 - trend[0] * count2;
                    x2 = x1 - trend[1] * count2;
                    positionGood[0] = y2;
                    positionGood[1] = x2;
                }
                while (y2 >= 0 && y2 < field.length && x2 >= 0 && x2 < field[1].length && field[y2][x2] == c);
            }
        }
        return positionGood;
    }

    // получение координаты соседней клетки c заданным значением
    private static int[] positionNearbyAnyVal(int x, int y) {
        char c = field[y][x];
        int[][] positionNearby = positionNearby(x, y);
        char[] valueNearby = valueNearby(x, y);
        int[] arr = new int[2];
        for (int i = 0; i < valueNearby.length; i++) {
            if (valueNearby[i] == c) {
                arr[0] = positionNearby[i][0];
                arr[1] = positionNearby[i][1];
                return arr;
            }
        }
        return null;
    }
}
