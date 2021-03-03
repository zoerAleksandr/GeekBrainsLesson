package com.zoerAleksandr.lesson1;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 03.03.2021 23:28
 */
public class lesson1 {
    public static void main(String[] args) {
// 1 task
        double d = method1(1, 2, 3, 4);
        System.out.println(d);
// 2 task
        System.out.println(method2(1, 2));
// 3 task
        int a = 3;
        method3(a);
// 4 task
        String name = "Александр";
        System.out.println(method4(name));
// 5 task
        int c = 2536;
        System.out.println(method5(c));
    }

    private static double method1(int a, int b, int c, int d) {
        double result = a * (b + ((1.0) * c / d));
        return result ;
    }
    private static boolean method2(int a, int b){
        boolean result;
        int c = a + b;
        if (c >= 10 && c <= 20){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
    private static void method3(int a){
        String s;
        if(a % 2 == 0){
            s = a + " - положительное число";
        }else {
            s = a + " - отрицательное число";
        }
        System.out.println(s);
    }
    private static String method4(String s){
        String text = "Привет, " + s + "!";
        return text;
    }
    private static String method5(int a){
        String s;

        if((a % 4 == 0 && a % 100 != 0) || a % 400 == 0){
            s = a + "г. - является високосным годом";
        }else {
            s = a + "г. - является невисокосным годом";
        }
        return s;
    }
}
