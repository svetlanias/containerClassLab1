package org.example;

/**
 * класс контейнер, позволяющий хранить обьекты произвольного типа, используя связанный список
 */
public class MyList<T> {

    /**
     * ссылка на первый элемент списка
     */
    private Node<T> first;

    /**
     * ссылка на последний элемент списка
     */
    private Node<T> last;

    /**
     * конструктор без входных параметров, инициализирующий поля значением null
     */
    public MyList() {
        first = null;
        last = null;
    }

    /**
     * конструктор с входным параметром:
     * @param item передаваемый обьект
     */
    public MyList(T item) {
        first = null;
        addFirst(item);
    }

    /**
     * проверка списка на пустоту
     * @return 1 в случае, если список пуст. 0 в обратном случае
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * добавление элемента в конец списка
     * @param item передаваемый обьект
     */
    public void add(T item) {
        if (isEmpty()) {
            last = new Node<T>(item, null);
            first = last;
        } else {
            Node<T> temp = last;
            last = new Node<T>(item, null);
            temp.next = last;
        }
    }

    /**
     * добавление элемента в начало списка
     * @param item передаваемый обьект
     */
    public void addFirst(T item) {
        if (isEmpty()) {
            first = new Node<T>(item, null);
            last = first;
        } else {
            Node<T> next = first;
            first = new Node<T>(item, null);
            first.next = next;
        }
    }

    /**
     * получение первого элемента списка
     * @return первый узел
     */
    public Node<T> getFirst() {
        return first;
    }

    /**
     * плучение последнего элемента списка
     * @return послений узел
     */
    public Node<T> getLast() {
        return last;
    }

    /**
     * задает первый элемент списка
     * @param item задаваемый узел
     */
    public void setFirst(Node<T> item)
    {
        first=item;
    }

    /**
     * задает последний элемент списка
     * @param item задаваемый узел
     */
    public void setLast(Node<T> item)
    {
        last=item;
    }

    /**
     * получение размерности списка
     * @return колличество элементов в списке, 0 если список пуст
     */
    public int getSize()
    {
        int result=0;
        Node<T> current=first;
        while(current != null)
        {
            result++;
            current=current.next;
        }
        //if(result!=0) result++;
        return result;
    }

    /**
     * добавление элемента после элемента с заданным номером
     * @param item добавляемый обьект
     * @param number номер элемента
     */
    public void setElement(T item, int number)
    {
        if(number==0) addFirst(item);
        else {
            Node<T> additional = new Node<T>(item, null);
            Node<T> temp = first;

            int count = 0;

            while (count < (number - 1)) {
                temp = temp.next;
                count++;
            }

            additional.next = temp.next;
            temp.next = additional;
        }
    }

    /**
     * получение элемента с заданным номером
     * @param number номер элемента
     * @return возвращает обьект под заданным номером
     */
    public T getElement(int number) {
        T result;

        Node<T> temp = first;
        int i=0;
        while (temp.next != null && i<number) {
            temp = temp.next;
            i++;
        }

        result= temp.data;
        return result;
    }

    /**
     * осуществляет поиск элемента
     * @param item обьект, который необходимо найти
     * @return номер элемента, если он находится в списке, -1 если его в списке нет
     */
    public int search(T item) {
        Node<T> temp=first;
        int result=-1;
        int count=0;

        while(temp != null)
        {
            if (temp.data.equals(item))
            {
                result=count;
                return result;
            }
            temp=temp.next;
            count++;
        }

        return result;
    }

    /**
     * удаляет элемент по заданному значению обьекта
     * @param item обьект
     * @return true, если удалось удалить элемент, false, если обьекта в списке нет
     */
    public boolean remove(T item) {
        boolean result=false;
        if (!isEmpty()) {

            Node<T> previous = null;
            Node<T> current = first;

            while (current.next != null && !current.data.equals(item)) {
                previous = current;
                current = previous.next;
            }

            if (current.data.equals(item)) {
                if (current == first) {
                    first = first.next;
                }
                else if (current == last) {
                    last = previous;
                    last.next = null;
                }
                else if (first == last) {
                    first = null;
                }
                else {
                    previous.next = current.next;
                }
                result = true;
            }
        }
        return result;
    }

    /**
     * осуществляет вывод списка
     */
    void print_list () {
        Node<T> temp = first;
        while (temp != null) {
            System.out.print (temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * проверка списков на совпадение элементов
     * @param list список, элементы которого сравниваются с исходным
     * @return true в случае совпадания элементов, false - в обратном случае
     */
    boolean compare(MyList<T> list){
        boolean result=false;

        if(this.getSize() == list.getSize())
        {
            result=true;
            Node<T> temp=first;
            Node<T> compared=list.first;

            while(temp.next!=null && result)
            {
                if(!temp.data.equals(compared.data)) result=false;
                temp=temp.next;
                compared=compared.next;
            }
        }

        return result;
    }
}