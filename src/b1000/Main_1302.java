package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else {
				map.put(str, 1);
			}
		}
//		System.out.println(map);
		
		List<Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());
		Collections.sort(entry, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()!=o1.getValue() ? o2.getValue()-o1.getValue() : o1.getKey().compareTo(o2.getKey());
			}
		});
//		System.out.println(entry);
		System.out.println(entry.get(0).getKey());
	}

}
