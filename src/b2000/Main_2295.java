package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_2295 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		// 끝점
		for(int i=n-1; i>=0; i--) {
			//시작
			for(int j=i; j>=0; j--) {
				//중간점
				for(int k=i; k>=j; k--) {
					// 세 수를 모두 더했을 때 end~arr.length까지 탐색하기.
					int sum = arr[i]+arr[j]+arr[k];
					if(Arrays.binarySearch(arr, i, n, sum)>=0) {
						if(max<sum) max = sum;
						break;
					}
				}
			}
		}
		System.out.println(max);
	}

}
