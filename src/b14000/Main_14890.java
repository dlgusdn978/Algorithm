package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890 {

	static int n, l, runwayCount;
	static int[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			checkRunway(i);
//			print();
			checkRunway2(i);
//			print();
		}
		
		System.out.println(runwayCount);
	}

	static void print() {
		for(boolean[] a:visit) {
			for(boolean b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void checkRunway(int r) {
		visit = new boolean[n][n];
		// row 부터.
		int start = 0;
		boolean flag = true;
		// 다른 숫자를 발견했을 때, 이전 숫자와 1 차이가 나야하고, 연속된 다른 숫자의 개수가 l개여야 함.
		// 만약 이전 숫자보다 작다면 그대로 연속해서 숫자를 계산하면 됨.
		// 이전 숫자보다 크다면 이전 숫자의 개수를 세고, l개 이상이면 total += 1;
		// visit 체크.

		for(int i=0; i<n; i++) {
			if(i==0) start = arr[r][i];
			else {
				if(start==arr[r][i]) continue;
				else if(start==arr[r][i]-1) {
					start = arr[r][i];
					flag = flag && visitUpperRunway(r, i);
				}
				else if(start-1==arr[r][i]) {
					start = arr[r][i];
					flag = flag && visitLowerRunway(r, i);
				}
				else return;
			}
			
			if(!flag) return;
		}
		if(flag) {
//			System.out.println(r+"행 가능");
			runwayCount += 1;
		}
	}
	
	static void checkRunway2(int r) {
		visit = new boolean[n][n];
		// row 부터.
		int start = 0;
		boolean flag = true;
		// 다른 숫자를 발견했을 때, 이전 숫자와 1 차이가 나야하고, 연속된 다른 숫자의 개수가 l개여야 함.
		// 만약 이전 숫자보다 작다면 그대로 연속해서 숫자를 계산하면 됨.
		// 이전 숫자보다 크다면 이전 숫자의 개수를 세고, l개 이상이면 total += 1;
		// visit 체크.

		for(int i=0; i<n; i++) {
			if(i==0) start = arr[i][r];
			else {
				if(start==arr[i][r]) continue;
				else if(start==arr[i][r]-1) {
					start = arr[i][r];
					flag = flag && visitUpperRunway2(i, r);
				}
				else if(start-1==arr[i][r]) {
					start = arr[i][r];
					flag = flag && visitLowerRunway2(i, r);
				}
				else return;
			}
			
			if(!flag) return;
		}
		if(flag) {
//			System.out.println(r+"열 가능");
			runwayCount += 1;
		}
	}
	static boolean visitUpperRunway(int r, int i) {
		// 현재 위치부터 l개만큼 뒤로 이동하고, 이동 경로 상에 있는 수가 모두 arr[r][i]보다 1 작아야 함.
		boolean flag = true;
		int num = arr[r][i-1];
		for(int j=1; j<=l; j++) {
			if(i-j<0) return false;
			if(arr[r][i-j]!=num) return false;
			if(visit[r][i-j]) return false;
		}
		for(int j=1; j<=l; j++) {
			visit[r][i-j] = true;
		}
		return true;
	}
	
	static boolean visitLowerRunway(int r, int i) {
		boolean flag = true;
		int num = arr[r][i];
		for(int j=0; j<l; j++) {
			if(i+j>=n) return false;
			if(arr[r][i+j]!=num) return false;
			if(visit[r][i+j]) return false;
		}
		for(int j=0; j<l; j++) {
			visit[r][i+j] = true;
		}
		return true;
	}
	static boolean visitUpperRunway2(int i, int r) {
		// 현재 위치부터 l개만큼 뒤로 이동하고, 이동 경로 상에 있는 수가 모두 arr[r][i]보다 1 작아야 함.
//		System.out.println(r+" "+i);
		boolean flag = true;
		int num = arr[i-1][r];
		for(int j=1; j<=l; j++) {
			if(i-j<0) return false;
			if(arr[i-j][r]!=num) return false;
			if(visit[i-j][r]) return false;
		}
		for(int j=1; j<=l; j++) {
			visit[i-j][r] = true;
		}
//		System.out.println("?");
		return true;
	}
	
	static boolean visitLowerRunway2(int i, int r) {
//		System.out.println(r+" "+i);
		boolean flag = true;
		int num = arr[i][r];
		for(int j=0; j<l; j++) {
			if(i+j>=n) return false;
			if(arr[i+j][r]!=num) return false;
			if(visit[i+j][r]) return false;
		}
		for(int j=0; j<l; j++) {
			visit[i+j][r] = true;
		}
		return true;
	}
}
