package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20207 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[][] schedules = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			schedules[i][0] = Integer.parseInt(st.nextToken());
			schedules[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] calendar = new int[366];
		
		for(int i=0; i<n; i++) {
			int start = schedules[i][0];
			int end = schedules[i][1];
			for(int j=start; j<=end; j++) {
				calendar[j]++;
			}
		}
		
		int sum =0;
		int height =0;
		int width =0;
		for(int i=1; i<=365; i++) {
			if(calendar[i]>0) {
				height = Math.max(height, calendar[i]);
				width++;
			}else {
				sum += width*height;
				width=0;
				height=0;
			}
		}
		if(width>0) {
			sum+=width*height;
		}
		System.out.println(sum);
	}

}
