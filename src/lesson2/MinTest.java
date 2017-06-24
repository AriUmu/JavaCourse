package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class MinTest {
    public static void main(String[] args) {
        System.out.println(SimpleUnit.fizzbuzz1(MinUnit.min(10,20), 10));
        System.out.println(SimpleUnit.fizzbuzz1(MinUnit.min(Integer.MIN_VALUE,0), Integer.MIN_VALUE));
        System.out.println(SimpleUnit.fizzbuzz1(MinUnit.min(-10,0), -10));
        System.out.println();

        System.out.println(SimpleUnit.nofizzbuzz1(MinUnit.min(-10,0), 0));
        System.out.println(SimpleUnit.nofizzbuzz1(MinUnit.min(2,2), -3));
        System.out.println(SimpleUnit.nofizzbuzz1(MinUnit.min(Integer.MIN_VALUE,Byte.MIN_VALUE), -128));

    }
}
