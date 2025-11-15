package programmers;

import java.util.*;

public class P176963 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(
				sol.solution(
						new String[] { "may", "kein", "kain", "radi" }, 
						new int[] { 5, 10, 1, 3 },
						new String[][] { 
							{ "may", "kein", "kain", "radi" }, 
							{ "may", "kein", "brin", "deny" },
							{ "kon", "kain", "may", "coni" } 
						}
				)
		));

		System.out.println(Arrays.toString(
				sol.solution(
						new String[] { "kali", "mari", "don" }, 
						new int[] { 11, 1, 55 },
						new String[][] { 
							{ "kali", "mari", "don" }, 
							{ "pony", "tom", "teddy" }, 
							{ "con", "mona", "don" } 
						}
				)
		));

		System.out.println(Arrays.toString(
				sol.solution(
						new String[] { "may", "kein", "kain", "radi" }, 
						new int[] { 5, 10, 1, 3 },
						new String[][] { 
							{ "may" }, 
							{ "kein", "deny", "may" }, 
							{ "kon", "coni" } 
						}
				)
		));
	}

	static class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int[photo.length];

			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < name.length; i++) {
				map.put(name[i], yearning[i]);
			}

			for (int i = 0; i < photo.length; i++) {
				int sum = 0;
				for (int j = 0; j < photo[i].length; j++) {
					if (map.containsKey(photo[i][j]))
						sum += map.get(photo[i][j]);
				}
				answer[i] = sum;
			}

			return answer;
		}
	}

}
