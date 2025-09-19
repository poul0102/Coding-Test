package programmers;

import java.util.*;

public class P120882 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int [][] scores1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
		System.out.println(Arrays.toString(sol.solution(scores1)));
		
		int [][] scores2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
		System.out.println(Arrays.toString(sol.solution(scores2)));
		
	}

	static class Solution {
		public int[] solution(int[][] score) {
//			// 방법 1
//			int[] answer = new int[score.length];
//			int[] sum = new int[score.length]; // 총점을 저장할 배열
//
//			for (int i = 0; i < score.length; i++) {
//				sum[i] = score[i][0] + score[i][1];
//			}
//
//			Arrays.sort(sum); // 총점 정렬
//
//			int rank = score.length; // 등수를 저장할 변수(뒤에서 부터 등수 매기기)
//			for (int i = 0; i < score.length; i++) {
//				for (int j = 0; j < score.length; j++) {
//					if (sum[i] == score[j][0] + score[j][1]) { // sum 배열의 값이 score 배열의 값과 같다면
//						answer[j] = rank; // 등수 매기기
//					}
//				}
//				rank--; // 동점자가 있을 수 있기에 반복문 밖에서 rank--
//			}

			// 방법 2
			int[] answer = new int[score.length];
			Arrays.fill(answer, 1); // 모든 등수를 1로 초기화

			for (int i = 0; i < score.length; i++) {
				for (int j = 0; j < score.length; j++) {
					if (score[i][0] + score[i][1] > score[j][0] + score[j][1]) { // i번째의 값과 j번째의값 비교
						answer[j]++; // 비교해서 작다면 answer++로 등수 하나씩 내리기
					}
				}
			}

			return answer;
		}
	}

}
