package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class SimpleUnit { //типо фрейморк для тестирования

    public static Boolean fizzbuzz1(String actual, String expected){ //когда равен
        boolean equels = actual.equals(expected);
        if(equels){
          //  System.err.println("Test passed");
        }
        else {
          //  System.err.println("Test failted " + expected + " but actual " + actual);
        }
        return equels;
    }

    public static Boolean nofizzbuzz1(String actual, String expected){ //когда не равен
        boolean notequels = !actual.equals(expected);
        if(notequels){
           // System.err.println("Test failted " + expected + " but actual " + actual);
        }
        else {
           // System.err.println("Test passed");
        }
        return notequels;
    }


    public static Boolean fizzbuzz1(int actual, int expected){ //когда равен
        boolean equels = actual == expected;
        if(equels){

        }
        else {
            System.err.println("Test failted " + expected + " but actual " + actual);
        }
        return equels;
    }

    public static Boolean nofizzbuzz1(int actual, int expected){ //когда не равен
        boolean notequels = actual != expected;
        if(notequels){
            //System.out.println("Test passed");
        }
        else {
            System.err.println("Test failted " + expected + " but actual " + actual);
        }

        return notequels;
    }
}
