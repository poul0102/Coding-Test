package baekjoon;

import java.io.*;

public class B1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(str[0]);
			cost[i][1] = Integer.parseInt(str[1]);
			cost[i][2] = Integer.parseInt(str[2]);
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1],  dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0],  dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0],  dp[i - 1][1]) + cost[i][2];
		}
		
		int answer = Math.min(dp[N - 1][0],  Math.min(dp[N - 1][1],  dp[N - 1][2]));
		System.out.println(answer);
	}

}
