package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class P42884 {
	public int solution(int[][] routes) {
		int answer = 0; // 설치한 카메라 수
		int camera = -30001; // 마지막 카메라 위치

		// 진출 지점을 기준으로 정렬
		Arrays.sort(routes, (a, b) -> (a[1] - b[1]));

		for (int[] route : routes) {
			// 진입 지점이 마지막 카메라 위치보다 뒤에 있으면
			// 카메라를 만나지 않음
			if (route[0] > camera) {
				// 해당 차량의 진출 지점으로 카메라 위치 변경 (가장 뒤에 설치하기 위해)
				camera = route[1];
				answer++;
			}
		}

		return answer;
	}
}
