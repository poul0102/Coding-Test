package programmers;

import java.util.Arrays;

public class P181902 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		String my_string = "Programmers";
		System.out.println(Arrays.toString(sol.solution(my_string)));
	}

	static class Solution {
		public int[] solution(String my_string) {
			int[] answer = new int[52];

			for (int i = 0; i < my_string.length(); i++) { // 문자열에서 문자 하나씩 확인하기 위한 반복문
				char c = my_string.charAt(i);

				if (Character.isUpperCase(c)) { // 대문자인 경우
					answer[(int) (c - 'A')]++;
				} else { // 소문자인 경우
					answer[(int) (c - 'a' + 26)]++;
				}
			}

			return answer;
		}
	}

}
