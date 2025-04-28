package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table_Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class Solution {
	    static int[] parents;
	    public String[] solution(String[] commands) {
	        // 50x50 ǥ�� �����ϴ� ���α׷�
	        
	        // disjoint set?
	        // 2500���� ���Ҹ� ������ 1���� �迭�� Ǯ��?
	        StringBuilder sb = new StringBuilder();
	        String[] strs = new String[2500];
	        Arrays.fill(strs, "");
	        makeSet(2500);
	        String[] answer = {};
	        
	        for(int i=0; i<commands.length; i++){
	            String[] cmd = commands[i].split(" ");
	            if(cmd[0].equals("UPDATE")){
	                if(cmd.length==4){
	                    int r = Integer.parseInt(cmd[1]);
	                    int c = Integer.parseInt(cmd[2]);
	                    String val = cmd[3];
	                    update(strs, r-1, c-1, val);
	                }else{
	                    String val1 = cmd[1];
	                    String val2 = cmd[2];
	                    update(strs, val1, val2);
	                }
	            }else if(cmd[0].equals("MERGE")){
	                // System.out.println(cmd[1]+" "+cmd[2]+" "+cmd[3]+" "+cmd[4]+" ");
	                merge(strs, Integer.parseInt(cmd[1])-1, Integer.parseInt(cmd[2])-1, Integer.parseInt(cmd[3])-1, Integer.parseInt(cmd[4])-1);
	            }else if(cmd[0].equals("UNMERGE")){
	                unMerge(strs, Integer.parseInt(cmd[1])-1, Integer.parseInt(cmd[2])-1);
	            }else{
	                print(strs, sb, Integer.parseInt(cmd[1])-1, Integer.parseInt(cmd[2])-1);
	            }
	        }
	        // int cnt = 0;
	        // for(String str : strs){
	        //     System.out.print(str+" ");
	        //     cnt++;
	        //     if(cnt%50==0) System.out.println();
	        // }

	        answer = sb.toString().split(" ");
	        return answer;
	    }
	    // update r c value => (r,c) = value
	    static void update(String[] strs, int r, int c, String cmd){
	        int parent = findSet(r*50+c);
	        strs[parent] = cmd;
	    }
	    // update r c => ��� r ���� c�� ����
	    static void update(String[] strs, String str1, String str2){
	        for(int i=0; i<strs.length; i++){
	            if(strs[i].equals(str1)) {
	                int parent = findSet(i);
	                strs[parent] = str2;
	            }
	        }
	    }
	    // merge r1 c1 r2 c2 => �� ����. �� ���� ���� �ִ� �ŷ� ������ ä��. �Ѵ� ������ �ִٸ� r1 c1 ��������.
	    //  disjoint set�� Ȱ���ؼ� ���հ��� ����
	    static void merge(String[] strs, int r1, int c1, int r2, int c2){
	        if(r1==r2 && c1==c2) return;
	        int parent1 = parents[r1*50+c1];
	        int parent2 = parents[r2*50+c2];
	        String val1 = strs[parent1];
	        String val2 = strs[parent2];

	        if(val1.equals("")) union(r2*50+c2, r1*50+c1);
	        else {
	            if(!val2.equals("")) strs[parent2] = "";
	            union(r1*50+c1, r2*50+c2);
	        }
	        
	    }
	    // unmerge r c => ���� ����. ���� ��ġ�� �� ����� ������ ����
	    static void unMerge(String[] strs, int r, int c){
	        // disjoint set�� �θ� ��ġ�� parents[r*50+c];
	        int parent = parents[r*50+c];
	        String val = strs[parent];
	        strs[parent] = "";
	        List<Integer> list = new ArrayList<>();
	        for(int i=0; i<strs.length; i++){
	            if(parents[i]==i) list.add(i);
	        }
	        for(int i : list){
	            parents[i] = i;
	        }
	       
	        strs[50*r+c] = val;
	    }
	    
	    // print r c => �� �� ���. �� ��������� empty ���
	    static void print(String[] strs, StringBuilder sb, int r, int c){
	        int parent = parents[r*50+c];
	        String val = strs[parent].equals("") ? "EMPTY" : strs[parent];
	        sb.append(val).append(" ");
	    }
	    static void makeSet(int n){
	        parents = new int[n+1];
	        for(int i=1; i<=n; i++){
	            parents[i] = i;
	        }
	    }
	    static int findSet(int v1){
	        if(v1==parents[v1]) return v1;
	        else return parents[v1] = findSet(parents[v1]);
	    }
	    static void union(int v1, int v2){
	        int aRoot = findSet(v1);
	        int bRoot = findSet(v2);
	        if(aRoot==bRoot) return;
	        parents[bRoot] = aRoot;
	    }
	}

}
