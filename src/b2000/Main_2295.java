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
		// ����
		for(int i=n-1; i>=0; i--) {
			//����
			for(int j=i; j>=0; j--) {
				//�߰���
				for(int k=i; k>=j; k--) {
					// �� ���� ��� ������ �� end~arr.length���� Ž���ϱ�.
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
