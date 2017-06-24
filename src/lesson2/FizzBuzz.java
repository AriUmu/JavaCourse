package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class FizzBuzz {  //Test Diven Developen TDD
    //для перемещен я в другой класс use "move to";
    static String fizzBuzz(int i) {
        String result = "";
        if(i % 3 == 0){
            result = result + "Fizz";
        }
        if(i % 5 == 0){
            result = result + "Buzz";
        }
        return "".equals(result)?Integer.toString(i):result;
    }
}
