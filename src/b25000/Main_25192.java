package b25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main_25192 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int num = 0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			list.add(str);	
			if(!map.containsKey(str)) map.put(str, num++);
		}
		
		int size = map.size();
		
		String[] str = new String[size];
		int[] count = new int[size];
		
		int res = 0;
		
		for(int i=0; i<list.size(); i++) {
			String cur = list.get(i);
			if(cur.equals("ENTER")) Arrays.fill(count, 0);
			else {
				count[map.get(cur)]+=1;
				if(count[map.get(cur)]<=1) res++; 
			}
		}
//		System.out.println(Arrays.toString(count));
		System.out.println(res);

	}

}
