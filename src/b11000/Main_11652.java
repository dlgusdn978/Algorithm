package b11000;

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

public class Main_11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Long, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			long temp = Long.parseLong(br.readLine());
			if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
			else map.put(temp, 1);
		}
		
		List<Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Long, Integer>>() {
			@Override
			public int compare(Entry<Long, Integer> o1 ,Entry<Long,Integer> o2) {
				 if(o1.getValue().equals(o2.getValue())) {
	                return Long.compare(o1.getKey(), o2.getKey());
	             }
	             return Integer.compare(o2.getValue(), o1.getValue());
			}
		});
		
		System.out.println(list.get(0).getKey());
		
	}

}
