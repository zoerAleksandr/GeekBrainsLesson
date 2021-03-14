package com.zoerAleksandr.lesson4;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 14.03.2021 16:12
 */
public class Employee {
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

    void printInfo(){
        System.out.printf("ФИО: %s \nДолжность: %s \nEmail: %s \nНомер телефона: %d \nЗарплата: $%d  \nВозраст: %d лет\n\n",
                this.name, this.post, this.email, this.phoneNumber, this.salary, this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
