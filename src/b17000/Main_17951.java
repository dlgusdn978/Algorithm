package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17951 {

	public static void main(String[] args) throws IOException {
		// ��� ���� ���ϰ� ������ ������ ����.
		// �̺�Ž�� �����ϸ鼭 start, end�� �����ϰ� �� ������ ���� ���� ����� �Ѿ��� �� �߰� ����.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���� ������ ���� n
		int n = Integer.parseInt(st.nextToken());
		// ���� �׷��� �� k
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		int[] arr = new int[n];
		// ���� ����
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
