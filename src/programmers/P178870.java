package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class P178870 {
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int left = 0;
		int right = 0;
		int len = Integer.MAX_VALUE;
		int sum = sequence[0];

		while (left <= right) {
			// 현재까지의 합계가 k보다 작은 경우
			if (sum < k) {
				// right++ (right의 값이 주어진 수열의 길이보다 큰 경우 break)
				right++;
				if (right >= sequence.length) break;
				sum += sequence[right];
			}
			// 현재까지의 합계가 k보다 큰 경우
			else if (sum > k) {
				// left++
				sum -= sequence[left++];
			}
			// 현재까지의 합계가 k와 같을 경우
			else {
				// 길이가 짧은 경우 정답 갱신
				if (right - left < len) {
					len = right - left;
					answer[0] = left;
					answer[1] = right;
				}
				// 또 다른 부분 수열 찾기 위해 left++
				sum -= sequence[left++];
			}
		}

		return answer;
	}
}
