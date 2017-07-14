package Lesson6;

import java.util.Arrays;

/**
 * Created by arina on 04.07.17.
 */
public class ArraysEx {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,3,4,2,4,5,8};
        int [][] m3;
        m3 = new int [2][];
        System.out.println(Arrays.toString(m3));

        m3[0] = new int[3];
        m3[1] = new int[3];
        Arrays.sort(a);

        System.out.println(Arrays.toString(a));
    }
}
