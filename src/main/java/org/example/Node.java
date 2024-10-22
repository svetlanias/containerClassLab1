package org.example;

/**
 * класс, реализующий узел
 */
public class Node<T> {
    /**
     * поле класса, может быть каким-либо обьектом
     */
    public T data;
    /**
     * поле класса, хранящее ссылку на следующий элемент
     */
    public Node<T> next;

    /**
     * конструктор класса с входными параметрами:
     * @param data данные любого типа
     * @param next ссылка на следующий элемент
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

}
