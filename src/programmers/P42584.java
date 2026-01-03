package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class P42584 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(sol.solution(new int[] { 1, 2, 3, 2, 3 })));
	}

	static class Solution {
		public int[] solution(int[] prices) {
			int pricesLen = prices.length;

			int[] answer = new int[pricesLen];
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < pricesLen; i++) {
				// 현재 가격이 스택의 top 인덱스 가격보다 낮은 경우
				while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
					// 가격이 떨어진 시점의 인덱스 pop
					int index = stack.pop();
					// 가격이 떨어지지 않은 시간 계산
					answer[index] = i - index;
				}
				// 현재 인덱스 스택에 저장
				stack.push(i);
			}

			// 끝까지 가격이 떨어지지 않은 인덱스 처리
			while (!stack.isEmpty()) {
				int index = stack.pop();
				answer[index] = pricesLen - 1 - index;
			}

			return answer;
		}
	}

}
