package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:13
 */
class Cat implements Moving {
    private int maxJump;
    private int maxRun;

    Cat(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.print("Кот прыгает - ");
    }

    @Override
    public void run() {
        System.out.print("Кот бежит - ");
    }

    @Override
    public int maxRun() {
        return maxRun;
    }

    @Override
    public int maxJump() {
        return maxJump;
    }
}
