package Lesson4;

/**
 * Created by arina on 29.06.17.
 */
public class VaribleScope {

    static int m = 0; //время жизни - до конца программы

    static class A {
        int x; //хранится в куче время жизни = время жизни объекта
    }

    public static void m() {
        int x = 0; //локальная переменная ВЖ - до конца метода
    }
}
