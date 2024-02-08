package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1091 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// ī���� �� n
		int n = Integer.parseInt(br.readLine());
		
		// �迭 p
		int[] p = new int[n];
		
		// �迭 s
		int[] s = new int[n];
		// ī�� ���� �迭 arr
		int[] arr = new int[n];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int el = Integer.parseInt(st.nextToken());
			p[i] = el;
		}
//		System.out.println(Arrays.toString(p));
		
		
		// ���� ���� �Է�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int el = Integer.parseInt(st.nextToken());
			s[el] = i;
			arr[i] = i%3;
		}
		int[] clone = arr.clone();
		int[] temp = new int[n];
		int count = 0;
		while(!Arrays.equals(p, arr) && !(count!=0 && Arrays.equals(arr,clone))) {
			for(int i=0; i<n; i++) {
				temp[s[i]] = arr[i];
			}
			arr = temp.clone();
			count++;
		}
		if(count!=0 && Arrays.equals(arr, clone)) System.out.println(-1);
		else System.out.println(count);
	}
	
}
