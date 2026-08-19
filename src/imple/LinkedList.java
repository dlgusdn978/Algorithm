package imple;

public class LinkedList<E>{

    private Node<E> head;
    private Node<E> tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public void add(E e){
        Node<E> newNode = new Node<E>(e);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(E e){
        Node<E> prev = null;
        Node<E> cur = head;

        while(cur!=null){
            // 삭제하려는 원소 찾기
            if(cur.value != null && cur.value.equals(e)){

                // head 원소일 경우
                if(prev == null){
                    head = cur.next;
                    // 원소가 한 개였을 경우, tail 초기화
                    if(head == null) tail = null;
                }else{
                    // head 원소가 아닐 경우
                    prev.next = cur.next;
                    // 마지막 원소 삭제 시
                    if(cur.next == null) tail = prev;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }

    }


}
