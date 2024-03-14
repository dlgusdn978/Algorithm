package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] arr = new char[n][n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int rowCount = 0;
		int colCount = 0;
		
		if(n<=1) {
			System.out.println(rowCount+" "+colCount);
			return;
		}
		
		for(int i=0; i<n; i++) {
			int count = 0;
			int col = 0;
			while(col<n) {
				if(arr[i][col]=='.') {
//					System.out.println(col);
					count++;
					if(count==n) {
//						System.out.println(i+" "+rowCount+" "+count);
						rowCount++;
						break;
					}else if(col==n-1 && count>=2) {
						rowCount++;
						break;
					}
				}else if(arr[i][col]=='X') {
					
					if(count>=2) {
//						System.out.println(i+" "+rowCount+" "+count);
						rowCount++;
					}
					count=0;
				}
				col++;
			}
		}
		
		for(int i=0; i<n; i++) {
			int count = 0;
			int row = 0;
			while(row<n) {
				if(arr[row][i]=='.') {
//					System.out.println(row);
					count++;
					if(count==n) {
//						System.out.println(i+" "+colCount+" "+count);
						colCount++;
						break;
					}else if(row==n-1 && count>=2) {
						colCount++;
						break;
					}
				}else if(arr[row][i]=='X') {
					
					if(count>=2) {
//						System.out.println(i+" "+colCount+" "+count);
						colCount++;
					}
					count=0;
				}
				row++;
			}
		}
		System.out.println(rowCount+" "+colCount);
	}

}
