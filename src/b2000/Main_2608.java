package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main_2608 {

	static String resStr = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 현재 숫자가 다음 숫자보다 작으면 현재숫자와 작은숫자는 같이 쓰는 조합임.
		// I IV V IX X XL L XC C CD D CM M
		// 1 4 5 9 10 40 50 90 100 400 500 900 1000
//		
		Map<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);

		Set<Entry<String,Integer>> set = map.entrySet();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String val1 = br.readLine();
		String val2 = br.readLine();
		int res1 = getResult(val1, map);
		int res2 = getResult(val2, map);
		int res = res1+res2;
		System.out.println(res);
		System.out.println(dfs(res));
	}

	static String dfs(int res) {
		String[] romanSymbols = 
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = 
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder roman = new StringBuilder();
        
        for (int i = 0; i < romanValues.length; i++) {
            while (res >= romanValues[i]) {
                roman.append(romanSymbols[i]);
                res -= romanValues[i];
            }
        }
        return roman.toString();
	}

	static int getResult(String val, Map<String, Integer> map) {
		int res = 0;
		for (int i = 0; i < val.length(); i++) {
			if (i != val.length() - 1 && map.get(val.substring(i, i + 1)) < map.get(val.substring(i + 1, i + 2))) {
				res += map.get(val.substring(i, i + 2));
				i++;
				continue;
			}
			res += map.get(val.substring(i, i + 1));
		}
		return res;
	}
}
