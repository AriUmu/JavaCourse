package Lesson4;

/**
 * Created by arina on 29.06.17.
 */
public class A {

    static final int MAX = 10; //константы выполняются перед инициализайией
    static String s = init(); // выполняется первым class field
    int x; // instance field

    private static String init() { //третим идем явное выполнение метода
        System.out.println("init");
        return "Hello";
    }

   static  {
       System.out.println("init 2"); //выполняется второй
    }

}
