package lab2;

public class LinkedListVector {
    //Вспомогательный внутренний класс, реализует элемент связного списка.
    private class Node{
        //Значение, которое хранит элемент связного списка.
        double value = Double.NaN;
        //Ссылка на предыдущий элемент связного списка.
        Node prev = null;
        //Ссылка на следующий элемент связного списка.
        Node next = null;
    }
    //Ссылка на голову связного списка.
    private Node head = new Node();
    /*блок инициализации, зацикливающий ссылки головы списка в момент создания объекта.*/
    {
        head.prev = head;
        head.next = head;
    }
    //Текущая длина связного списка.
    private int size = 0;
    //Ссылка на последний использовавшийся элемент связного списка.
    private Node current = head;
    /*Номер последнего использовавшиегося элемента связного списка. Значение "-1" соответствует голове.*/
    private int currentIndex = -1;
    /*Вспомогательный метод доступа к элементу списка.
       Должен использоваться для доступа из всех остальных методов, т.к. реализует механизм "памяти". index - номер требующегося элемента*/
    private Node gotoNumber(int index) {
        if ((index >=0) && (index < size)) {
            if (index < currentIndex) {
                if (index < currentIndex - index) {
                    current = head;
                    for (int i = -1; i < index; i++)
                        current = current.next;
                }
                else {
                    for (int i = currentIndex; i > index; i--)
                        current = current.prev;
                }
            }
            else {
                if (index - currentIndex < size - index) {
                    for (int i = currentIndex; i < index; i++)
                        current = current.next;
                }
                else {
                    current = head;
                    for (int i = size; i > index; i--)
                        current = current.prev;
                }
            }
            currentIndex = index;
            return current;
        }
        else
            throw new VectorIndexOutOfBoundsException();
    }
}
