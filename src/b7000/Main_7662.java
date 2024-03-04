package b7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main_7662 {

	static int count, index;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(oper.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}else {
					if(map.size()==0) continue;
					
					int key = num==1 ? map.lastKey() : map.firstKey();
					if(map.put(key, map.get(key)-1)==1) {
						map.remove(key);
					}
				}
			}
			if(map.size()==0) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(map.lastKey()+" "+map.firstKey()).append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}

	

}
