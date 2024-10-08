package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116 {

	static int max = -1;
	static int[] indexes = {5, 3, 4, 1, 2, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dice = new int[n][6];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<6; i++) {
			int diceMax = 0;
			for(int j=0; j<6; j++) {
				if(i==j || j==indexes[i]) continue;
				diceMax = Math.max(diceMax, dice[0][j]);
			}
			dfs(dice, dice[0][i], 1, diceMax);
		}
		System.out.println(max);
	}
	
	static void dfs(int[][] dice, int upper, int count, int sum) {
		if(count==dice.length) {
			max = Math.max(max, sum);
			return;
		}
		int index = 0;
		for(int i=0; i<6; i++) {
			if(dice[count][i]==upper) {
				index = i;
				break;
			}
		}
//		System.out.println(index);
		int nextUpper = indexes[index];
		int curMax = 0;
		for(int i=0; i<6; i++) {
			if(i==index || i==nextUpper) continue;
			curMax = Math.max(curMax, dice[count][i]);
		}
		dfs(dice, dice[count][nextUpper], count+1, sum+curMax);
	}
	
}
