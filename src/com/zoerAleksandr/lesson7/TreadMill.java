package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:16
 */
class TreadMill implements Pass {
    private int length;

    TreadMill(int length) {
        this.length = length;
    }

    @Override
    public boolean pass(Moving moving) {
        moving.run();
        if (moving.maxRun() >= length) {
            System.out.println("Пробежал");
            return true;
        } else {
            System.out.println("Не смог пробежать");
            return false;
        }
    }
}
