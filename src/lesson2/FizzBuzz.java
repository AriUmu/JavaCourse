package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class FizzBuzz {
    //при сранении ссылочных переменных сравниваются ссылки на объект
    public static Boolean fizzbuzz(String actual, String expected){
        return (actual.equals(expected));
    }


    public static void main(String[] args) {
        System.out.println("Start");
       // System.out.println(fizzbuzz("Hi", "Hello"));

        String result = fizzBuzz(3);

        System.out.println(fizzbuzz(fizzBuzz(3), "Fizz"));

        System.out.println(fizzbuzz1(fizzBuzz(3), "Fizz"));
        System.out.println(nofizzbuzz1(fizzBuzz(5), "Fizz"));


    }

    private static String fizzBuzz(int i) {
        return "Fizz";
    }

    public static Boolean fizzbuzz1(String actual, String expected){
        boolean equels = actual.equals(expected);
        if(equels){
            System.err.println("Test passed");
        }
        else {
            System.err.println("Test failted " + expected + " but actual " + actual);
        }
        return equels;
    }

    public static Boolean nofizzbuzz1(String actual, String expected){
        boolean notequels = !actual.equals(expected);
        if(notequels){
            System.err.println("Test failted " + expected + " but actual " + actual);
        }
        else {
            System.err.println("Test passed");
        }
        return notequels;
    }
}
