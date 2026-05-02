package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996
public class P152996 {
	public long solution(int[] weights) {
		long answer = 0;

		Arrays.sort(weights);

		// <몸무게, 등장 횟수>
		Map<Long, Long> map = new HashMap<>();

		// 가능한 비율
		int[][] ratios = { 
			{ 1, 1 }, 
			{ 2, 3 }, 
			{ 1, 2 }, // {2, 4}
			{ 3, 4 } 
		};

		// 모든 몸무게 순회
		for (int weight : weights) {
			// 가능한 비율 모두 확인
			for (int[] ratio : ratios) {
				long num = (long) weight * ratio[0];

				// 나누어 떨어지는 경우만 유효한 몸무게
				if (num % ratio[1] == 0) {
					// 현재 몸무게와 시소 짝꿍인 몸무게
					long torque = num / ratio[1];
					// 이전에 해당하는 몸무게가 몇 명 있었는지
					answer += map.getOrDefault(torque, 0L);
				}
			}

			long base = weight;
			map.put(base, map.getOrDefault(base, 0L) + 1);
		}

		return answer;
	}
}
