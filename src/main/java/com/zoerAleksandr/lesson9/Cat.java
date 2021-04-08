package com.zoerAleksandr.lesson9;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 01.04.2021 21:36
 */
class Cat {
    private String name;
    private String color;
    private int age;

    Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    String getName() {
        return name;
    }

    String getColor() {
        return color;
    }

    int getAge() {
        return age;
    }
}
