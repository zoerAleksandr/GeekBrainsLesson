package com.zoerAleksandr.lesson9;

import java.sql.SQLException;


/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 30.03.2021 12:29
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Пушок", "белый", 2),
                new Cat("Васька", "рыжий", 1),
                new Cat("Перcик", "черный", 4),
                new Cat("Дымок", "бурый", 3),
                new Cat("Букса", "грязный", 9),
        };

        try {
            AddCats.clear();
            AddCats.addCats(cats);
            System.out.println(AddCats.readName());
            System.out.println(AddCats.readColor());
            System.out.println(AddCats.readAge());
            AddCats.dataCat(0);
            AddCats.updateName();
            System.out.println(AddCats.readName());
        } catch (SQLException e) {
            System.out.println("Какая-то проблема с БД");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
