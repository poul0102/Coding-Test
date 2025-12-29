package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class P42842 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(sol.solution(10, 2)));
		System.out.println(Arrays.toString(sol.solution(8, 1)));
		System.out.println(Arrays.toString(sol.solution(24, 24)));
	}

	static class Solution {
		public int[] solution(int brown, int yellow) {
			int[] answer = new int[2];

			// 전체 크기
			int size = brown + yellow;

			for (int i = 3; i < brown; i++) {
				// 불필요한 과정을 막기 위해 나누어 떨어지지 않으면 continue
				if (size % i != 0) continue;

				int h = size / i;

				// 테두리를 제외한 내부 영역 계산
				if ((i - 2) * (h - 2) == yellow) {
					answer[0] = i;
					answer[1] = h;
				}
			}

			return answer;
		}
	}

}
