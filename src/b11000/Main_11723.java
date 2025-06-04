package b11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int num = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("add")) {
				int val = Integer.parseInt(st.nextToken());
				num |= (1<<val);
			}else if(str.equals("remove")) {
				int val = Integer.parseInt(st.nextToken());
				num &= ~(1<<val);
			}else if(str.equals("check")) {
				int val = Integer.parseInt(st.nextToken());
				sb.append((num & (1<<val))!=0 ? 1 : 0).append("\n");
				
			}else if(str.equals("toggle")) {
				int val = Integer.parseInt(st.nextToken());
				num ^= (1<<val);
			}else if(str.equals("all")) {
				num = 0;
				for(int j=1; j<=20; j++) {
					num |= (1<<j);
				}
			}else {
				num = 0;
			}
		}

		System.out.println(sb.toString());
	}

}
