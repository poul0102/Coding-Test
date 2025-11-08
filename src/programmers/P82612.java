package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class P82612 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(3, 20, 4));
	}

	static class Solution {
		public long solution(int price, int money, int count) {
			long answer = 0;

			for (int i = 1; i <= count; i++) {
				answer += price * i;
			}

			return (answer > money) ? answer - money : 0;
		}
	}

}
