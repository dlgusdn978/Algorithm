package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_1034 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//행의 수 r
		int r = Integer.parseInt(st.nextToken());
		//열의 수 c
		int c = Integer.parseInt(st.nextToken());
		// 뒤집는 수
		int cnt = 0;
		// 램프 정보
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		int k = Integer.parseInt(br.readLine());
		int maxRows = 0;
		
		for(Entry<String, Integer> m: map.entrySet()) {
			String pattern = m.getKey();
			int zeroCount = 0;
			
			for(char ch : pattern.toCharArray()) {
				if(ch=='0') zeroCount++;
			}
			
			if(zeroCount<=k && zeroCount%2==k%2) {
				maxRows = Math.max(maxRows, m.getValue());
			}
		}
		System.out.println(maxRows);
	}

	
}
