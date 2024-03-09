package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2140 {
	
	static int n;
	static char[][] arr;
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// ��ü ��ȸ ������
		// # �� �� 8�� Ž�� ����
		// ��� ������ #�� �� count+1 continue;
		// �ϳ��� #�� �ƴ� �� �ٽ� 8�� �����鼭 1 �̻����� Ȯ��
		// ��� ������ 1 �̻��� �� count + 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++){
				if(arr[i][j]=='#') find(i, j);
			}
		}
		
//		for(char[] a : arr) {
//			for(char b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(count);
	}

	static void find(int r, int c) {
		// �ֺ� ������ ����
		int countSpace = 0;
		// # �� ����
		int countSharp = 0;
		// # �� �ƴ� ���� ũ�Ⱑ 1 �̻��ΰ�?
		boolean checker = true;
		
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<n && nc>=0 && nc<n) {
				countSpace++;
				if(arr[nr][nc]=='#') countSharp++;
				else {
					if(arr[nr][nc]=='0') checker = false; 
				}
			}
		}
		
		if(countSharp==countSpace) {
			count++;
		}else {
			if(checker) {
				change(r, c);
				count++;
			}
		}
	}
	static void change(int r, int c) {
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc]!='#') {
				int num = arr[nr][nc]-49;
				arr[nr][nc] = (char) (num+48);
			}
		}
	}
	
}
