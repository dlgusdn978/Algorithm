package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		String[] strs = new String[c];
		Arrays.fill(strs, "");
		for(int i=0; i<r; i++) {
			String temp = br.readLine();
			for(int j=0; j<temp.length(); j++) {
				strs[j] += temp.charAt(j);
			}
		}
//		System.out.println(Arrays.toString(strs));
		
		Set<String> set;
		
		// 
		int count = 0;
		for(int i=1; i<r; i++) {
			set = new HashSet<>();
			boolean checker = true;
			for(int j=0; j<c; j++) {
				String cur = strs[j].substring(i, strs[i].length());
//				System.out.println(cur);
				if(set.contains(cur)) {
					checker = false;
					break;
				}else{
					set.add(cur);
				}
			}
			if(!checker) break;
			else count++;
		}
		System.out.println(count);
	}

}
