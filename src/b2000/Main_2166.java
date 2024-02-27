package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2166 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 기준이 되는 x, y가 가장작은 좌표를 하나 먼저 구하고
		// 해당 좌표와 다른 모든 좌표간의 벡터를 구함.
		// 외적.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		long[] x = new long[n+1];
		long[] y = new long[n+1];
		
		long sumX = 0;
		long sumY = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		x[n] = x[0];
		y[n] = y[0];
		
		for(int i=0; i<n; i++) {
			sumX += x[i] * y[i+1];
			sumY += x[i+1] * y[i];
		}
		System.out.printf("%.1f", Math.abs(sumX-sumY)/2.0);

	}

}
