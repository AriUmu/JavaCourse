package lesson2path2;

import java.util.Random;

/**
 * Created by arina on 24.06.17.
 */
//все классы из пакета java.lang доступны по умолчанию
public class SimpleClass { //defalt class  - расположен в корне каталога вне пакета
    public static void main(String[] args) {
       new java.util.Random(); // создание объектра без ссылки на него

        java.util.Random rnd = new java.util.Random(); //прикинь так тоже можно)

        Random rnd1 = new Random(); // возможно только при импорте пакета
        //запомнить пакеты



    }
}
