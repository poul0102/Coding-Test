package baekjoon;

import java.io.*;
import java.util.*;

public class B1082 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		// 전체 중 최저가 숫자
		int minDigit = 0;
		for (int i = 1; i < N; i++) {
			if (price[i] < price[minDigit]) {
				minDigit = i;
			}
		}

		// 0 제외 최저가 숫자
		int firstDigit = -1;
		for (int i = 1; i < N; i++) {
			if (firstDigit == -1 || price[i] < price[firstDigit]) {
				firstDigit = i;
			}
		}

		// 첫 자리 숫자를 살 수 없는 경우
		if (firstDigit == -1 || price[firstDigit] > M) {
			System.out.println(0);
			return;
		}

		// 최대 길이 숫자 만들기
		StringBuilder sb = new StringBuilder();
		sb.append(firstDigit);
		int money = M - price[firstDigit];

		int count = money / price[minDigit];
		for (int i = 0; i < count; i++) {
			sb.append(minDigit);
		}
		money -= count * price[minDigit];

		// 앞자리부터 큰 숫자로 교체
		for (int i = 0; i < sb.length(); i++) {
			int current = sb.charAt(i) - '0';

			for (int j = N - 1; j > current; j--) {
				int diff = price[j] - price[current];

				if (diff <= money) {
					money -= diff;
					sb.setCharAt(i, (char) ('0' + j));
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}

}
