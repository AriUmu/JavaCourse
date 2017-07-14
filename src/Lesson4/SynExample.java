package Lesson4;

/**
 * Created by arina on 29.06.17.
 */
public class SynExample {

    static void count(){
        synchronized (SynExample.class){ //ссылка на класс

        }
    }


    void count1(){
        synchronized (this){

        }

    }


    public static void main(String[] args) {

    }
}
