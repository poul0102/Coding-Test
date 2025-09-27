package programmers;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12941
public class P12941 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
		
		System.out.println(sol.solution(new int[]{1, 2}, new int[]{3, 4}));
	}

	static class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;

			Arrays.sort(A);
			Arrays.sort(B);

			// 작은 수 * 큰 수 => 최솟값
			for (int i = 0; i < A.length; i++) {
				answer += A[i] * B[B.length - 1 - i];	// A의 작은 수와 B의 큰 수를 곱해서 누적
			}

			return answer;
		}
	}

}
