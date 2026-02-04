package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class P42747 {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);	// 인용 횟수 오름차순 정렬

		int c = citations.length;	// 전체 논문 수
		
		// 정렬된 배열 순회
		for (int i = 0; i < c; i++) {
			if (c - i <= citations[i]) {	// (c - i) = 해당 논문 이상으로 인용된 논문의 수
				answer = c - i;	// 가능한 값 저장
				break;	// 가장 큰 값을 찾았으므로 종료
			}
		}

		return answer;
	}
}
