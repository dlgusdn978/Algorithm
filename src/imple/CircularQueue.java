package imple;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularQueue<E> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    private static final int DEFAULT_SIZE = 4;

    public CircularQueue(){
        array = new Object[DEFAULT_SIZE];
        front = 0;
        rear = 0;
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public CircularQueue(int capacity){
        array = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
        this.capacity = capacity;
    }

    // 데이터 삽입
    public void enqueue(E e){
        if(size == capacity) resize();

        array[rear] = e;
        size++;

        rear = (rear + 1) % capacity;
    }

    // 데이터 추출
    public E dequeue(){
        if(size==0) throw new NoSuchElementException("원소가 존재하지 않습니다.");

        @SuppressWarnings("unchecked")
        E e = (E) array[front];

        array[front] = null;
        front = (front + 1) % capacity;
        size--;

        if(size < capacity / 4) resize();
        return e;
    }

    public void resize(){
        int newCapacity = 0;
        if(size == capacity){
            newCapacity = capacity * 2;
        }else if(size > 0 && size < capacity / 4){
            newCapacity = Math.max(DEFAULT_SIZE, capacity / 2);
            if(capacity == newCapacity) return;
        }else return;

        Object[] newArray = new Object[newCapacity];
        for(int i=0; i<size; i++){
            newArray[i] = array[(i + front) % capacity];
        }

        array = newArray;
        this.capacity = newCapacity;
        this.front = 0;
        this.rear = size;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        return (E) array[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

}
