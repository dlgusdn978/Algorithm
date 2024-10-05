package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2590 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[7];
		
		for(int i=1; i<=6; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		
		int count = 0;
		
		// 6짜리 색종이 연산
		count += arr[6];
		
		// 5짜리 색종이 연산
		if(arr[5]>0) {
			count += arr[5];
			arr[1] -= arr[5] * 11;
		}
		
		// 4짜리 색종이 연산
		if(arr[4]>0) {
			count += arr[4];
			if(arr[2]<=5*arr[4]) {
				if(arr[2] == 5 * arr[4]) {
					arr[2] -= arr[4]*5;
				}else {
					int cur = 0;
					// 4가 4장 있을 때 2는 20장 있어야함.
					// 그런데 2가 18장 있을 때는 2장 만큼의 남는 곳을 1로 채워야 함.
					// cur이 2임.
					// 
					cur = arr[4]*5 - arr[2];
					arr[2] -= arr[4] * 5;
					arr[1] -= cur * 4;
				}
				
			}else {
				arr[2] -= 5 * arr[4];
			}
		}
		
		// 3짜리 색종이 연산
		if(arr[3]>0) {
			if(arr[3]%4==0) {
				count += arr[3]/4;
			}else {
				count += arr[3]/4+1;
				if(arr[3]%4==3) {
					if(arr[2]>=1) {
						arr[2] -= 1;
						arr[1] -= 5;
					}else {
						arr[1] -= 9;
					}
				}else if(arr[3]%4==2) {
					if(arr[2]>=3) {
						arr[2]-=3;
						arr[1] -= 6;
					}else if(arr[2]==2) {
						arr[2] -=2;
						arr[1] -= 10;
					}else if(arr[2]==1) {
						arr[2] -=1;
						arr[1] -= 14;
					}else {
						arr[1] -= 18;
					}
				}else if(arr[3]%4==1) {
					if(arr[2]>=5) {
						arr[2] -= 5;
						arr[1] -= 7;
					}else if(arr[2]==4) {
						arr[2] -=4;
						arr[1] -=11;
					}else if(arr[2]==3) {
						arr[2] -= 3;
						arr[1] -= 15;
					}else if(arr[2]==2) {
						arr[2] -= 2;
						arr[1] -= 19;
					}else if(arr[2]==1) {
						arr[2] -= 1;
						arr[1] -= 23;
					}else {
						arr[1] -= 27;
					}
				}
			}
		}
		
		if(arr[2]>0) {
			if(arr[2]%9==0) {
				count += arr[2]/9;
			}else {
				count += arr[2]/9+1;
				if(arr[2]%9==8) {
					arr[2] -= 8;
					arr[1] -= 4;
				}else if(arr[2]%9==7) {
					arr[2] -= 7;
					arr[1] -= 8;
				}else if(arr[2]%9==6) {
					arr[2] -= 6;
					arr[1] -= 12;
				}else if(arr[2]%9==5) {
					arr[2] -= 5;
					arr[1] -= 16;
				}else if(arr[2]%9==4) {
					arr[2] -= 4;
					arr[1] -= 20;
				}else if(arr[2]%9==3) {
					arr[2] -= 3;
					arr[1] -= 24;
				}else if(arr[2]%9==2) {
					arr[2] -= 2;
					arr[1] -= 28;
				}else if(arr[2]%9==1) {
					arr[2] -= 1;
					arr[1] -= 32;
				}else {
					arr[1] -= 36;
				}
			}
		}
		if(arr[1]>0) {
			if(arr[1]%36==0) {
				count+=arr[1]/36;
			}else count+=arr[1]/36+1;
		}
		
		System.out.println(count);
	}

}
