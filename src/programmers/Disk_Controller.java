package programmers;

import java.util.PriorityQueue;
import java.util.Comparator;
public class Disk_Controller {

	static class Node{
        int num;
        int start;
        int time;
        public Node(int num, int start, int time){
            this.num = num;
            this.start = start;
            this.time = time;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	public int solution(int[][] jobs) {
        // �۾� ��ȣ, ��û �ð�, �ҿ�ð�
        // 1. �ҿ�ð�, ��û �ð�, �۾� ��ȣ �� ����
        // 2. �۾� ��û ~ ���� �ñ��� �ɸ� �ð� = > ��ȯ�ð�
        int answer = 0;
        // �ð� ������ �۾� ����
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.start-o2.start;
            }
        });
        for(int i=0; i<jobs.length; i++){
            pq.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        // �ð� ���� �۾� ��û
        PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.time!=o2.time ? o1.time-o2.time : (o1.start!=o2.start ? o1.start-o2.start : o1.num-o2.num);
            }
        });
        int cur = 0;
        int sum = 0;
        while(!pq.isEmpty() || !pq2.isEmpty()){
            while(!pq.isEmpty()){
                if(pq.peek().start<=cur) pq2.add(pq.poll());
                else break;
            }
            // ���μ��� �ϳ� ����
            if(pq2.isEmpty()) {
                cur++;
                continue;
            }
            Node process = pq2.poll();
            int wait = cur-process.start;
            cur += process.time;
            sum += wait + process.time;
        }
        answer = sum/jobs.length;
        return answer;
    }
	    
	
}
