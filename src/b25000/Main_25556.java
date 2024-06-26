package b25000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_25556 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		int[] arr = new int[4];
		
		
		st = new StringTokenizer(br.readLine());
		boolean flag = false;
		for(int i=0; i<n; i++) {
			flag = false;
			int cur = Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++) {
				if(arr[j]<cur) {
					arr[j] = cur;
					flag = true;
					break;
				}
			}
			if(!flag) break;
			
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
