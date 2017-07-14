package Lesson9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;

/**
 * Created by arina on 10.07.17.
 */
public class WrapperClass {

    public static final LocalDateTime OF = LocalDateTime.of(1995,
            3, 21, 10, 30);

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();//список объектов
        list.add(0); // -> list.add(new Integer(0)); Autoboxing

        Date date = new Date();
        System.out.println(date.toString());


        //System.out.println(Calendar.getInstance().getTimeZone());
        System.out.println(LocalTime.now());
       // System.out.println(OF.compareTo(ChronoLocalDateTime.from(LocalDate.now())));
        System.out.println();



    }

}
