package com.zoerAleksandr.lesson11.food;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 07.04.2021 23:41
 */


/*
        Задача:
        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;
        Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
        true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку
        с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        Не забываем про метод добавления фрукта в коробку.
*/

public class Main {
    public static void main(String[] args) {
        Orange[] oranges = {
                new Orange(), new Orange(), new Orange(), new Orange(), new Orange(),
        };
        Apple[] apples = {
                new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple(),
        };
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        orangeBox1.addFruit(oranges[0]);
        orangeBox1.addFruit(oranges[1]);

        appleBox1.addFruit(apples[0]);
        appleBox1.addFruit(apples[1]);
        appleBox1.addFruit(apples[2]);
        appleBox2.addFruit(apples);
        appleBox2.addFruit(apples, 6, 7);

        System.out.println(appleBox1.getWeightBox());
        System.out.println(orangeBox1.getWeightBox());
        System.out.println(appleBox1.compare(orangeBox1));

        System.out.println(orangeBox1.getWeightBox());
        System.out.println(orangeBox2.getWeightBox());
        orangeBox2.pour(orangeBox1);
        System.out.println(orangeBox1.getWeightBox());
        System.out.println(orangeBox2.getWeightBox());
    }
}
