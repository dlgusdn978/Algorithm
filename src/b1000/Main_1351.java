package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_1351 {

	
	static Map<Long, Long> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		
		long p = Long.parseLong(st.nextToken());
		
		long q = Long.parseLong(st.nextToken());
		
		// Ao = 1
		// An = An/p + An/q 
		
		map = new TreeMap<>();
		Long a = (long) 0;
		Long b = (long) 1;
		
		map.put(a, b);
		
		long res = recursive(n, p, q);
		System.out.println(res);
	}
	
	static long recursive(long a, long p, long q) {
//		System.out.println(a);
		if(map.containsKey(a)) return map.get(a);
		else {
			long temp = recursive(a/p, p, q)+recursive(a/q, p, q);
			map.put(a, temp);
			return temp;
		}
	}
}
