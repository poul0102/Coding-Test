package baekjoon;

import java.io.*;
import java.util.*;

public class B2258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long[][] meats = new long[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meats[i][0] = Long.parseLong(st.nextToken());
			meats[i][1] = Long.parseLong(st.nextToken());
		}

		// 가격 기준 오름차순 / 무게 기준 내림차순 정렬
		Arrays.sort(meats, (a, b) -> a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(b[0], a[0]));

		long sum = 0; // 현재까지 확보한 무게
		long cost = 0; // 지불해야 할 금액
		long prevPrice = 0; // 이전 가격
		long answer = Long.MAX_VALUE;

		// 앞에서부터 하나씩 확인
		for (int i = 0; i < N; i++) {
			long weight = meats[i][0];
			long price = meats[i][1];

			sum += weight;

			// 같은 가격인 경우
			if (price == prevPrice) {
				// 비용 지불
				cost += price;
			} else {
				cost = price;
				prevPrice = price;
			}

			// 필요한 무게 만족 시 최소 비용 확인
			if (sum >= M) {
				answer = Math.min(answer, cost);
			}
		}

		System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
	}

}
