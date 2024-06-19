package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12100 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print(arr);
//		moveRight(arr);
//		moveLeft(arr);
//		moveUp(arr);
//		moveDown(arr);
		
		Queue<String> q = new ArrayDeque<>();
		q.add("");
		
		int count = 0;
		while(true) {
			String cur = q.poll();
			if(cur.length()>4) break;
			q.add(cur+"r");
			q.add(cur+"l");
			q.add(cur+"d");
			q.add(cur+"u");
		}
		
		for(String a : q) {
			calc(arr, a);
		}

		System.out.println(max);
	}

	static void calc(int[][] temp, String str) {
		int[][] arr = new int[temp.length][temp.length];
		for(int i=0; i<temp.length; i++) {
			arr[i] = Arrays.copyOf(temp[i], temp.length);
		}
//		print(arr);
		for(int i=0; i<str.length(); i++) {
			
			
			char cur = str.charAt(i);
			switch(cur) {
			case 'r':
				moveRight(arr);
				break;
			case 'l':
				moveLeft(arr);
				break;
			case 'd':
				moveDown(arr);
				break;
			case 'u':
				moveUp(arr);
				break;
			}
			
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		
	}
	static void print(int[][] arr) {
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	
	static void moveRight(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=arr.length-1; j>=0; j--) {
				int nr = i+dr[0];
				int nc = j+dc[0];
				int r = i;
				int c = j;
				while(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length) {
					if(arr[r][c]==arr[nr][nc] && !visited[nr][nc] && arr[nr][nc]!=0) {
						arr[nr][nc] *= 2;
						arr[r][c] = 0;
						visited[nr][nc] = true;
						break;
					}else if(arr[nr][nc]==0) {
						arr[nr][nc] = arr[r][c];
						arr[r][c] = 0;
					}else break;

					nr += dr[0];
					nc += dc[0];
					r += dr[0];
					c += dc[0];
				}
			}
		}
	}
	
	static void moveLeft(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				int nr = i+dr[2];
				int nc = j+dc[2];
				int r = i;
				int c = j;
				while(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length) {
					if(arr[r][c]==arr[nr][nc] && !visited[nr][nc] && arr[nr][nc]!=0) {
						arr[nr][nc] *= 2;
						arr[r][c] = 0;
						visited[nr][nc] = true;
						break;
					}else if(arr[nr][nc]==0) {
						arr[nr][nc] = arr[r][c];
						arr[r][c] = 0;
					}else break;
					nr += dr[2];
					nc += dc[2];
					r += dr[2];
					c += dc[2];
				}
			}
		}

	}
	
	static void moveDown(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=0; j<arr.length; j++) {
				int nr = i+dr[1];
				int nc = j+dc[1];
				int r = i;
				int c = j;
				while(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length) {
					if(arr[r][c]==arr[nr][nc] && !visited[nr][nc] && arr[nr][nc]!=0) {
						arr[nr][nc] *= 2;
						arr[r][c] = 0;
						visited[nr][nc] = true;
						break;
					}else if(arr[nr][nc]==0) {
						arr[nr][nc] = arr[r][c];
						arr[r][c] = 0;
					}else break;
					nr += dr[1];
					nc += dc[1];
					r += dr[1];
					c += dc[1];
				}
			}
		}
	}
	
	static void moveUp(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=arr.length-1; j>=0; j--) {
				int nr = i+dr[3];
				int nc = j+dc[3];
				int r = i;
				int c = j;
				while(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length) {
					if(arr[r][c]==arr[nr][nc] && !visited[nr][nc] && arr[nr][nc]!=0) {
						arr[nr][nc] *= 2;
						arr[r][c] = 0;
						visited[nr][nc] = true;
						break;
					}else if(arr[nr][nc]==0) {
						arr[nr][nc] = arr[r][c];
						arr[r][c] = 0;
					}else break;
					nr += dr[3];
					nc += dc[3];
					r += dr[3];
					c += dc[3];
					
				}
			}
			
		}
	}
}
