package List;

public class Node {
    private Node last;
    private  Node next;
    private int number;
    private  Object valeo;

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValeo() {
        return valeo;
    }

    public void setValeo(Object valeo) {
        this.valeo = valeo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node(Object valeo){
        this.last=null;
        this.next=null;
        this.valeo = valeo;
        this.number=0;
    }

    public Node(Node last, Object valeo) {
        last.setNext(this);
        setLast(last);
        this.valeo = valeo;
        this.number = last.getNumber()+1;
    }
}
