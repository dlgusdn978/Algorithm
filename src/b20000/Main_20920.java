package b20000;

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
import java.util.StringTokenizer;

public class Main_20920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 단어의 개수 n
		int n = Integer.parseInt(st.nextToken());
		// 길이 최소 제한 m
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(str.length()>=m) {
				if(map.containsKey(str)) {
					map.put(str, map.get(str)+1);
				}else {
					map.put(str, 1);
				}
			}
		}
//		System.out.println(map);
		
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue()==o2.getValue() ? (o1.getKey().length()==o2.getKey().length() ? (o1.getKey().compareTo(o2.getKey())):o2.getKey().length()-o1.getKey().length()):o2.getValue()-o1.getValue();
			}
		});
		for(Entry<String, Integer> el : list) {
			sb.append(el.getKey()).append("\n");
		}
		System.out.println(sb.toString());
	}

}
