package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2530 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int time = Integer.parseInt(br.readLine());
		
		s += time;
		
		m += s/60;
		s %= 60;
		
		h += m/60;
		m %= 60;
		
		h %= 24;
		System.out.println(h+" "+m+" "+s);
	}

}
