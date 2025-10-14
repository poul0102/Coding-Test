package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class P12930 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution("try hello world"));
	}

	static class Solution {
		public String solution(String s) {
			StringBuilder answer = new StringBuilder();

			// 소문자로 변경 후 한 글자씩 나누기
			String[] splits = s.toLowerCase().split("");

			int count = 0;

			for (String split : splits) {
				// 공백이면 카운트 리셋
				if (split.equals(" ")) {
					answer.append(" ");
					count = 0;
					continue;
				}

				answer.append(count % 2 == 0 ? split.toUpperCase() : split);
				count++;
			}

			return answer.toString();
		}
	}
}
