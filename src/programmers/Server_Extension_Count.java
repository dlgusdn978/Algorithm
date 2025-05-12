package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Server_Extension_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int solution(int[] players, int m, int k) {
	        int answer = 0;
	        Queue<Integer> q = new ArrayDeque<>();
	        int add = 0;
	        for(int i=0; i<players.length; i++){
	            while(!q.isEmpty()){
	                if(q.peek()==i) q.poll();
	                else break;
	            }
	            if(players[i]==0) continue;
	            // m-1���� �⺻ ������ ��� ������.
	            
	            // �ʿ��� ���� ��
	            int need = players[i]/m+1;
	            // ���� ���� ��
	            int cur = q.size()+1;
	            if(need<=cur) continue;
	            for(int j=0; j<need-cur; j++){
	                q.add(i+k);
	            }
	            System.out.println(i+" �ʿ� ���� ���� �� : "+(need-cur));
	            add += need-cur;
	            
	        }
	        answer = add;
	        return answer;
	    }
	}
}
