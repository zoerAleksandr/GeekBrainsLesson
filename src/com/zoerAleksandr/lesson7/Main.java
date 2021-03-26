package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:54
 */
public class Main {
    public static void main(String[] args) {
        Moving[] movings = {
                new Human(2, 10),
                new Cat(3, 4),
                new Robot(4, 25)
        };
        Pass[] passes = {
                new Wall(1),
                new TreadMill(10),
                new Wall(3),
                new TreadMill(12),
                new TreadMill(30)
        };
        for (Moving moving : movings) {
            for (Pass p : passes) {
                if (!p.pass(moving)) {
                    System.out.println("Выбыл");
                    break;
                }
            }
        }
    }
}
