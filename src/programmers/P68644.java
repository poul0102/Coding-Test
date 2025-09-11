package programmers;

import java.util.*;

public class P68644 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] numbers1 = {2, 1, 3, 4, 1};
		System.out.println(Arrays.toString(sol.solution(numbers1)));
		
		int[] numbers2 = {5, 0, 2, 7};
        System.out.println(Arrays.toString(sol.solution(numbers2)));
	}
}

class Solution {
	public int[] solution(int[] numbers) {
		ArrayList<Integer> num = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];
				
				if(!num.contains(sum)) {
					num.add(sum);
				}
			}
		}
		
		Collections.sort(num);
		
		int[] answer = new int[num.size()];
		
		for(int i = 0; i < num.size(); i++) {
			answer[i] = num.get(i);
		}
		
		return answer;
	}
}