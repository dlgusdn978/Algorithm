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
		// row ����.
		int start = 0;
		boolean flag = true;
		// �ٸ� ���ڸ� �߰����� ��, ���� ���ڿ� 1 ���̰� �����ϰ�, ���ӵ� �ٸ� ������ ������ l������ ��.
		// ���� ���� ���ں��� �۴ٸ� �״�� �����ؼ� ���ڸ� ����ϸ� ��.
		// ���� ���ں��� ũ�ٸ� ���� ������ ������ ����, l�� �̻��̸� total += 1;
		// visit üũ.

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
//			System.out.println(r+"�� ����");
			runwayCount += 1;
		}
	}
	
	static void checkRunway2(int r) {
		visit = new boolean[n][n];
		// row ����.
		int start = 0;
		boolean flag = true;
		// �ٸ� ���ڸ� �߰����� ��, ���� ���ڿ� 1 ���̰� �����ϰ�, ���ӵ� �ٸ� ������ ������ l������ ��.
		// ���� ���� ���ں��� �۴ٸ� �״�� �����ؼ� ���ڸ� ����ϸ� ��.
		// ���� ���ں��� ũ�ٸ� ���� ������ ������ ����, l�� �̻��̸� total += 1;
		// visit üũ.

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
//			System.out.println(r+"�� ����");
			runwayCount += 1;
		}
	}
	static boolean visitUpperRunway(int r, int i) {
		// ���� ��ġ���� l����ŭ �ڷ� �̵��ϰ�, �̵� ��� �� �ִ� ���� ��� arr[r][i]���� 1 �۾ƾ� ��.
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
		// ���� ��ġ���� l����ŭ �ڷ� �̵��ϰ�, �̵� ��� �� �ִ� ���� ��� arr[r][i]���� 1 �۾ƾ� ��.
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
