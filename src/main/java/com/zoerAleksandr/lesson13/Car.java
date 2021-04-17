package com.zoerAleksandr.lesson13;

import java.util.concurrent.CyclicBarrier;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 17.04.2021 19:03
 */
public class Car implements Runnable {
    final static CyclicBarrier cb = new CyclicBarrier(Main.CARS_COUNT);
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cb.await();
            System.out.println(this.name + " готов");
            Main.cdl.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (this){
            if (Main.winn == 0) {
                Main.winn++;
                winn();
            }
        }
        Main.cdl2.countDown();
    }

    private synchronized void winn() {
        System.out.println(this.name + " пришел первым!");
    }
}
