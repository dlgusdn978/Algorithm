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
			// ���� n��
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			// ���� �� m
			int m = Integer.parseInt(st.nextToken());
			
			// ���� �� �Է� �ޱ�.
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			// ���̰� ����
			int temp = Integer.MAX_VALUE;
			// m�� ���� �ټ��� ��
			int min = Integer.MAX_VALUE;
			
			int start = 0;
			int end = arr.length-1;
			// temp �� �μ��� �հ� ���� �� m �� ���� ������ ����.
			// ���� ���� ���� temp���� ũ�ٸ� end�� ������ ���̰�,
			// ``  temp���� �۴ٸ� start�� ������ �ø�.
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
