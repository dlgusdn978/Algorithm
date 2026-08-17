package imple;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    // stack 구현
    // 주요 함수 : push, pop, peek(top), isEmpty 등

    private Object[] o = {};
    private static final int DEFAULT_SIZE = 1;
    private int size;

    public Stack(){
        o = new Object[DEFAULT_SIZE];
    }
    public int size(){
        return size;
    }
    public int objectSize(){
        return o.length;
    }
    public E push(E el){
        if(size==o.length) resize();

        o[size] = el;
        size++;

        return el;
    }

    @SuppressWarnings("unchecked")
    public E pop(){
        if(size==0) throw new EmptyStackException();

        E el = (E) o[size-1];
        o[size-1] = null;
        size--;

        resize();
        return el;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        if(size==0) throw new EmptyStackException();

        return (E) o[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int search(E el){
        for(int i=size-1; i>=0; i--){
            if(el.equals(o[i])) return i;
        }
        return -1;
    }
    public void resize(){
        int capacity = o.length;

        if(size == capacity){
            int newSize = capacity*2;
            o = Arrays.copyOf(o, newSize);

            return;
        }
        if(size>0 && size < capacity / 4){
            int newSize = capacity/4;
            o = Arrays.copyOf(o, Math.max(newSize, DEFAULT_SIZE));

        }
    }

}
