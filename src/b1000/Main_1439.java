package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main_1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		int count = 0;
		String str = "";
		while((str = br.readLine())!=null) {
			count++;
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else {
				map.put(str, 1);
			}
		}
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
//		System.out.println(list.get(0).getKey());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
//		System.out.println(count);
//		System.out.println(list);
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Integer> el : list) {
//			System.out.println(el.getKey()+" "+(Math.(double)(el.getValue())/count*100));
			sb.append(el.getKey()+" ");
			sb.append(String.format("%.4f",((double)(el.getValue())/count*100)));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
