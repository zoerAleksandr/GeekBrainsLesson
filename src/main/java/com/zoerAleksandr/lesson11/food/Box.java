package com.zoerAleksandr.lesson11.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 07.04.2021 18:08
 */

class Box<F extends Fruit> {
    private ArrayList<F> list = new ArrayList<>();
//    private float weight = 0.0f;

    //    Добавление фрукта в коробку
    void addFruit(F fruit) {
        list.add(fruit);
    }

    void addFruit(F[] fruits) {
        list.addAll(Arrays.asList(fruits));
    }

    void addFruit(F[] fruits, int from, int to) {
        F[] arr = Arrays.copyOfRange(fruits, from, to);
        list.addAll(Arrays.asList(arr));
    }

    //    Сравнение веса коробок
    boolean compare(Box box) {
        return Math.abs(this.getWeightBox() - box.getWeightBox()) < 0.00001;
    }

    //    Получение веса коробки
    float getWeightBox() {
        float w = 0;
        for (F f : list) {
            w += f.getWeight();
        }
        return w;
    }
    // Пересыпание
    void pour(Box<F> box){
        if(!box.list.isEmpty()){
            list.addAll(box.list);
            box.list.clear();
        }
    }

}
