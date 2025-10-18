package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class P42748 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(sol.solution(array, commands)));
	}

	static class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int len = commands.length;
			int[] answer = new int[len];

			for (int i = 0; i < len; i++) {
				int st = commands[i][0];
				int ed = commands[i][1];
				int k = commands[i][2];

				// 특정 범위 배열 복사
				int[] temp = Arrays.copyOfRange(array, st - 1, ed);

				Arrays.sort(temp);

				answer[i] = temp[k - 1];
			}

			return answer;
		}
	}

}
