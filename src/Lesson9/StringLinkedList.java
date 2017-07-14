package Lesson9;

/**
 * Created by arina on 10.07.17.
 */
public class StringLinkedList { //дз - вместо экземпляра класса хранить значения в массиве

    Node first; //null

    Node last;

    int size;

    public  void add(String value){
        Node node = new Node(value, null);

        if(first == null) {
            first = node;
        }
        else {
            last.next = node;
        }
        last = node;
        size++;
    }

    @Override
    public String toString() {  //преобразовать в StringBuilder
        //traverse
        String result = "[";
        if(first != null){
            result += first.value;
            Node current = first.next;

            while (current != null) {
                result += ", " + current.value;
                //System.out.print(current.value);
                current = current.next;
            }
        }
        result += "]";
        return result;
    }

    public boolean remove (String value){
        boolean result = false;
        Node current = first;
        Node prev = null;
        while (current != null){
            if(current.value.equals(value)){

                if (prev == null){
                    first = current.next;
                } else {
                   prev.next = current.next;
                }
                size --;
                result = true;
                break;
            }
            prev = current;
            current = current.next;
        }
        if(first == null){
            last = null;
        }
        return result;
    }

    public static void remove (int index){
        //удаление по индексу
    }
}
