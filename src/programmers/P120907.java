package programmers;

import java.util.Arrays;

public class P120907 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		String[] quiz1 = { "3 - 4 = -3", "5 + 6 = 11" };
		System.out.println(Arrays.toString(sol.solution(quiz1)));

		String[] quiz2 = { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" };
		System.out.println(Arrays.toString(sol.solution(quiz2)));
	}

	static class Solution {
		public String[] solution(String[] quiz) {
			String[] answer = new String[quiz.length];

			for (int i = 0; i < quiz.length; i++) {
				String[] split = quiz[i].split(" ");	// 공백을 기준으로 분리

				int num1 = Integer.parseInt(split[0]); // 첫번째 피연산자
				int num2 = Integer.parseInt(split[2]); // 두번째 피연산자
				int result = Integer.parseInt(split[4]); // 결과값

				// 연산자에 따라 실제 계산 후 결과값과 비교
				if (split[1].equals("-")) {
					answer[i] = (result == num1 - num2) ? "O" : "X";
				} else {
					answer[i] = (result == num1 + num2) ? "O" : "X";
				}
			}

			return answer;
		}
	}

}
