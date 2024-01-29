package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17951 {

	public static void main(String[] args) throws IOException {
		// 모든 수를 합하고 집합의 개수로 나눔.
		// 이분탐색 수행하면서 start, end를 갱신하고 그 구간의 합이 위의 결과를 넘었을 때 추가 갱신.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 시험 문제의 개수 n
		int n = Integer.parseInt(st.nextToken());
		// 나눌 그룹의 수 k
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		int[] arr = new int[n];
		// 시험 문제
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			count += temp;
		}

		
		int start = 0;
		int end = count;
		while(start<=end) {
			int mid = (start+end)/2;
			int sum = 0;
			int groupCount = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				sum+=arr[i];
				if(sum>=mid) {
					min = Math.min(min, sum);
					groupCount+=1;
					sum=0;
				}
			}
			if(groupCount>=k) start = mid + 1;
			else end = mid-1;
		}
		System.out.println(end);
	}

}
