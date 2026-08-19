package imple;

public class Node<E> {
    public Node<E> next;
    public E value;

    public Node(E e){
        next = null;
        value = e;
    }

}
