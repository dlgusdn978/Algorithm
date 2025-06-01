package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static class Node{
	        int prior;
	        int loc;
	        public Node(int prior, int loc){
	            this.prior = prior;
	            this.loc = loc;
	        }
	    }
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        // 우선순위와 loc 정보를 기준으로 판별?
	        Queue<Node> q = new ArrayDeque<>();
	        List<Node> list = new ArrayList<>();
	        for(int i=0; i<priorities.length; i++){
	            q.add(new Node(priorities[i], i));
	            list.add(new Node(priorities[i], i));
	        }
	        Collections.sort(list, new Comparator<Node>(){
	            @Override
	            public int compare(Node o1, Node o2){
	                return o2.prior-o1.prior;
	            }
	        });
	        
	        boolean flag = false;
	        while(!list.isEmpty()){
	            Node cur = list.remove(0);
	            
	            while(!q.isEmpty()){
	                Node next = q.poll();
	                if(cur.prior==next.prior){
	                    if(location==next.loc) flag = true;
	                    answer++;
	                    break;
	                }else q.add(next);
	            }
	            if(flag) break;
	        }
	        return answer;
	    }
	}
}
