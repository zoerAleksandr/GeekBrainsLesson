package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:14
 */
class Robot implements Moving {
    private int maxJump;
    private int maxRun;

    Robot(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.print("Робот прыгает - ");
    }

    @Override
    public void run() {
        System.out.print("Робот бежит - ");
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
