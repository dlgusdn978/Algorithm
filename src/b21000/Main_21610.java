package b21000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21610 {

	// �ȹ�Ž��
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ������ ũ�� n
		int n = Integer.parseInt(st.nextToken());
		// �̵� Ƚ�� m
		int m = Integer.parseInt(st.nextToken());
		// ���� �� arr
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				System.out.print(arr[i][j]);
			}
		}

		// �ʱ� ���� ��ġ
		boolean[][] before = new boolean[n][n];
		before[n-1][0] = true;
		before[n-1][1] = true;
		before[n-2][0] = true;
		before[n-2][1] = true;
		boolean[][] after = new boolean[n][n];

		// �̵�
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			// ���� d
			int d = Integer.parseInt(st.nextToken());
			// �Ÿ� s
			int s = Integer.parseInt(st.nextToken());
			move(before, after, d, s);
			before = new boolean[arr.length][arr.length];
			rain(before, after, arr);
			copy(after, arr);
			makeCloud(before, after, arr);
			after = new boolean[arr.length][arr.length];

		}
		int sum = 0;
		for(int[] a : arr) {
			for(int b : a) {
				sum+=b;
			}
		}
		System.out.println(sum);
	}
	// i+s ���� n-1  ���� ũ�ٸ�? -> (i+s)-(n-1)
	// ``             �۰ų� ���ٸ� ? -> i+s
	// i+s ���� 0 ���� �۴ٸ� ? -> (n-1) + (i+s)
	// ``           ũ�ٸ� ? -> i+s

	static void makeCloud(boolean[][] before, boolean[][] after, int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]>=2 && !after[i][j]) {
					arr[i][j] -= 2;
					before[i][j] = true;
				}
			}
		}

	}
	static void copy(boolean[][] after, int[][] arr) {
		int[][] temp = new int[after.length][after.length];
		for(int i=0; i<after.length; i++) {
			for(int j=0; j<after.length; j++) {
				if(after[i][j]) {
					int count = 0;
					for(int k=1; k<=8; k++) {
						if(k%2!=0) continue;
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length && arr[nr][nc] > 0 ) count++; 
					}
					temp[i][j] += count;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j] += temp[i][j];
			}
		}
	}
	static void rain(boolean[][] before, boolean[][] after, int[][] arr) {
		for(int i=0; i<after.length; i++) {
			for(int j=0; j<after.length; j++) {
				if(after[i][j]) {
					arr[i][j]++;
				}
			}
		}

	}
	static void move(boolean[][] before, boolean[][] after, int d, int s) {
		for(int i=0; i<before.length; i++) {
			for(int j=0; j<before.length; j++) {
				if(before[i][j]) {
					int moveR = (dr[d]*s)%after.length;
					int moveC = (dc[d]*s)%after.length;
					int r = i+moveR>(before.length-1) ? (i+moveR)-(before.length-1)-1 : (i+moveR<0 ? (before.length-1) + (i+moveR)+1 : i+moveR);
					int c = j+moveC>(before.length-1) ? (j+moveC)-(before.length-1)-1 : (j+moveC<0 ? (before.length-1) + (j+moveC)+1 : j+moveC);
					after[r][c] = true;
				}
			}
		}
	}
}
