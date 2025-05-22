package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Solution {
	    static class Node{
	        int to;
	        int weight;
	        public Node(int to, int weight){
	            this.to = to;
	            this.weight = weight;
	        }
	    }
	    public int solution(int N, int[][] road, int K) {
	        // 양방향통행로 -> 다익?
	        int answer = 0;
	        
	        List<List<Node>> list = new ArrayList<>();
	        for(int i=0; i<=N; i++){
	            list.add(new ArrayList<>());
	        }
	        for(int i=0; i<road.length; i++){
	            int from = road[i][0];
	            int to = road[i][1];
	            int weight = road[i][2];
	            
	            list.get(from).add(new Node(to, weight));
	            list.get(to).add(new Node(from, weight));
	        }
	        int[] distance = new int[N+1];
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        
	        boolean[] visited = new boolean[N+1];
	        distance[1] = 0;
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
	            @Override
	            public int compare(Node o1, Node o2){
	                return o1.weight-o2.weight;
	            }
	        });
	        pq.add(new Node(1, 0));
	        
	        while(!pq.isEmpty()){
	            Node cur = pq.poll();
	            
	            if(visited[cur.to]) continue;
	            visited[cur.to] = true;
	            
	            for(Node next : list.get(cur.to)){
	                if(distance[next.to] >= distance[cur.to]+next.weight){
	                    distance[next.to] = distance[cur.to]+next.weight;
	                    pq.add(new Node(next.to, distance[next.to]));
	                }
	            }
	        }
	        System.out.println(Arrays.toString(distance));
	        for(int i=0; i<distance.length; i++){
	            if(distance[i]<=K) answer++;
	        }
	        return answer;
	    }
	}
}
