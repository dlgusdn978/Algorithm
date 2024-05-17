package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		long sum = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum+=num;
		}
		
		Arrays.sort(arr);
		
		long max = 0;
		
		// 1~n...
		// n~last
		// temp = 구간 평균값
		// arr[i] = 구간 내 최소값
		// 평균값이 최소보다 크면 최소 기준 max값
		// 반대라면 
		for(int i=0; i<n; i++) {
			long temp = sum/(n-i);
			if(temp>=arr[i]) {
				max = Math.max(arr[i]*(n-i), max);
			}else {
				max = Math.max(sum, max);
			}
		}
		System.out.println(max);
	}

}
