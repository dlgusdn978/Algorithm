package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1421 {

	public static void main(String[] args) throws IOException {
		// 이분 탐색
		// 가장 짧은 나무를 기준으로 이분 탐색 수행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long w = Long.parseLong(st.nextToken());

		long[] arr = new long[(int) n];
		long maxLen = Long.MIN_VALUE;
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			arr[i] = num;
			maxLen = Math.max(maxLen, num);
		}
		long max = Long.MIN_VALUE;
		for(int i=1; i<=maxLen; i++) {
			long sum = 0;
			for(int j=0; j<n; j++) {
				if(arr[j]<i) continue;
				long res = getTotalValue(arr, c, w, i);
				if(res>0) max = Math.max(max, res);
			}

		}
		System.out.println(max);
	}
	

	static long getTotalValue(long[] arr, long c, long w, long size) {
		long val = 0;
		for(int i=0; i<arr.length; i++) {
			long cutCnt = arr[i]%size==0 ? arr[i]/size-1 : arr[i]/size;
			long max = w*size*(arr[i]/size)-cutCnt*c;
			if(max>0) val+=max;
		}

		return val;
	}

}
