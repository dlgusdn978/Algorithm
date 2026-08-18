package imple;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        CircularQueue<Integer> c = new CircularQueue<>();
        for(int i=0; i<4; i++){
            c.enqueue(i);
        }
        for(int i=0; i<5; i++){
            c.enqueue(i);
        }



    }
}
