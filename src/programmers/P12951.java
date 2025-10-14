package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class P12951 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution("3people unFollowed me"));

		System.out.println(sol.solution("for the last week"));
	}

	static class Solution {
		public String solution(String s) {
			StringBuilder answer = new StringBuilder();

			// 소문자로 변경 후 띄어쓰기를 기준으로 나누기(-1 : 공백 유지)
			String[] splits = s.toLowerCase().split(" ", -1);

			for (String split : splits) {
				// split이 빈 문자열일 경우 에러 발생
				if (split.length() == 0) {
					answer.append(" ");
					continue;
				}

				answer.append(split.substring(0, 1).toUpperCase())
					  .append(split.substring(1))
					  .append(" ");
			}

			// 마지막 공백 제거
			if (answer.length() > 0)
				answer.setLength(answer.length() - 1);
			
			return answer.toString();
		}
	}

}
