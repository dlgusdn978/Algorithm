package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654 {

	// 현재 가지고 있는 랜선 수
	static int n;
	// 만들어야 할 랜선 수
	static int m;
	// 전체 랜선의 길이
	static int total;
	// 각 랜선길이 배열
	static long[] arr;
	
	static long size;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		// 전체 랜선 길이의 합
		for(int i=0; i<n; i++) {
			long temp = Long.parseLong(br.readLine());
			total+= temp;
			arr[i] = temp;
		}
		Arrays.sort(arr);
		
		binarySearch();
		System.out.println(size-1);
	}

	static void binarySearch() {
		
		long start = 1;
		long end = arr[arr.length-1]+1;
		
		while(true) {
			long mid = (start+end)/2;
			if(start>=end) {
				size = mid;
				break;
			}
			int count = 0;
			for(long a : arr) {
				count += a/mid;
			}

			if(count<m) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
	}
}
