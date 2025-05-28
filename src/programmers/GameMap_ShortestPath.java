package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class GameMap_ShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int[] dr = {0, 1, 0, -1};
	    static int[] dc = {1, 0, -1, 0};
	    static class Node{
	        int r;
	        int c;
	        int cnt;
	        public Node(int r, int c, int cnt){
	            this.r = r;
	            this.c = c;
	            this.cnt = cnt;
	        }
	    }
	    public int solution(int[][] maps) {
	        int answer = 0;
	        
	        int res = bfs(maps);
	        answer = res == Integer.MAX_VALUE ? -1 : res;
	        return answer;
	    }
	    
	    static int bfs(int[][] maps){
	        boolean[][] visited = new boolean[maps.length][maps[0].length];
	        Queue<Node> q = new ArrayDeque<>();
	        
	        q.add(new Node(0, 0, 1));
	        
	        int min = Integer.MAX_VALUE;
	        while(!q.isEmpty()){
	            Node cur = q.poll();
	            
	            if(cur.r==maps.length-1 && cur.c==maps[0].length-1){
	                min = cur.cnt;
	                break;
	            }
	            if(visited[cur.r][cur.c]) continue;
	            visited[cur.r][cur.c] = true;
	            
	            for(int i=0; i<4; i++){
	                int nr = cur.r+dr[i];
	                int nc = cur.c+dc[i];
	                if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && !visited[nr][nc] && maps[nr][nc]==1){
	                    q.add(new Node(nr, nc, cur.cnt+1));
	                }
	            }
	        }
	        return min;
	    }
	}
}
