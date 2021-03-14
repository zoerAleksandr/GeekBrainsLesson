package com.zoerAleksandr.lesson4;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 14.03.2021 16:11
 */
public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "директор", "ivanov@gmail.com",
                12345678, 1000, 45);
        employees[1] = new Employee("Петров Петр Петрович", "водитель", "petrov@gmail.com",
                12365478, 300, 34);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "охранник", "sidorov@gmail.com",
                456789123, 400, 30);
        employees[3] = new Employee("Васин Василий Васильевич", "повар", "vasin@gmail.com",
                12365478, 350, 50);
        employees[4] = new Employee("Сергеев Сергей Сергеевич", "швейцар", "segeev@gmail.com",
                12365478, 500, 65);

        input(employees);
    }

    private static void input(Employee[] arr) {
        for (Employee emp : arr) {
            if (emp.getAge() > 40) {
                emp.printInfo();
            }
        }
    }
}
