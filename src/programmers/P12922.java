package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class P12922 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(3));
		
		System.out.println(sol.solution(4));
	}

	static class Solution {
		public String solution(int n) {
			StringBuilder answer = new StringBuilder();

			for (int i = 0; i < n; i++) {
				answer.append(i % 2 == 0 ? "수" : "박");	// i가 짝수인 경우 "수", 홀수인 경우 "박"
			}

			return answer.toString();
		}
	}

}
