package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		char[] charArr = new char[10];
		boolean[] visit = new boolean[26];
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		for(int i=0; i<arr.length; i++) {
			String temp = arr[i];
			int len = temp.toCharArray().length;
			//[a,a,a];
			for(int j=0; j<temp.toCharArray().length; j++) {
				alphabet[temp.toCharArray()[j]-65] += (int) Math.pow(10, len-1);
				len--;

			}
		}
		int cur = 9;
		for(int i=0; i<charArr.length; i++) {
			int temp = 0;
			int index =0;
			
			for(int j=0; j<alphabet.length; j++) {
				if(visit[j]) continue;
				if(alphabet[j]>temp) {
					temp = alphabet[j];
					index = j;
				}
			}
			if(visit[index])continue;
			visit[index] = true;
			charArr[cur] = (char) (index+'A');
			cur--;
		}
		
		long sum = 0;
		for(int i=0; i<arr.length; i++) {
			String temp ="";
			for(int j=0; j<arr[i].toCharArray().length;j++) {
				for(int k=0; k<charArr.length; k++) {
					if(arr[i].toCharArray()[j]==charArr[k])temp+=k;
				}
			}
			sum+=Long.parseLong(temp);
		}
		System.out.println(sum);
		
	}

}
