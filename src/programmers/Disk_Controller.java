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
        // 작업 번호, 요청 시각, 소요시간
        // 1. 소요시간, 요청 시각, 작업 번호 순 정렬
        // 2. 작업 요청 ~ 종료 시까지 걸린 시간 = > 반환시간
        int answer = 0;
        // 시간 순으로 작업 정렬
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.start-o2.start;
            }
        });
        for(int i=0; i<jobs.length; i++){
            pq.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        // 시간 별로 작업 요청
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
            // 프로세스 하나 선택
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
