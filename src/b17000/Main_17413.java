package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17413 {

	public static void main(String[] args) throws IOException {
		// 태그는 단어가 아니다.
		// 태그 바깥에 있는 단어들의 순서만 reverse order
		// 공백을 기준으로 단어를 나누고 reverse
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
//		System.out.println(Arrays.toString(arr));
		
		String str = "";
		// 괄호 안에 있는 문자열인지 체크
		String temp = "";
		boolean flag = false;
		for(int i=0; i<arr.length;i++) {
			char cur = arr[i];

			if(flag) {
				// 괄호 안에 있을 때
				if(cur=='>') {
					str+='<';
					for(int j=0; j<temp.length(); j++) {
						str+=temp.charAt(j);
					}
					str+='>';
					flag = false;
					temp="";
					continue;
				}
				temp+= cur;
			}else {
				// 괄호 안에 있지 않을 때
				if(cur=='<') {
					for(int j=temp.length()-1; j>=0; j--) {
						str+=temp.charAt(j);
					}
					flag = true;
					temp="";
					continue;
				}else if(cur==' ') {
					for(int j=temp.length()-1; j>=0; j--) {
						str+=temp.charAt(j);
					}
					str+=" ";
					temp="";
					continue;
				}
				
				temp+=cur;
			}
		}
		for(int j=temp.length()-1; j>=0; j--) {
			str+=temp.charAt(j);
		}
		System.out.println(str);
	}

}
