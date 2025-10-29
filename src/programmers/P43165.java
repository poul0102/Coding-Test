package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class P43165 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(new int[] { 1, 1, 1, 1, 1 }, 3));
		System.out.println(sol.solution(new int[] { 4, 1, 2, 1 }, 4));
	}

	static class Solution {
		int[] numbers;
		int target;
		int answer;

		public int solution(int[] numbers, int target) {
			answer = 0;
			this.numbers = numbers;
			this.target = target;

			dfs(0, 0);

			return answer;
		}

		void dfs(int index, int sum) {
			// 모든 숫자를 다 사용했다면
			if (index == numbers.length) {
				// 누적 합이 타겟과 같다면 answer++
				if (sum == target) answer++;
				return;
			}

			// 현재 숫자에 '+'
			dfs(index + 1, sum + numbers[index]);
			// 현재 숫자에 '-'
			dfs(index + 1, sum - numbers[index]);
		}
	}

}
