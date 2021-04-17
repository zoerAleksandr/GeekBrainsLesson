package com.zoerAleksandr.lesson13;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 17.04.2021 19:06
 */
public abstract class Stage {
    int length;
    String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}

