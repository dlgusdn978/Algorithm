package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] visit = new boolean[1001];
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			map.put(str, i);
		}
		
		int count = 0;
		int rapid = 0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			boolean checker = true;
			int pre = 0;
			while(pre<map.get(str)) {
				if(!visit[pre]) {
					checker = false;
					break;
				}
				pre++;
			}
			if(!checker) {
				rapid++;
//				System.out.println(str);
			}
			visit[map.get(str)] = true;
			count++;
//			System.out.println(map.get("asdf"));
		}
		System.out.println(rapid);
	}

}
