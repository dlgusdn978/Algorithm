package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079 {

	static int n;
	static long m, total;
	static long count = Long.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �Ա� �ɻ���� ��
		n = Integer.parseInt(st.nextToken());
		// ��� ��
		m = Integer.parseInt(st.nextToken());
		// �ɻ�� �迭
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total = Math.max(total, arr[i]);
		}
		Arrays.sort(arr);
		
		long start = 0;
		long end = m * total;
		while(start<=end) {
			long mid = (start+end)/2;
			// �� �ɻ�뿡�� �ɻ� ���� �� 
			long temp = 0;
			for(int i=0; i<arr.length; i++) {
				if(temp>=m) break;
				temp += mid/arr[i];
			}
			if(temp>=m) {
				end = mid-1;
				count = Math.min(mid, count);
			}else {
				start = mid+1;
			}
		}
		System.out.println(count);
	}

}
