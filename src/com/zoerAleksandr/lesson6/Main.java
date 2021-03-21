package com.zoerAleksandr.lesson6;

import java.util.Scanner;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 22.03.2021 1:22
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Дымок", 3, false),
                new Cat("Пушок", 7, false),
                new Cat("Рыжик", 5, true)
        };
        Plate plate = new Plate(20);
        System.out.println("Сколько корма ты насыпешь в тарелку? >>> ");
        plate.append(scanner.nextInt());
        for (Cat cat : cats) {
            if (!cat.isFullness()) {
                cat.eat(plate);
            } else {
                System.out.printf("%s пока сыт. Попробуй покормить позже.\n", cat.getName());
            }
        }
    }
}
