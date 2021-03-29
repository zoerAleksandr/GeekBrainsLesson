package com.zoerAleksandr.lesson7;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 26.03.2021 13:15
 */
class Wall implements Pass {
    private int height;

    Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean pass(Moving moving) {
        moving.jump();
        if (moving.maxJump() >= height) {
            System.out.println("Перепрыгнул");
            return true;
        } else {
            System.out.println("Не смог перепрыгнуть");
            return false;
        }
    }
}
