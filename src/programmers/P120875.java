package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/120875
public class P120875 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] dots1 = { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } };
		System.out.println(sol.solution(dots1));

		int[][] dots2 = { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } };
		System.out.println(sol.solution(dots2));
	}

	static class Solution {
		public int solution(int[][] dots) {
			// (0, 1) vs (2, 3)
			if (slope(dots[0], dots[1], dots[2], dots[3]))
				return 1;

			// (0, 2) vs (1, 3)
			if (slope(dots[0], dots[2], dots[1], dots[3]))
				return 1;

			// (0, 3) vs (1, 2)
			if (slope(dots[0], dots[3], dots[1], dots[2]))
				return 1;

			return 0;
		}

		// 기울기를 직접 double로 나눠서 비교하면 부동소수점 오차 문제 발생
		// 따라서 기울기 비교 대신 곱셈 비교(교차곱)
		boolean slope(int[] a, int[] b, int[] c, int[] d) {
			return (a[0] - b[0]) * (c[1] - d[1]) == (a[1] - b[1]) * (c[0] - d[0]);
		}
	}

}
