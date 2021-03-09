package com.zoerAleksandr.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 06.03.2021 13:02
 */
public class lesson3 {
    private static char[][] field;
    private static final char HUMAN = 'X';
    private static final char AI = 'O';
    private static final char EMPTY = '*';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int countValue = 0;
    // координаты установленного значения
    private static int x;
    private static int y;
    // координаты преддпологаемого соседа второго уровня
    private static int x2;
    private static int y2;

    public static void main(String[] args) {
// 1. Задаем размер игрового поля и заполняем его EMPTY значениями
        settingSize();
// 2. Вывод поля на экран
        printField();
// 3. Ход игрока
        while (true) {
            humanMove();
            countValue = countValue(neighbourPosition(x, y), HUMAN);
            if(victory(HUMAN)){
                break;
            }
            // 4. Ход AI
            aiMove();
            countValue = countValue(neighbourPosition(x, y), AI);
            if(victory(AI)){
                break;
            }
        }
    }
// установка размера игрового поля пользователем
    private static void settingSize() {

        do {
            System.out.println("Привет, введи размер игрового поля (не менее 3) >>>");
            x = SCANNER.nextInt();
            y = SCANNER.nextInt();
        } while (x < 3 && y < 3);

        field = new char[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                field[j][i] = EMPTY;
            }
        }
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
            System.out.println("Ваш ход >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (x < 0 || x >= field[0].length || y < 0 || y >= field.length || field[y][x] != EMPTY);

        field[y][x] = HUMAN;
        printField();
    }
// ход AI
    private static void aiMove() {
        do {
            x = RANDOM.nextInt(3);
            y = RANDOM.nextInt(3);

        } while (field[y][x] != EMPTY);
        field[y][x] = AI;
        System.out.println("Ход AI");
        printField();
    }
// проверка победы
    private static boolean victory(char c){
        boolean victory = false;
         if(countValue != 0){
// если имеется соседняя клетка с таким же символом
             int[][] arrTrend = trend(c, countValue); // массив направлений
// проверяем каждое совпадение
             for (int i = 0; i < arrTrend.length; i++){
                 int a = arrTrend[i][0];
                 int b = arrTrend[i][1];
                 // координаты предполагаемого соседа 1 уровня. Его проверяем на наличие соседа в том же направлении
                 int y1 = y + a;
                 int x1 = x + b;
                 // если клетка в этом направлении имеется, проверяем как она заполнена
                 if (trendCorrect(arrTrend, i, x1, y1) && value(x2, y2) == c){
                     System.out.println("!!!!!!!!!! VICTORY!!!!!!!!!!!!!");
                     victory = true;
                 }
             }
         }
    return victory;
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
// для получения координаты всех соседних клеток
    private static int[][] neighbourPosition(int x, int y) {
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
// для получения количества совпадений для определения размера массива с совпадениями
    private static int countValue(int[][] position, char c) {
// получаем значения всех соседних клеток
        char[] value = new char[position.length];
        for (int i = 0;i < position.length; i++){
            value[i] = field[position[i][0]][position[i][1]];
        }
// считаем совпадения с искомым числом
        int count = 0;
        for (char item : value) {
            if (item == c) {
                count++;
            }
        }
        return count;
    }
// из соседних клеток выбираем те, которые содержат искомую переменную и возвращаем ее (их) координаты
    private static int[][] matchesPosition(int[][] position, char c, int count) {
        int[][] matchesPosition = new int[count][2];
        int e = 0; // счетчик для последовательного добавления в matchesPosition[][]
        int n, m; // для удобства ))
        for (int[] ints : position) {
            n = ints[0];
            m = ints[1];
            if (field[n][m] == c) {
                matchesPosition[e][0] = n;
                matchesPosition[e][1] = m;
                e++;
            }
        }
        return matchesPosition;
    }
// для определения направления соответствия
    private static int[][] trend(char c, int countValue){
        int[][] arr = matchesPosition(neighbourPosition(x, y), c, countValue); // массив всех совпадение
        int[][] arrTrend = new int[countValue][2];
        for (int i = 0; i < arr.length; i++){
// определяем ее направление относительно введенной
            arrTrend[i][0] = arr[i][0] - y;
            arrTrend[i][1] = arr[i][1] - x;
        }
        return arrTrend;
    }
// для определения есть ли в этом направлении клетка в пределах поля
    private static boolean trendCorrect(int[][] arrTrend, int i, int x, int y){ // где
       int a = arrTrend[i][0];
       int b = arrTrend[i][1];
       // координаты предполагаемого соседа 2 уровня
       int y1 = y + a;
       int x1 = x + b;
       boolean result = false;
       int[][] arrNeighbour1 = neighbourPosition(x, y); // соседние клетки проверяемого соседа
       // проверяем существует ли клетка с такими координатами
        for (int[] ints : arrNeighbour1) {
            if (y1 == ints[0] && x1 == ints[1]) {
                y2 = ints[0];
                x2 = ints[1];
                result = true;
            }
        }
       return result;
    }
// для проверки клетки на наличие нужного значения
    private static char value(int x, int y){
        return field[y][x];
    }
}