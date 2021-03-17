package com.zoerAleksandr.lesson4;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 14.03.2021 17:22
 */
class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Директор", "ivanov@gmail.com",
                12345678, 1000, 45);
        employees[1] = new Employee("Петров Петр Петрович", "Охранник", "petrov@gmail.com",
                123654789, 600, 27);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Водитель", "sidorov@gmail.com",
                123987456, 300, 31);
        employees[3] = new Employee("Сергеев Сергей Сергеевич", "Повар", "sergeev@gmail.com",
                123654987, 500, 56);
        employees[4] = new Employee("Кириллов Кирилл Кириллович", "Швейцар", "kirillov@gmail.com",
                147258369, 550, 68);

        input(employees);
    }

    private static void input(Employee[] arr) {
        for (Employee e : arr) {
            if (e.getAge() > 40) {
                e.print();
            }
        }
    }
}
