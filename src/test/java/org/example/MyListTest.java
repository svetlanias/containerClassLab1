package org.example;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyListTest {

    @Test
    public void add(){
        String data="one";
        MyList<String> expected=new MyList<>();
        expected.add(data);

        MyList<String> actual=new MyList<>();

        Node<String> temp=new Node<>("one",null);
        actual.setFirst(temp);

        assertTrue(expected.compare(actual));
    };

    @Test
    public void addFirst(){
        String data="zero";
        MyList<String> expected=new MyList<>("one");
        expected.addFirst(data);

        MyList<String> actual=new MyList<>("one");

        Node<String> temp=new Node<>("zero",actual.getFirst());
        actual.setFirst(temp);

        assertTrue(expected.compare(actual));
    };

    @Test
    public void getSize(){
        MyList<String> expected=new MyList<>();
        expected.addFirst("one");
        expected.add("two");
        expected.add("three");
        expected.addFirst("zero");
        expected.remove("two");

        assertEquals(expected.getSize(),3);
    };

    @Test
    public void setElement(){
        MyList<String> expected=new MyList<>("zero");
        expected.add("one");
        expected.add("three");
        expected.setElement("two",2);

        MyList<String> actual=new MyList<>("zero");
        actual.add("one");
        actual.add("two");
        actual.add("three");

        assertTrue(expected.compare(actual));
    };

    @Test
    public void getElement(){
        MyList<String> expected=new MyList<>();
        expected.addFirst("zero");
        expected.add("one");
        expected.add("two");

        assertEquals(expected.getElement(1),"one");
    };

    @Test
    public void search(){
        MyList<String> expected=new MyList<>("zero");
        expected.add("one");
        expected.add("two");

        assertEquals(expected.search("two"),2);
    };

    @Test
    public void remove(){
        MyList<String> expected=new MyList<>("zero");
        expected.add("one");
        expected.add("two");
        expected.add("three");
        expected.remove("two");

        MyList<String> actual=new MyList<>("zero");
        actual.add("one");
        actual.add("three");

        assertTrue(expected.compare(actual));
    };
}