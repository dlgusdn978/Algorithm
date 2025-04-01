package b18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[n][m];
		List<List<int[][]>> list = new ArrayList<>();
		for(int i=0; i<k; i++) {
			list.add(new ArrayList<>());
		}
		// 스티커 정보 입력
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[r][c];
			for(int j=0; j<r; j++) {
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<c; l++) {
					arr[j][l] = Integer.parseInt(st.nextToken());
				}
			}
			list.get(i).add(arr);
		}
		
		// 스티커 회전
		for(int i=0; i<k; i++) {
			for(int j=0; j<3; j++) {
				rotate(list.get(i));
			}
		}
		
		// 스티커 붙이기
		// 스티커 선택 -> 좌표 검색 
		for(int i=0; i<k; i++) {
			boolean flag = false;
			for(int j=0; j<list.get(i).size(); j++) {
				int[][] cur = list.get(i).get(j);
				if(flag) break;
				for(int l=0; l<n; l++) {
					if(flag) break;
					for(int o=0; o<m; o++) {
						if(checker(visited, cur, l, o)) {
							append(visited, cur, l, o);
							flag = true;
							break;
						}
					}
				}
			}
		}
		int cnt = 0;
		for(boolean[] a : visited) {
			for(boolean b : a) {
				if(b) cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void append(boolean[][] visited, int[][] arr, int r, int c) {

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				int nr = r+i;
				int nc = c+j;
				if(arr[i][j]==1) visited[nr][nc] = true; 
			}
		}
	}
	static boolean checker(boolean[][] visited, int[][] arr, int r, int c) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				int nr = r+i;
				int nc = c+j;
				if(nr>=0 && nr<visited.length && nc>=0 && nc<visited[0].length) {
					if(visited[nr][nc] && arr[i][j]==1) return false;
					else continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	static void rotate(List<int[][]> list) {
		int[][] arr = list.get(list.size()-1);
		int[][] rotated = new int[arr[0].length][arr.length];
		// 2 5 -> 5 2
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				rotated[j][arr.length-i-1] = arr[i][j];
			}
		}
		list.add(rotated);
	}
}
