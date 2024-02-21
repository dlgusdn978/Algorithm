package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1235 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		String[] arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		int k=1;
		while(true) {
			int count = 0;
			Set<String> set = new HashSet<String>();
			for(int i=0; i<n; i++) {
				set.add(arr[i].substring(arr[i].length()-k,arr[i].length()));
			}
			
			if(set.size()==arr.length) break;
			k++;
//			System.out.println(set);
		}
		System.out.println(k);
	}

}
