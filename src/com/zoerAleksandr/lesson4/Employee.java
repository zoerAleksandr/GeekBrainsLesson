package com.zoerAleksandr.lesson4;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 14.03.2021 17:23
 */
class Employee {
    private String name;
    private String post;
    private String email;
    private int phoneNumber;
    private int salary;
    private int age;

    Employee(String name, String post, String email, int phoneNumber, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void print() {
        System.out.printf("ФИО: %s \nДолжность: %s \nEmail: %s \nНомер телефона: %d \nЗарплата: $%d \nВозраст: %d \n\n",
                this.name, this.post, this.email, this.phoneNumber, this.salary, this.age);
    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPost() {
        return post;
    }

    void setPost(String post) {
        this.post = post;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    int getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    int getSalary() {
        return salary;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
}
