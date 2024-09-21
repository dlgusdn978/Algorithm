package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[] airPurifier = {-1, -1};
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					if(airPurifier[0]!=-1) {
						airPurifier[1] = i;
					}else {
						airPurifier[0] = i;
					}
					arr[i][j] = 0;
				}
				
			}
		}
		for(int i=0; i<t; i++) {
			diffuse(arr, airPurifier);
			purify(arr, airPurifier);
		}
		int count = 0;
		for(int[] a : arr) {
			for(int b: a) {
				count += b;
//				System.out.print(b+" ");
			}
//			System.out.println();
		}
		
		System.out.println(count);
	}

	static void diffuse(int[][] arr, int[] airPurifier) {
		// �ӽ� �迭 ����.
		// ���� �迭���� 0�� �ƴ� ��ǥ���� �� Ȯ�� ���� �� �ӽ� �迭�� ����
		// ��� ���� ���� �� ���� �迭�� �ӽ� �迭 �� ���ϱ�.
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]!=0 || arr[i][j]!=-1) {
					// ������� Ȯ��
					int count = 0;
					for(int k=0; k<4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && !(nr==airPurifier[0]&&nc==0) && !(nr==airPurifier[1]&&nc==0)) {
							count++;
							temp[nr][nc] += arr[i][j]/5;
						}
					}
					arr[i][j] = arr[i][j] - arr[i][j]/5*count;
				}
			}
		}
		// Ȯ�� �� ���� �迭 ��
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] += temp[i][j];
			}
		}
	}
	
	static void purify(int[][] arr, int[] airPurifier) {
		// ����û���� ��� ���� �������� �ܰ��� ��ȯ
		// airPurifier[0] �� �ִ� ���ҵ��� �ݽð� ����
		for(int i=airPurifier[0]-1; i>0; i--) arr[i][0] = arr[i-1][0];
		for(int i=0; i<arr[0].length-1; i++) arr[0][i] = arr[0][i+1];
		for(int i=0; i<airPurifier[0]; i++) arr[i][arr[0].length-1] = arr[i+1][arr[0].length-1];
		for(int i=arr[0].length-1; i>0; i--) arr[airPurifier[0]][i] = arr[airPurifier[0]][i-1];
		arr[airPurifier[0]][0] = 0;
		
		for(int i=airPurifier[1]+1; i<arr.length-1; i++) arr[i][0] = arr[i+1][0];
		for(int i=0; i<arr[0].length-1; i++) arr[arr.length-1][i] = arr[arr.length-1][i+1];
		for(int i=arr.length-1; i>airPurifier[1]; i--) arr[i][arr[0].length-1] = arr[i-1][arr[0].length-1];
		for(int i=arr[0].length-1; i>0; i--) arr[airPurifier[1]][i] = arr[airPurifier[1]][i-1];
		arr[airPurifier[1]][0] = 0;
		
//		for(int[] a : arr) {
//			for(int b: a) {
//
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}System.out.println();
		
		// ``[1] �� �ִ� ���ҵ��� �ð� ����
		
	}
}
