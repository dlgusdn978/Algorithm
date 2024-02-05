package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_1411 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];

		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		int count = 0;
		// aa,bb
		// aa,cc
		// bb,cc
		// ab,cd
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				Map<Character, Character> map = new HashMap<>();
				char[] a = arr[i].toCharArray();
				char[] b = arr[j].toCharArray();
//				System.out.println(Arrays.toString(a));
//				System.out.println(Arrays.toString(b));
				// ���� ���� ���ڰ� �����ϴ� ��� ����.
				for(int k=0; k<a.length; k++) {
					if(a[k]==b[k]) map.put(a[k], b[k]);
				}
				// �ٸ� ������ �� ġȯ �� �Է�
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) {
						if(!map.containsKey(a[k])&&!map.containsValue(b[k])) {
							map.put(a[k], b[k]);
						}
					}
				}
				// �� ����
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) {
						if(map.containsKey(a[k])) a[k] = map.get(a[k]);
					}
				}
				// ��ġ ��
				boolean flag = true;
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) flag = false;
				}
				if(flag) count++;
//				System.out.println();
			}
		}
		System.out.println(count);
	}

}
