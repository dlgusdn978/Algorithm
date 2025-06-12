package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sheeps_Wolves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static List<List<Integer>> list;
	    static int max = 0;
	    public int solution(int[] info, int[][] edges) {
	        int answer = 0;
	        list = new ArrayList<>();
	        for(int i=0; i<info.length; i++){
	            list.add(new ArrayList<>());
	        }
	        for(int i=0; i<edges.length; i++){
	            list.get(edges[i][0]).add(edges[i][1]);
	        }
	        
	        dfs(0, 0, 0, new ArrayList<>(Arrays.asList(0)), info);
	        answer = max;
	        return answer;
	    }
	    static void dfs(int parent, int sheep, int wolf, List<Integer> nextNodes, int[] info){
	        if(info[parent]==0) sheep++;
	        else wolf++;
	        
	        if(wolf>=sheep) return;
	        max = Math.max(max, sheep);
	        
	        List<Integer> child = new ArrayList<>(nextNodes);
	        child.remove(Integer.valueOf(parent));
	        child.addAll(list.get(parent));
	        
	        for(int next: child){
	            dfs(next, sheep, wolf, child, info);
	        }
	        
	    }
	}
}
