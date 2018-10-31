package List;

import List.Interfase.*;

public class MiList implements Stack, Queue, List {

    private Node ListRoot=null;
    private Node ListHead=null;
    private Node akt_elem=null;
    private int size;

    public Node getListRoot() {
        return ListRoot;
    }

    public void setListRoot(Node listRoot) {
        ListRoot = listRoot;
    }

    public Node getListHead() {
        return ListHead;
    }

    public void setListHead(Node listHead) {
        ListHead = listHead;
    }

    public Node getAkt_elem() {
        return akt_elem;
    }

    public void setAkt_elem(Node akt_elem) {
        this.akt_elem = akt_elem;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
//Методы доступные независимо от типа списка
public String inpytElement(Node node) {
         if(node!=null) {
             return "Node{" +
                     "number=" + node.getNumber() +
                     ", valeo=" + node.getValeo() +
                     '}';
         }
         return null;
}

    public void inputList(){
        akt_elem=getListRoot();
        while (akt_elem!=null){
            System.out.println("Number { " + akt_elem.getNumber() + " } { Value " + akt_elem.getValeo() + " }" );
            akt_elem=akt_elem.getNext();
        }
    }

    public void inputBackwards() {
        akt_elem=getListHead();
        while (akt_elem!=null){
            System.out.println("Number { " + akt_elem.getNumber() + " } { Value " + akt_elem.getValeo() + " }" );
            akt_elem=akt_elem.getLast();
        }
    }

    public void Numbering() {
        int i = 0;
        setAkt_elem(getListRoot());
        while (getAkt_elem()!=null) {
            getAkt_elem().setNumber(i);
            setAkt_elem(getAkt_elem().getNext());
            i++;
        }
        setSize(i);
    }


//Реализация методов Стека
    @Override
    public void push(Object obj) { //Добавляет элемент в начала списка
        if(getListHead()==null){
            akt_elem = new Node(obj);
            setListRoot(akt_elem);
            setListHead(akt_elem);
            setSize(getSize()+1);
            akt_elem = null;
        }else {
            akt_elem = new Node(getListHead(), obj);
            getListHead().setNext(akt_elem);
            setListHead(akt_elem);
            setSize(getSize()+1);
            akt_elem = null;
        }
    }

    @Override
    public void pop() {//удаляем последний вошедщий элемент
        if(getListRoot()==getListHead()) {
            setListHead(null);
            setListRoot(null);
            setAkt_elem(null);
            System.out.println("Список пуст");
            setSize(getSize()-1);
        } else {
            setAkt_elem(getListHead().getLast());
            getListHead().getLast().setNext(null);
            getListHead().setLast(null);
            getListHead().setNext(null);

            setListHead(getAkt_elem());
            setSize(getSize()-1);
        }

    }
//Реализация методов Очереди
    @Override
    public void shift(Object obj) { // Добавляет элемент в конец списка
        if(getListHead()==null){
            akt_elem = new Node(obj);
            setListRoot(akt_elem);
            setListHead(akt_elem);
            setSize(getSize()+1);
            akt_elem = null;
        }else {
            akt_elem = new Node(getListHead(), obj);
            getListHead().setNext(akt_elem);
            setListHead(akt_elem);
            setSize(getSize()+1);
            akt_elem = null;
        }
    }

    @Override
    public void unshift() { // Удаляет элемент с начала списка
        if(getListRoot()==getListHead()) {
            setListHead(null);
            setListRoot(null);
            setAkt_elem(null);
            setSize(getSize()-1);
            System.out.println("Очередь пуста");
        } else {
            setAkt_elem(getListRoot().getNext());
            getListRoot().setLast(null);
            getListRoot().setNext(null);
            setSize(getSize()-1);
            setListRoot(getAkt_elem());
        }
        Numbering();
    }
 //Реализация Методов Списка
    @Override
    public void add(Object obj, int index) {
        Node node = new  Node(obj); // выделили память под вставляемый объект
           setAkt_elem(get(index));//нашли элемент стоящий по месту нашего индекса
        if(getAkt_elem()!=null) {
            if (getAkt_elem().getNumber() == getListHead().getNumber())
                push(obj);
            else if (getAkt_elem().getNumber() == getListRoot().getNumber() && getAkt_elem().getLast()==null ){
                node.setNext(getListRoot());
                getListRoot().setLast(node);
                node.setLast(null);
                setListRoot(node);
            } else {
               /* //сначала свяжем нижний элемент с новым
                getAkt_elem().getLast().setNext(node); // от нижнего к новому
                node.setLast(getAkt_elem().getLast());//от нового вк нижнему
                //теперь новый с верхним
                getAkt_elem().getNext().setLast(node);
                node.setNext(getAkt_elem().getNext());*/
               getAkt_elem().getLast().setNext(node);
               node.setLast(getAkt_elem());

               node.setNext(getAkt_elem());
                getAkt_elem().getNext().setLast(node);
            }
            setAkt_elem(null);
            Numbering();
        }
    }

    @Override
    public void remove(int index) {
        setAkt_elem(get(index));
        if(getAkt_elem()!=null && getAkt_elem().getLast()!=null && getAkt_elem().getNext()!=null) {
            getAkt_elem().getLast().setNext(getAkt_elem().getNext());
            getAkt_elem().getNext().setLast(getAkt_elem().getLast());
            setAkt_elem(null);
        } else if(getAkt_elem()!=null && getAkt_elem().getLast()==null){//Удаляем корень
            unshift();
        }else if(getAkt_elem()!=null && getAkt_elem().getNext()==null){//удаляем голову
            pop();
        }

        Numbering();
    }

    @Override
    public Node get(int index) {
        setAkt_elem(getListRoot());
        while (getAkt_elem()!=null) {
            if(getAkt_elem().getNumber()==index)
                return getAkt_elem();
            setAkt_elem(getAkt_elem().getNext());
        }
        return null;
    }

}
