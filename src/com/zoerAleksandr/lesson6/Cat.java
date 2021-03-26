package com.zoerAleksandr.lesson6;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 22.03.2021 1:22
 */
class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    String getName() {
        return name;
    }

    boolean isFullness() {
        return fullness;
    }

    Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    void eat(Plate plate) {
        if (plate.getLeftover() < appetite) {
            this.fullness = false;
            System.out.printf("Скорее добавь еды в тарелку, %s все еще голоден!\n", this.name);
        } else {
            plate.eating(this.appetite);
            this.fullness = true;
            System.out.printf("Теперь %s сыт. Ты заботливый хозяин!\n", this.name);
        }
    }
}
