package programmers;

public class P159994 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		System.out.println(sol.solution(cards1, cards2, goal));
	}
	
	static class Solution {
		public String solution(String[] cards1, String[] cards2, String[] goal) {
			String answer = "Yes";

			int index1 = 0;
			int index2 = 0;

			for (int i = 0; i < goal.length; i++) {
				if (cards1[index1].equals(goal[i])) {
					index1 = (index1 < cards1.length - 1) ? index1 + 1 : index1;
				} else if (cards2[index2].equals(goal[i])) {
					index2 = (index2 < cards2.length - 1) ? index2 + 1 : index2;
				} else {
					answer = "No";
				}
			}

			return answer;
		}
	}	
}