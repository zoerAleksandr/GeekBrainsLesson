package com.zoerAleksandr.lesson5;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 17.03.2021 15:45
 */
class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dogs("Барбос", 10, 2),
                new Dogs("Пегас", 9, 3),
                new Cats("Пушок", 2, 0),
                new Cats("Васька", 3, 0),
        };
        System.out.printf("Всего животных - %d \nИз них собак - %d, кошек - %d.\n\n", Animal.getCountAnimal(),
                Dogs.getCountDogs(), Cats.getCountCats());
        for (Animal animal : animals) {
            animal.run(10);
            animal.swim(3);
        }
    }
}

class Animal {
    private static int countAnimal;
    String name;
    private int maxRun;
    private int maxSwim;
    String type;

    Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        countAnimal++;
    }

    void run(int distance) {
        if (this.maxRun >= distance) {
            System.out.printf("%s %s пробежал дистанцию в %d км!\n", this.type, this.name, distance);
        } else {
            System.out.printf("%s %s не смог пробежать дистанцию в %d км :(" +
                    "" + "Он остановился на %d км.\n", this.type, this.name, distance, this.maxRun);
        }
    }

    protected void swim(int distance) {
        if (this.maxSwim >= distance) {
            System.out.printf("%s %s проплыл дистанцию в %d км!\n\n", this.type, this.name, distance);
        } else {
            System.out.printf("%s %s не смог проплыть дистанцию в %d км :(" +
                    " Он остановился на %d км.\n\n", this.type, this.name, distance, this.maxSwim);
        }
    }

    static int getCountAnimal() {
        return countAnimal;
    }
}

class Dogs extends Animal {

    private static int countDogs;


    Dogs(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        this.type = "Собака";
        countDogs++;
    }

    static int getCountDogs() {
        return countDogs;
    }
}

class Cats extends Animal {

    private static int countCats;

    Cats(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        this.type = "Кот";
        countCats++;
    }

    @Override
    protected void swim(int distance) {
        System.out.printf("%s %s не вышел на старт! Коты не любят плавать.\n\n", this.type, this.name);
    }

    static int getCountCats() {
        return countCats;
    }
}
