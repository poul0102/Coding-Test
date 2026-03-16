package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12936
public class P12936 {
	public int[] solution(int n, long k) {
		int[] answer = new int[n];

		// 사용할 숫자들을 담는 리스트
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		// factorial 값 배열
		long[] fact = new long[n];
		fact[0] = 1;

		for (int i = 1; i < n; i++) {
			fact[i] = fact[i - 1] * i;
		}

		// 0-index로 맞추기 위해 1 뺴기
		k--;

		for (int i = 0; i < n; i++) {
			// 현재 자리 결정을 위한 블록 크기
			long f = fact[n - 1 - i];

			// k가 몇 번째 블록에 속하는지 계산
			int index = (int) (k / f);

			// 해당 블록에 해당하는 숫자 선택
			answer[i] = list.get(index);
			list.remove(index);

			// 현재 블록 내부에서의 순서 다시 계산
			k %= f;
		}

		return answer;
	}
}
