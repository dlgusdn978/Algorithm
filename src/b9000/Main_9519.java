package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_9519 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		// srama
		// sarma
		// saamr
		// srama
		// sarma
		// saamr
		List<String> list = new ArrayList<>();
		while(!list.contains(str)) {
			list.add(str);
			str = makeString(str);
		}
//		for(String a : list) {
//			System.out.println(a);
//		}
		int count = n%list.size();
		// 5 4
		// 1000 1000
		System.out.println(count==0 ? list.get(list.size()-1) : list.get(list.size()-count));
	}

	// 5개 단어 반복, n=1 -> 마지막 단어 고르기
	// 5개 단어 반복, n=5 -> 첫번재단어
	// 4개 단어 반복, n=5, n=1 -> 마지막 단어
	// 1개 단어 반복, n=100, n=1 -> 마지막 단어
	static String makeString(String str) {
		String temp = "";
		for(int i=0; i<str.length()/2; i++) {
			temp += str.substring(i, i+1);
			temp += str.substring(str.length()-i-1, str.length()-i);
		}
		if(str.length()%2==1) temp+= str.substring(str.length()/2, (str.length()/2)+1);
		return temp;
	}
}
