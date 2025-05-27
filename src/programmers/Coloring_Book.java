package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Coloring_Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int[] dr = {1, 0, -1 ,0};
	    static int[] dc = {0, -1, 0, 1};
	    static class Node{
	        int r;
	        int c;
	        public Node(int r, int c){
	            this.r = r;
	            this.c = c;
	        }
	    }
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;

	        
	        int[] answer = new int[2];
	        int[][] arr = new int[m][n];
	        boolean[][] visited = new boolean[m][n];
	        int cnt = 1;
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(!visited[i][j] && picture[i][j]!=0) bfs(picture, arr, visited, i, j, cnt++);
	                
	            }
	        }

	        for(int i=1; i<cnt; i++){
	            int areaCnt = getArea(arr, i);
	            if(answer[1]<areaCnt){
	                answer[1] = areaCnt;
	            }
	        }
	        answer[0] = cnt-1;
	        print(arr);
	        
	        return answer;
	    }
	    // 풀이.
	    // arr 배열 새로 생성
	    // bfs 탐색으로 picture 순회하면서, 같은 수 && 탐색하지 않은 영역 순회
	    // arr 배열에 갱신
	    // arr 배열을 순회하며 각 수의 개수가 몇개인지 탐색
	    static void bfs(int[][] picture, int[][] arr, boolean[][] visited, int r, int c, int cnt){
	        Queue<Node> q = new ArrayDeque<>();
	        q.add(new Node(r, c));
	        
	        while(!q.isEmpty()){
	            Node cur = q.poll();
	        
	            if(visited[cur.r][cur.c]) continue;
	            visited[cur.r][cur.c] = true;
	            
	            arr[cur.r][cur.c] = cnt;
	            
	            for(int i=0; i<4; i++){
	                int nr = cur.r+dr[i];
	                int nc = cur.c+dc[i];
	                if(nr>=0 && nr<picture.length && nc>=0 && nc<picture[0].length && !visited[nr][nc] && picture[nr][nc]==picture[cur.r][cur.c]){
	                    q.add(new Node(nr, nc));
	                    
	                }
	            }
	        }
	    }
	    static void print(int[][] arr){
	        for(int[] a : arr){
	            for(int b : a){
	                System.out.print(b+" ");
	            }
	            System.out.println();
	        }
	    }
	    static int getArea(int[][] arr, int cnt){
	        int areaCnt = 0;
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<arr[0].length; j++){
	                if(arr[i][j]==cnt) areaCnt++;
	            }
	        }
	        return areaCnt;
	    }
	}
}
