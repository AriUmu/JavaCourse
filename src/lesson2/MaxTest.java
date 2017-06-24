package lesson2;

/**
 * Created by arina on 24.06.17.
 */
public class MaxTest {
    public static void main(String[] args) {
        System.out.println(SimpleUnit.fizzbuzz1(MaxUnit.max(10,20), 20));
        System.out.println(SimpleUnit.fizzbuzz1(MaxUnit.max(2,4), 4));
        System.out.println(SimpleUnit.fizzbuzz1(MaxUnit.max(Integer.MAX_VALUE,2), Integer.MAX_VALUE));
        System.out.println(SimpleUnit.fizzbuzz1(MaxUnit.max(-4,20), 20));
        System.out.println();


        System.out.println(SimpleUnit.nofizzbuzz1(MaxUnit.max(0,2), 0));
        System.out.println(SimpleUnit.nofizzbuzz1(MaxUnit.max(Integer.MAX_VALUE,20), 20));
        System.out.println(SimpleUnit.nofizzbuzz1(MaxUnit.max(-6,2), -6));
        System.out.println(SimpleUnit.nofizzbuzz1(MaxUnit.max(-4,-4), 6));

    }
}
