package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class FizzBuzzTest {
    //при сранении ссылочных переменных сравниваются ссылки на объект
    public static Boolean fizzbuzz(String actual, String expected){
        return (actual.equals(expected));
    }

    public static void main(String[] args) {
       // System.out.println(fizzbuzz("Hi", "Hello"));

        //System.out.println(fizzbuzz(FizzBuzz.fizzBuzz(3), "Fizz")); //use inline

        System.out.println(SimpleUnit.nofizzbuzz1(FizzBuzz.fizzBuzz(43), "Fizz")); //не равен
        System.out.println(SimpleUnit.nofizzbuzz1(FizzBuzz.fizzBuzz(23), "Fizz"));
        System.out.println(SimpleUnit.nofizzbuzz1(FizzBuzz.fizzBuzz(4), "Buzz"));
        System.out.println(SimpleUnit.nofizzbuzz1(FizzBuzz.fizzBuzz(13), "FizzBuzz"));

        System.out.println(SimpleUnit.fizzbuzz1(FizzBuzz.fizzBuzz(21), "Fizz")); //равен
        System.out.println(SimpleUnit.fizzbuzz1(FizzBuzz.fizzBuzz(33), "Fizz"));
        System.out.println(SimpleUnit.fizzbuzz1(FizzBuzz.fizzBuzz(10), "Buzz"));
        System.out.println(SimpleUnit.fizzbuzz1(FizzBuzz.fizzBuzz(20), "Buzz"));
        System.out.println(SimpleUnit.fizzbuzz1(FizzBuzz.fizzBuzz(15), "FizzBuzz"));

    }
}
