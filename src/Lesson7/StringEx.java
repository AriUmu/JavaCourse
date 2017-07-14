package Lesson7;

import java.util.Arrays;

/**
 * Created by arina on 06.07.17.
 */
public class StringEx {

    public static void main(String[] args) {
        String s = "hi";
        int [] a = new int[10000];
        int[] b = {1,2,3,4,5,6,7};
        long start = System.currentTimeMillis();
        toString1(a);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);


    }

    private static String toString(int[] a){  //StringBuffer - thread-safe!!!
        StringBuilder sb = new StringBuilder("[");
        if(a.length > 0){
            sb.append(a[0]);
            for (int i = 1; i < a.length ; i++) {
                sb.append(a[i]);
                sb.append(",");
            }
            sb.append("]");
        }
       return sb.toString();
    }

    private static String toString1(int[] a){
        String r = "[";
        if(a.length > 0){
            r += a[0];
            for (int i = 1; i < a.length ; i++) {
                r += ", ";
                r += a[i];
            }
            r += "]";
        }
        return r;
    }
}
