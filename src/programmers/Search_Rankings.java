package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search_Rankings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	static class Solution {
	    
	    public int[] solution(String[] info, String[] query) {

	        Map<String, Integer> map = new HashMap<>();
	        List<List<Integer>> list = new ArrayList<>();
	        int[] answer = new int[query.length];
	        for(int i=0; i<info.length; i++){
	            setting(map, list, info[i]);
	        }
	        for(int i=0; i<list.size(); i++){
	            Collections.sort(list.get(i));
	            Collections.reverse(list.get(i));
	        }
	        
	        for(int i=0; i<query.length; i++){
	            int cnt = 0;
	            String[] strs = query[i].split(" and ");
	            String[] lastStrs = strs[3].split(" ");
	            String temp = strs[0]+strs[1]+strs[2]+lastStrs[0];
	            if(!map.containsKey(temp)) continue;

	            int limitScore = Integer.parseInt(lastStrs[1]);
	            int key = map.get(temp);
	            
	            int start = 0;
	            int end = list.get(key).size()-1;
	            while(start<=end){
	                int mid = (start+end)/2;
	                if(list.get(key).get(mid)>=limitScore) start = mid+1;
	                else end = mid-1;
	            }
	            answer[i] = start;
	        }
	        return answer;
	    }
	    static void setting(Map<String, Integer> map, List<List<Integer>> list, String info){
	        String[] strs = info.split(" ");
	        
	        for(int i=0; i<2; i++){
	            for(int j=0; j<2; j++){
	                for(int k=0; k<2; k++){
	                    for(int l=0; l<2; l++){
	                        StringBuilder sb = new StringBuilder();
	                        sb.append(i==0 ? strs[0] : "-");
	                        sb.append(j==0 ? strs[1] : "-");
	                        sb.append(k==0 ? strs[2] : "-");
	                        sb.append(l==0 ? strs[3] : "-");
	                        
	                        String res = sb.toString();

	                        if(!map.containsKey(res)) {
	                            map.put(res, map.size());
	                            list.add(new ArrayList<>());
	                        }
	                        list.get(map.get(res)).add(Integer.parseInt(strs[4]));
	                        
	                    }
	                }
	            }
	        }

	    }
	}
}
