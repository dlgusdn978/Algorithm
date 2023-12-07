package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1062 {
	static int n, k, count;
	static String[] arr;
	static boolean[] alpha;
	static List<Character> antatica;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// anta
		// tica
		// a, c, i, n, t
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u ,v, w, x, y, z
		// 단어의 개수 n
		n = Integer.parseInt(st.nextToken());
		// 가르칠 수 있는 글자 수 k
		k = Integer.parseInt(st.nextToken())-5;
		if(k<0) {
			System.out.println(0);
			return;
		}
		antatica = new ArrayList<Character>();
		// 선택한 알파벳 배열
		alpha = new boolean[26];
		
		int[] alphaNum = {0, 2, 8, 13, 19};
		for(int num : alphaNum) {
			antatica.add((char)(num+97));
			alpha[num] = true;
		}
		arr = new String[n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			str = str.substring(4, str.length()-4);
			String res = "";
			for(int j=0; j<str.length(); j++) {
				if(!antatica.contains(str.charAt(j))) {
					res += str.charAt(j);
				}
			}
			arr[i] = res;
		}
		dfs(0, 0);
		System.out.println(count);
	}

	static void dfs(int next, int select) {
		if(select == k) {
			int temp = 0;
			for(int i=0; i<arr.length; i++) {
				boolean flag = true;
				for(int j=0; j<arr[i].length();j++) {
					if(!alpha[arr[i].charAt(j)-97]) {
						flag = false;
						break;
					}
				}
				if(flag) temp++;
			}
			if(count< temp) count = temp;
			return;
		}
		for(int i=next; i<alpha.length; i++) {
			if(alpha[i]) continue;
			alpha[i] = true;
			dfs(i+1, select+1);
			alpha[i] = false;
		}
	}
}
