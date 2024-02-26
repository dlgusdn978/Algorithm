package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1297 {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		
		int h = Integer.parseInt(st.nextToken());
		
		int w = Integer.parseInt(st.nextToken());
		
		// 9:16비율이면 각각 9a, 16a라 칭하고, 피타고라스 삼각형이용.
		// 52^2 = 81a^2 + 256a^2
		
		double ratio = Math.sqrt(Math.pow(d, 2)/(Math.pow(h, 2)+Math.pow(w, 2)));
		
		int resH = (int) (ratio*h);
		int resW = (int) (ratio*w);
		System.out.println(resH+" "+resW);

	}

}
