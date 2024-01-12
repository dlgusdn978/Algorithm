package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main_20291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			String str = br.readLine().split("\\.")[1];
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else {
				map.put(str, 1);
			}
		}
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		for(Entry<String,Integer> entry: list) {
			sb.append(entry.getKey()+" "+entry.getValue()).append("\n");
		}
		System.out.println(sb.toString());
	}

}
