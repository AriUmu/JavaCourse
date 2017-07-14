package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arina on 01.07.17.
 */
public class Examples {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6};

        List list = new ArrayList();
        Arrays.toString(a);
        String s1 = "hello"; //литералы которые хранятся в спец хранилище, известно в начале программы
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));


    }
}
