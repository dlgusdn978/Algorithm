package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9024 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			// 정수 n개
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			// 비교할 수 m
			int m = Integer.parseInt(st.nextToken());
			
			// 집합 수 입력 받기.
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			// 차이값 저장
			int temp = Integer.MAX_VALUE;
			// m과 가장 근소한 수
			int min = Integer.MAX_VALUE;
			
			int start = 0;
			int end = arr.length-1;
			// temp 는 두수의 합과 비교할 수 m 의 차를 저장할 변수.
			// 현재 비교한 값이 temp보다 크다면 end의 범위를 줄이고,
			// ``  temp보다 작다면 start의 범위를 늘림.
			int count = 0;
			while(start<end) {
				int mid = (start+end)/2;
				int sum = arr[start]+arr[end];
				
				int diff = sum - m;
				
				if(diff<0) {
					start= start+1;
				}else {
					end = end-1;
				}
				if(Math.abs(diff)<=temp) {
					if(Math.abs(diff)<temp) {
						count = 1;
					}else {
						count++;
					}
					temp = Math.abs(diff);
					min = sum;
				}
			}
			System.out.println(count);
		}
	}

}
