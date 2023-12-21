package b6000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6137 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = n-1;
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		String str = "";
		int count = 0;
		while(start<=end) {
			if(arr[start].compareTo(arr[end])>0) {
				sb.append(arr[end]);
				end-=1;
			}else if(arr[start].compareTo(arr[end])==0) {
				if(isFasterString(start, end, arr)) {
					sb.append(arr[end]);
					end-=1;
				}else {
					sb.append(arr[start]);
					start+=1;
				}
			}else if(arr[start].compareTo(arr[end])<0){
				sb.append(arr[start]);
				start+=1;
			}
			count++;
			if(count%80==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static boolean isFasterString(int start, int end, String[] arr) {
			boolean flag = false;
			while(start<=end) {
				if(arr[start].compareTo(arr[end])==0) {
					start++;
					end--;
				}else if(arr[start].compareTo(arr[end])>0){
					flag = true;
					break;
				}else {
					flag = false;
					break;
				}
			}
			return flag;
	}
}
