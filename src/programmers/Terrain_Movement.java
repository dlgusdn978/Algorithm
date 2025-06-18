package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Terrain_Movement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int[] dr = {0, 1, 0, -1};
	    static int[] dc = {1, 0, -1, 0};
	    static int[] parents;
	    static class Node{
	        int r;
	        int c;
	        int weight;
	        public Node(int r, int c){
	            this.r = r;
	            this.c = c;
	        }
	        public Node(int r, int c, int weight){
	            this.r = r;
	            this.c = c;
	            this.weight = weight;
	        }
	    }
	    public int solution(int[][] land, int height) {
	        // 이동하는 칸 높이 차이 <= height
	        // 그 이상은 차이만큼 비용
	        // 설치한 사다리는 철거하지 않음.
	        
	        // 이동할 수 있는 영역 끼리는 표시?
	        // 1. bfs로 영역 분리 후
	        // 2. 각 영역에서 다른 영역과의 연결 차이가 작은 순서대로 정렬
	        // 3. disjoint set 활용
	        int answer = 0;
	        boolean[][] visited = new boolean[land.length][land[0].length];
	        int[][] info = new int[land.length][land[0].length];
	        int cnt = 1;
	        for(int i=0; i<land.length; i++){
	            for(int j=0; j<land[0].length; j++){
	                if(visited[i][j]) continue;
	                if(bfs(land, info, visited, i, j, height, cnt)) cnt++;
	            }
	        }
	        
	        
	        List<Node> list = new ArrayList<>();
	        connect(land, info, list);
	        makeSet(cnt);
	        
	        Collections.sort(list, new Comparator<Node>(){
	            @Override
	            public int compare(Node o1, Node o2){
	                return o1.weight-o2.weight;
	            }
	        });
	        int connectCnt = 0;
	        int sum = 0;
	        for(Node node : list){
	            if(union(node.r, node.c)){
	                sum += node.weight;
	                if(++connectCnt==cnt-2) break;
	            }
	        }
	        answer = sum;
	        return answer;
	    }
	    static void print(int[][] arr){
	        for(int[] a : arr){
	            for(int b : a){
	                System.out.print(b+" ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	    static void makeSet(int n){
	        parents = new int[n];
	        for(int i=0; i<n; i++){
	            parents[i] = i;
	        }
	    }
	    static int findSet(int v1){
	        if(v1==parents[v1]) return v1;
	        else return parents[v1] = findSet(parents[v1]);
	    }
	    static boolean union(int v1, int v2){
	        int aRoot = findSet(v1);
	        int bRoot = findSet(v2);
	        if(aRoot==bRoot) return false;
	        parents[bRoot] = aRoot;
	        return true;
	    }
	    static void connect(int[][] land, int[][] info, List<Node> list){
	        for(int i=0; i<land.length; i++){
	            for(int j=0; j<land[0].length; j++){
	                for(int k=0; k<4; k++){
	                    int nr = i+dr[k];
	                    int nc = j+dc[k];
	                    if(nr>=0 && nr<land.length && nc>=0 && nc<land[0].length && land[i][j]!=land[nr][nc]){
	                        list.add(new Node(info[i][j], info[nr][nc], Math.abs(land[i][j]-land[nr][nc])));
	                    }
	                }
	                
	            }
	        }
	    }
	    static boolean bfs(int[][] land, int[][] info, boolean[][] visited, int r, int c, int height, int cnt){
	        Queue<Node> q = new ArrayDeque<>();
	        q.add(new Node(r, c));
	        boolean flag = false;
	        
	        while(!q.isEmpty()){
	            Node cur = q.poll();
	            
	            if(visited[cur.r][cur.c]) continue;
	            visited[cur.r][cur.c] = true;
	            info[cur.r][cur.c] = cnt;
	            flag = true;
	            
	            for(int i=0; i<4; i++){
	                int nr = cur.r+dr[i];
	                int nc = cur.c+dc[i];
	                if(nr>=0 && nr<land.length && nc>=0 && nc<land[0].length && !visited[nr][nc] && Math.abs(land[cur.r][cur.c]-land[nr][nc])<=height){
	                    q.add(new Node(nr, nc));
	                }
	            }
	        }
	        
	        return flag;
	    }
	}
}
