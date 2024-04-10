package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3078 {

	public static void main(String[] args) throws IOException {
		// �ڽŰ� �� ����� ���̰� k �� ������ ģ���� �ƴϴ�.
		// ����� ���̰� k���� �۰ų� �����鼭 �̸��� ���̰� ���ƾ� ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// �̸��� ����
		int[] names = new int[n];
		// k ���� �� �̸��� �̸� ���� ����Ʈ
		int[] nameLength = new int[21];
		
		for(int i=0; i<n; i++) {
			names[i] = br.readLine().length();
		}
		
		for(int i=0; i<=(k==n ? k-1 : k); i++) {
			nameLength[names[i]]+=1;
		}
		
//		System.out.println(Arrays.toString(nameLength));

		long count = 0;
		
		int start = 0;
		int end = (k==n ? k-1 : k);
		
		while(start<end) {
			count+= nameLength[names[start]]-1;
			
			nameLength[names[start]] -= 1;
			start++;
			
			if(end!=n-1) {
				end++;
				nameLength[names[end]] += 1;
			}
		}
		System.out.println(count);
	}

}
