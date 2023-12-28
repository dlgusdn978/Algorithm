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
		// 구현 방법
		// 1. 4개의 톱니바퀴가 있고, 각 톱니바퀴 값은 12시 방향부터 순서대로 주어짐.
		// 2. 주어진 톱니바퀴 번호와 방향을 기준으로 톱니바퀴 회전.
		// 3. k회 회전 이후 12시 값 기준으로 점수 합산.

		// n극 s극 체크
		// 연결 확인
		// 회전
		// 순서 변경
		
		// 각 톱니바퀴 경우의 수를 나눈다?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		gear = new int[4][8];
		//기어 정보 입력
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				gear[i][j] = str.charAt(j)-'0';
			}
		}
		
		// 반복 횟수
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// 회전 정보
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
		// 좌측 검사
		for(int i=num-1; i>=0; i--) {
			if(gear[i][2]!=gear[i+1][6]) {
				dirArr[i] = dirArr[i+1] == 1 ? -1 : 1;
			}else break;
		}
		// 우측 검사
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
