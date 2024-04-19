package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1354 {

	static Map<Long, Long> map;
	static long p, q, x, y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map = new HashMap<Long, Long>();
		
		long n = Long.parseLong(st.nextToken());
		
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());

		System.out.println(recursive(n));
			
	}
	
	static long recursive(long n) {
		if(n<=0) return 1;
		if(map.containsKey(n)) return map.get(n);
		long leftKey = n/p-x;
		long rightKey = n/q-y;
		long left = recursive(leftKey);
		long right = recursive(rightKey);
//		System.out.println(leftKey+" : "+left+"     "+rightKey+" : "+right);
		map.put(leftKey, left);
		map.put(rightKey, right);
		map.put(n, left+right);
		return map.get(n);
	}
	
}
