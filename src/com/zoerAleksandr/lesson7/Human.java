package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:13
 */
class Human implements Moving {
    private int maxJump;
    private int maxRun;

    Human(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.print("Человек прыгает - ");
    }

    @Override
    public void run() {
        System.out.print("Человек бежит - ");
    }

    @Override
    public int maxRun() {
        return this.maxRun;

    }

    @Override
    public int maxJump() {
        return maxJump;
    }

}
