package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14891 {

	static int[][] gear;
	static int[] dirArr;
	public static void main(String[] args) throws IOException {
		// ���� ���
		// 1. 4���� ��Ϲ����� �ְ�, �� ��Ϲ��� ���� 12�� ������� ������� �־���.
		// 2. �־��� ��Ϲ��� ��ȣ�� ������ �������� ��Ϲ��� ȸ��.
		// 3. kȸ ȸ�� ���� 12�� �� �������� ���� �ջ�.

		// n�� s�� üũ
		// ���� Ȯ��
		// ȸ��
		// ���� ����
		
		// �� ��Ϲ��� ����� ���� ������?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		gear = new int[4][8];
		//��� ���� �Է�
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				gear[i][j] = str.charAt(j)-'0';
			}
		}
		
		// �ݺ� Ƚ��
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// ȸ�� ����
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			checkDir(num-1, dir);
			rotate();
//			print();
		}

		System.out.println(gear[0][0]*1+gear[1][0]*2+gear[2][0]*4+gear[3][0]*8);
	}

	static void checkDir(int num, int dir) {
		dirArr = new int[4];
		dirArr[num] = dir;
		// ���� �˻�
		for(int i=num-1; i>=0; i--) {
			if(gear[i][2]!=gear[i+1][6]) {
				dirArr[i] = dirArr[i+1] == 1 ? -1 : 1;
			}else break;
		}
		// ���� �˻�
		for(int i=num+1; i<4; i++) {
			if(gear[i][6]!=gear[i-1][2]) {
				dirArr[i] = dirArr[i-1]==1 ? -1 : 1;
			}else break;
		}
	}
	
	static void rotate() {
//		System.out.println(Arrays.toString(dirArr));
		for(int i=0; i<4; i++) {
			if(dirArr[i]==1) {
				int temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}else if(dirArr[i]==-1) {
				int temp = gear[i][0];
				for(int j=1; j<8; j++) {
					gear[i][j-1] = gear[i][j];
				}
				gear[i][7] = temp;
			}
		}
	}
	
	static void print() {
		for(int[] a : gear) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
