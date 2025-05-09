package programmers;
import java.util.*;
public class Block_Moving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int[] dr = {0, 1, 0, -1};
	    static int[] dc = {1, 0, -1, 0};
	    static class Node{
	        int r1, c1, r2, c2;
	        int cnt;
	        public Node(int r1, int c1, int r2, int c2, int cnt){
	            this.r1 = r1;
	            this.c1 = c1;
	            this.r2 = r2;
	            this.c2 = c2;
	            this.cnt= cnt;
	        }
	    }
	    public int solution(int[][] board) {
	        // ȸ���ϴ� ������ �밢�� ĭ�� ���� �ƴϾ�� ��.
	        int answer = 0;
	        answer = bfs(board);
	        return answer;
	    }
	    static int bfs(int[][] board){
	        Queue<Node> q = new ArrayDeque<>();
	        q.add(new Node(0, 0, 0, 1, 0));
	        // ���� �湮üũ
	        boolean[][] visited1 = new boolean[board.length][board[0].length];
	        // ���� �湮üũ
	        boolean[][] visited2 = new boolean[board.length][board[0].length];
	        
	        visited1[0][0] = true;
	        // �湮üũ�� ���� ���� �ִ� ������ �������� �ۼ�
	        int res = Integer.MAX_VALUE;
	        while(!q.isEmpty()){
	            Node cur = q.poll();
	            
	            if((cur.r1==board.length-1 && cur.c1==board[0].length-1) || (cur.r2==board.length-1 && cur.c2==board[0].length-1)){
	                res = Math.min(res, cur.cnt);
	                break;
	            }
	            // move �ڵ�?
	            for(int i=0; i<4; i++){
	                int nr1 = cur.r1+dr[i];
	                int nc1 = cur.c1+dc[i];
	                int nr2 = cur.r2+dr[i];
	                int nc2 = cur.c2+dc[i];
	                if(nr1>=0 && nr1<board.length && nc1>=0 && nc1<board[0].length &&
	                    nr2>=0 && nr2<board.length && nc2>=0 && nc2<board[0].length &&
	                    board[nr1][nc1]!=1 && board[nr2][nc2]!=1){
	                    
	                    // ���ι���
	                    if(nr1==nr2){
	                        int min = Math.min(nc1, nc2);
	                        int max = Math.max(nc1, nc2);
	                        if(!visited1[nr1][min]) {
	                            visited1[nr1][min] = true;
	                            q.add(new Node(nr1, min, nr1, max, cur.cnt+1));
	                        }
	                    }else{
	                        int min = Math.min(nr1, nr2);
	                        int max = Math.max(nr1, nr2);
	                        if(!visited2[min][nc1]) {
	                            visited2[min][nc1] = true;
	                            q.add(new Node(min, nc1, max, nc1, cur.cnt+1));
	                        }
	                    }
	                }
	            }
	            
	            // rotate �ڵ�?
	            // �������� �������� �˾ƾ� �ϰ�
	            // ���ʹ����� ������ ������, ������ ������ ������ ������ ����
	            if(cur.r1==cur.r2){
	                // ���λ�Ȳ
	                int dir = 1;
	                for(int i=0; i<2; i++){
	                    dir *= -1;
	                    int nr1 = cur.r1+dir;
	                    int nc1 = cur.c1;
	                    int nr2 = cur.r2+dir;
	                    int nc2 = cur.c2;
	                    if(nr1>=0 && nr1<board.length && nc1>=0 && nc1<board[0].length &&
	                        nr2>=0 && nr2<board.length && nc2>=0 && nc2<board[0].length &&
	                        board[nr1][nc1]!=1 && board[nr2][nc2]!=1){
	                        // ���� ������ ���� ��
	                        int min = Math.min(cur.r1, cur.r1+dir);
	                        int max = Math.max(cur.r1, cur.r1+dir);
	                        if(!visited2[min][nc1]) {
	                            visited2[min][nc1] = true;
	                            q.add(new Node(cur.r1, cur.c1, cur.r1+dir, cur.c1, cur.cnt+1));
	                        }
	                        // ������ ������ ���� ��
	                        min = Math.min(cur.r2+dir, cur.r2);
	                        max = Math.max(cur.r2+dir, cur.r2);
	                        if(!visited2[min][nc2]) {
	                            visited2[min][nc2] = true;
	                            q.add(new Node(cur.r2+dir, cur.c2, cur.r2, cur.c2, cur.cnt+1));
	                        }
	                    }
	                }
	            }else{
	                // ���λ�Ȳ
	                int dir = 1;
	                for(int i=0; i<2; i++){
	                    dir *= -1;
	                    int nr1 = cur.r1;
	                    int nc1 = cur.c1+dir;
	                    int nr2 = cur.r2;
	                    int nc2 = cur.c2+dir;
	                    if(nr1>=0 && nr1<board.length && nc1>=0 && nc1<board[0].length &&
	                        nr2>=0 && nr2<board.length && nc2>=0 && nc2<board[0].length &&
	                        board[nr1][nc1]!=1 && board[nr2][nc2]!=1){
	                        // ���� ������ ���� ��
	                        int min = Math.min(cur.c1, cur.c1+dir);
	                        int max = Math.max(cur.c1, cur.c1+dir);
	                        if(!visited1[nr1][min]) {
	                            visited1[nr1][min] = true;
	                            q.add(new Node(cur.r1, cur.c1, cur.r1, cur.c1+dir, cur.cnt+1));
	                        }
	                        // ������ ������ ���� ��
	                        min = Math.min(cur.c2, cur.c2+dir);
	                        max = Math.min(cur.c2, cur.c2+dir);
	                        if(!visited1[nr2][min]) {
	                            visited1[nr2][min] = true;
	                            q.add(new Node(cur.r2, cur.c2+dir, cur.r2, cur.c2, cur.cnt+1));
	                        }
	                    }
	                }
	            }
	        }
	        return res;
	    }
	   
	    
	}	
}
