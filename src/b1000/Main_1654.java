package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654 {

	// ���� ������ �ִ� ���� ��
	static int n;
	// ������ �� ���� ��
	static int m;
	// ��ü ������ ����
	static int total;
	// �� �������� �迭
	static long[] arr;
	
	static long size;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		// ��ü ���� ������ ��
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
