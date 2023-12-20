package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// tc 수
		int n = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<n; tc++){
			// 입력한 명령어
			String oper = br.readLine();
			// 배열 원소의 갯수
			int num = Integer.parseInt(br.readLine());
			// 배열 원소
			String els = br.readLine().replace("[", "").replace("]", "");
			String[] elArray = els.split(",");
			
			int start = 0;
			int end = elArray.length-1;
			int index = start;
			boolean flag = true;
			for(int i=0; i<oper.length(); i++) {
				if(oper.charAt(i)=='R') {
					index = index==start ? end : start;
				}else if(oper.charAt(i)=='D') {
					if(num==0) {
						flag = false;
						break;
					}
					num -= 1;
					if(index==start) {
						elArray[index] = "";
						start+=1;
						index = start;
					}else if(index==end) {
						elArray[index] = "";
						end-=1;
						index = end;
					}
				}
			}
			if(flag) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(index==start) {
					for(int i=start; i<end; i++) {
						sb.append(elArray[i]+",");
					}
					sb.append(elArray[end]+"]");
				}else if(index==end) {
					for(int i=end; i>start; i--) {
						sb.append(elArray[i]+",");
					}
					sb.append(elArray[start]+"]");
				}
				System.out.println(sb.toString());
			}else {
				System.out.println("error");
			}
		}
	}
	class animal{
		String name;
		int age;
		
		void print() {
			System.out.println(name+" "+age);
		}
	}
	
}
