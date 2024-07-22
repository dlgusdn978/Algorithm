package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_1032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String res = "";
		
		int n = Integer.parseInt(br.readLine());
		
		String[] strs = new String[n];
		for(int i=0; i<n; i++) {
			strs[i] = br.readLine();
		}

		for(int i=0; i<strs[0].length(); i++) {
			Set<Character> set = new HashSet<Character>();
			for(int j=0; j<strs.length; j++) {
				set.add(strs[j].charAt(i));
			}
			if(set.size()==1) res += strs[0].charAt(i);
			else res += "?";
		}
		System.out.println(res);
	}

}
