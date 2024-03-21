package b6000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_6987 {

	static boolean isAbleToGame;
	static int[][] arr, matches;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<4; tc++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[6][3];
			matches = new int[15][2];
			int index = 0;
			for(int i=0; i<5; i++) {
				for(int j=i+1; j<6; j++) {
					matches[index][0] = i;
					matches[index][1] = j;
					index++;
				}
			}
			isAbleToGame = false;
			int count = 0;
			boolean flag = true;
			for(int i=0; i<6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				arr[i][0] = win;
				arr[i][1] = draw;
				arr[i][2] = lose;
				// 조건은 모든 팀의 경기가 각 5회, 전체 30회 진행 되어야 함. 조건 추가.
				// 무승부 경기도 여기서 처리.

				if(win+draw+lose!=5) flag = false;
				
//				System.out.println(win+" "+draw+" "+lose);
			}
			if(flag) {
				
				backTracking(0, 15);
				if(isAbleToGame) {
					System.out.print(1+" ");
				}else {
					System.out.print(0+" ");
				}
				
			}else {
				System.out.print(0+" ");
			}
		}
	}

	static void backTracking(int matchCount, int count) {
//		System.out.println(matchCount);
		if(isAbleToGame) {
			return;
		}
		
		if(matchCount==count) {
			isAbleToGame = true;
			return;
		}
		
		int home = matches[matchCount][0];
		int enemy = matches[matchCount][1];
		
		if(arr[home][0]>0 && arr[enemy][2]>0) {
			arr[home][0]--;
			arr[enemy][2]--;
			backTracking(matchCount+1, count);
			arr[home][0]++;
			arr[enemy][2]++;
		}
		if(arr[home][1]>0 && arr[enemy][1]>0) {
			arr[home][1]--;
			arr[enemy][1]--;
			backTracking(matchCount+1, count);
			arr[home][1]++;
			arr[enemy][1]++;
		}
		if(arr[home][2]>0 && arr[enemy][0]>0) {
			arr[home][2]--;
			arr[enemy][0]--;
			backTracking(matchCount+1, count);
			arr[home][2]++;
			arr[enemy][0]++;
		}
	}
}
