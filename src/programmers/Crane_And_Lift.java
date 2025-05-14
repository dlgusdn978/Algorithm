package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Crane_And_Lift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int[] dr = {0, 1, 0, -1};
	    static int[] dc = {1, 0, -1, 0};
	    static class Node{
	        int r;
	        int c;
	        public Node(int r, int c){
	            this.r = r;
	            this.c = c;
	        }
	    }
	    public int solution(String[] storage, String[] requests) {
	        int answer = 0;
	        String[][] arr = new String[storage.length+2][storage[0].length()+2];
	        boolean[][] visited = new boolean[storage.length+2][storage[0].length()+2];
	        
	        for(int i=0; i<arr.length; i++){
	            Arrays.fill(arr[i], "");
	        }
	        
	        for(int i=1; i<=storage.length; i++){
	            for(int j=1; j<=storage[0].length(); j++){
	                arr[i][j] = storage[i-1].substring(j-1, j);
	            }
	        }
	        
	        for(int i=0; i<requests.length; i++){
	            String cmd = requests[i];
	            if(cmd.length()==1){
	                // 지게차 요청
	                lift(arr, visited, cmd);
	            }else{
	                // 크레인 요청
	                crane(arr, visited, cmd.substring(0, 1));
	            }
	            pick(arr, visited);
	            
	        }
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<arr[0].length; j++){
	                if(!arr[i][j].equals("")) answer++;
	            }
	        }
	        return answer;
	    }
	    static void pick(String[][] arr, boolean[][] visited){
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<arr[0].length; j++){
	                if(visited[i][j] && !arr.equals("")) arr[i][j] = "";
	            }
	        }
	    }
	    static void crane(String[][] arr, boolean[][] visited, String str){
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<arr[0].length; j++){
	                if(arr[i][j].equals(str)) visited[i][j] = true;
	            }
	        }
	    }
	    static void lift(String[][] arr, boolean[][] visited, String str){
	        Queue<Node> q = new ArrayDeque<>();
	        q.add(new Node(0, 0));
	        boolean[][] temp = new boolean[arr.length+2][arr[0].length+2];
	        
	        while(!q.isEmpty()){
	            Node cur = q.poll();
	            
	            for(int i=0; i<4; i++){
	                int nr = cur.r+dr[i];
	                int nc = cur.c+dc[i];
	                if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && !temp[nr][nc]){
	                    temp[nr][nc] = true;
	                    if(arr[nr][nc].equals("")) q.add(new Node(nr, nc));
	                    else if(arr[nr][nc].equals(str)) visited[nr][nc] = true;
	                }
	            }
	        }
	    }
	}
}
