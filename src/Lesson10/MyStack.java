package Lesson10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arina on 12.07.17.
 */
public class MyStack {

    private String[] elements;
    private int size = 0;

    public static final int DEFAULT_MAXSIZE = 5;

    public MyStack() {
        this(DEFAULT_MAXSIZE);
    }

    public MyStack(int maxSize) {
        elements = new String[maxSize];
    }



    public boolean push(String one) {
        if(size >= elements.length){ //guard condition
            return false;
        }
        elements[size] = one;
        size++;
        return true;
    }

    public String pop() {
        if(size <= 0){
            return null;  //stack underflow
        }
        size--;
        String result = elements[size];
        elements[size] = null; //стираем ненужные ссылки Memory Leak

        return result;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("[ ");
//        for (int i = 0; i < size; i++) {
//            builder.append(elements[i]);
//            builder.append(" ");
//        }
//        builder.append("]");
//        return builder.toString();
        return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
    }

    public String tos() {
        return (size<=0)? null: elements[size-1];
    }
}
