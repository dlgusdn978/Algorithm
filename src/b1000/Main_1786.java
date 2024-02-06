package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1786 {

	static char[] t;
	static char[] p;
	static int[] pi;
	static int total;
	public static void main(String[] args) throws IOException {
		// ���ڿ� ��Ī
		// ���λ�� ���̻��� �ִ� ���� ���� ���̸� ���ϰ�, 
		// ��ġ���� ���� ���� ���̻��� ��ġ�� �̵�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		pi = getSubset();
		ArrayList<Integer> res = kmp();
		// �׷���, ��ġ���� �ʴ� ��쿡�� ��ġ�ϴ� ���ڿ������� ���
		// suffix==prefix �� ���ϰ�, �ش� ��ġ�� �̵��ϴ� ���?
		
		// �ε����� 0���� ����.
		// ��ġ ī��Ʈ ����,
		// ī��Ʈ == str.length ��� total +1 �ϰ�, �ƴ϶�� prefix==suffix ���Ϸ�.
		System.out.println(res.size());
		for(int a : res) {
			System.out.println(a+1);
		}
		
	}
	
	static ArrayList<Integer> kmp() {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int j=0;
		for(int i=0; i<t.length; i++) {
			while(j>0 && t[i] != p[j]) {
				j = pi[j-1];
			}
			if(t[i]==p[j]) {
				if(j==p.length-1) {
					list.add(i-j);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		return list;
	}
	static int[] getSubset() {
		int[] pi = new int[p.length];
		int j=0;
		for(int i=1; i<p.length; i++) {
			while(j>0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if(p[i]==p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
