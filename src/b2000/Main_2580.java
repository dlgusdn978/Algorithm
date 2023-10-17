package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580 {

	static int arr[][];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if(temp==0) count++;
			}
		}
		
		
	}

	static void dfs() {
		
	}
	static boolean checker(int r, int c) {
		for(int i=0; i<9; i++) {
			
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
