package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15824 {

	static int n;
	static long scoville[];
	static long pow[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 1~3의 원소를 사용한다고 가정할 때, 1과 3을 제외한 내부원소의 수는 (3-1)-1 개 => 경우의 수 1개
		// 1~4 (4-1)-1 = 2개
		// 2^n 개.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scoville = new long[n+1];
        pow = new long[n+1];

        pow[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            scoville[i] = Long.parseLong(st.nextToken());
            pow[i] = (pow[i-1]*2)%1000000007;
        }

        Arrays.sort(scoville);
        
        long res = 0;
        for(int i=1; i<=n; i++) {
        	res += (pow[i-1]-pow[n-i])*scoville[i];
        	res %= 1000000007;
        }
        System.out.println(res);
	}

	
}
