package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2580 {

	static int arr[][];
	static int count;
	static boolean res;
	static class Node{
		int r; 
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		arr = new int[9][9];
		list = new ArrayList<Node>();
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if(temp==0) list.add(new Node(i, j));
		
			}
		}

		dfs(0);
		
	}

	static void dfs(int count) {
		if(res) return;
		if(count==list.size() && !res) {
			res = true;
			print();
			return;
		}
		int r = list.get(count).r;
		int c = list.get(count).c;
		boolean[] row = new boolean[10];
		boolean[] col = new boolean[10];
		boolean[] area = new boolean[10];
		int nr = r/3;
		int nc = c/3;
		for(int i=nr*3; i<nr*3+3; i++ ) {
			for(int j=nc*3; j<nc*3+3; j++) {
				area[arr[i][j]] = true;
			}
		}
		for(int i=0; i<9; i++) {
			row[arr[r][i]] = true;
			col[arr[i][c]] = true;
		}
		for(int i=1; i<=9; i++) {
			if(row[i]||col[i]||area[i]) continue;
			if(checker(r, c, i)) {
				arr[r][c] = i;
			}
			dfs(count+1);
			arr[r][c] = 0;
		}
	}
	static boolean checker(int r, int c, int val) {
		int nr = r/3;
		int nc = c/3;
		for(int i=nr*3; i<nr*3+3; i++ ) {
			for(int j=nc*3; j<nc*3+3; j++) {
				if(arr[i][j]==val) {
					return false;
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[r][i]==val) return false;
			if(arr[i][c]==val) return false;
		}
		return true;
	}
	
	static void print() {
		for(int[] a: arr) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	
}
