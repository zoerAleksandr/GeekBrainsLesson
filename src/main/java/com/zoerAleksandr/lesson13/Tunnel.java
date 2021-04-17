package com.zoerAleksandr.lesson13;

import java.util.concurrent.Semaphore;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 17.04.2021 19:06
 */
public class Tunnel extends Stage {
    private final Semaphore semaphore = new Semaphore(Main.CARS_COUNT / 2, true);

    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
