package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11438 {

	static int n, k;
	static List<Integer>[] list;
	
	static int[][] parents;
	static int[] depths;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		k = -1;
		n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i*=2) {
			k++;
		}
		parents = new int[k+1][n+1];
		depths = new int[n+1];
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		//입력 받기
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			
			list[first].add(sec);
			list[sec].add(first);
		}
		// depth 찾기.
		dfs(1, 1);
		
		//
		fillParents();
		
//		System.out.println(Arrays.toString(parents[1]));
//		System.out.println(Arrays.toString(depths));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right= Integer.parseInt(st.nextToken());
			int res = findLCA(left, right);
			sb.append(res).append("\n");
		}
	
		System.out.println(sb.toString());
		
//		System.out.println(Arrays.toString(parents));
	}

	static int findLCA(int left, int right) {
		//depth left>=right 조정
		if(depths[left]<depths[right]) {
			int temp = left;
			left = right;
			right = temp;
		}
		// depth 건너 뛰기
		for(int i=k; i>=0; i--) {
			if(Math.pow(2, i)<=depths[left]-depths[right]) {
				left = parents[i][left];
			}
		}
		
		// 같은 원소라면 return
		if(left==right) return left;
		
		// 공통 부모까지 depth 건너뛰기
		for(int i=k; i>=0; i--) {
			if(parents[i][left]!=parents[i][right]) {
				left = parents[i][left];
				right = parents[i][right];
			}
		}
		
		return parents[0][left];
	}
	// 부모 원소 채우기
	static void fillParents() {
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				parents[i][j] = parents[i-1][parents[i-1][j]];
			}
		}
	}
	
	static void dfs(int num, int depth) {
		depths[num] = depth;
		for(int i=0; i<list[num].size(); i++) {
			int next = list[num].get(i);
			if(depths[next]==0) {
				dfs(next, depth+1);
				parents[0][next] = num;
			}
		}
	}
	

}
