package Lesson9;

/**
 * Created by arina on 10.07.17.
 */
public class Node { //POJO
    //Plain Old Java Object
    //Только поля конструктор, getter, setter

    String value;
    Node next;

    public Node(String value,  Node next) {
        this.value = value;
        this.next = next;
    }


}
