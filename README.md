# 🔍 스택 (Stack)

데이터를 한쪽 끝에서만 넣고 뺄 수 있는 자료 구조로, 가장 나중에 들어간 데이터가 가장 먼저 빠지는 후입선출 구조
 - 주요 함수로 push, pop, peek 등이 존재
 - 웹 브라우저 뒤로가기, 실행 취소, 함수 호출 스택 등에 사용됨
 - 시간 복잡도는 O(1)

## 💡 핵심 메커니즘
Stack 구현
``` java

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
```
# 🔍 원형 큐 (Circular Queue)

기존 선형 Queue의 단점을 극복하기 위해 등장, 배열의 처음과 끝이 논리적으로 이어져 있다고 가정.


---

## 💡 핵심 메커니즘
- pointer와 모듈러 연사을 통해 배열을 순환하도록 구성
- resize 시 unroll을 통해 start와 end의 위치를 초기화하여 순회
    - ([i+front] % capacity)
```
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
```
# 🔍 연결 리스트 (LinkedList)
메모리에 데이터가 연속적으로 저장되는 배열과 달리, Node라는 독립적인 객체들이 메모리 곳곳에 흩어져 있고 Pointer를 이용해 사슬처럼 연결된 동적 자료구조

---
## 💡 핵심 메커니즘
Node는 Data와 Next Pointer로 구성되며, 첫 번째 노드를 Head, 마지막 노드를 Tail이라고 함
- 단방향 연결 리스트 : 노드가 Next 노드의 주소만 가짐
- 양방향 연결 리스트 : 노드가 Prev 노드와 Next 노드의 주소를 모두 가짐
- 원형 연결 리스트 : Tail 노드가 Head 노드의 주소를 가짐


장점 : 배열 중간에 데이터를 삽입하는 경우, 앞뒤 노드의 연결을 끊고 새로운 데이터에 연결해주기만 하면 되므로 O(1)의 시간 복잡도를 가짐(Node의 위치를 알 경우)<br />
단점 : 특정 인덱스의 데이터를 찾을 때 Head 부터 순차적으로 접근해야 하므로 O(N) 의 시간이 발생
또한, 노드의 주소를 저장할 Pointer의 공간이 필요. -> 메모리 오버헤드 발생.

```java
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
```


# 🔍 이분 탐색 (Binary Search)

정렬된 데이터에서 탐색 범위를 절반씩 좁혀나가며 타겟 데이터를 빠르게 찾아내는 O(log N) 알고리즘

---

## 💡 핵심 메커니즘
이분 탐색의 핵심은 **절반으로 나누기**이다. 전체를 하나씩 확인하는 순차 탐색(O(N))과 달리, 단 몇 번의 비교만으로 수억 개의 데이터 중 원하는 값을 찾아낼 수 있다.



1. **전제 조건:** 데이터가 반드시 **오름차순 또는 내림차순으로 정렬**되어 있어야 함.
2. **포인터 설정:** 탐색 범위의 시작점(`start`)과 끝점(`end`)을 지정.
3. **무한 루프 조율:** `start <= end`인 동안 중간점(`mid`)을 계산하여 타겟 값과 비교.
   - `mid` 값 == `target` ➡️ 탐색 성공 (인덱스 반환)
   - `mid` 값 > `target` ➡️ 범위를 왼쪽 절반으로 축소 (`end = mid - 1`)
   - `mid` 값 < `target` ➡️ 범위를 오른쪽 절반으로 축소 (`start = mid + 1`)

---

## 🛠️ 표준 구현 템플릿 (Java)

 **반복문(Iteration)** 기반의 구현 코드

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // (start + end) / 2 시 발생할 수 있는 정수 오버플로우 방지 양식
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // 찾은 경우 인덱스 반환
            } else if (arr[mid] > target) {
                end = mid - 1; // 왼쪽 영역 탐색
            } else {
                start = mid + 1; // 오른쪽 영역 탐색
            }
        }
        return -1; // 찾지 못한 경우
    }
}
```

---

## 문제 풀이 시 주의사항
**1. mid 계산 시 발생하는 타입 오버플로우**
  > start와 end가 정답에 가까워질 때 순간적으로 타입 상한을 초과하는 경우 발생.
  >> ex) int형 연산 시 start+end 값이 2,147,483,647 초과.
   -> **int mid = start + (end - start) / 2;** 를 활용하여 타입 오버플로우 방지
   
**2. 초기 탐색 범위 오버플로우**
  > 최악의 케이스를 상정하여 end 포인터의 초깃값을 연산할 때 발생.
  >> ex) long end = max_value * total_count;
   -> **long end = (long) max_value * total_count;** 를 활용하여 명시적 형변환
   
**3. 조건 만족 여부 누적 시 오버플로우**
  > start, end, mid 제외, count 등 추가적인 변수 연산 시 오버플로우 발생하지 않도록 유의.
