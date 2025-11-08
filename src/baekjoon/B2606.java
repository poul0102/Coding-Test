package baekjoon;

import java.io.*;
import java.util.*;

public class B2606 {
	
	static List<List<Integer>> graph = new ArrayList<>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			String[] node = bf.readLine().split(" ");
			int x = Integer.parseInt(node[0]);
			int y = Integer.parseInt(node[1]);
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		boolean[] visited = new boolean[N + 1];
		dfs(1, visited);
		System.out.println(answer);
		bfs(1, visited);
		System.out.println(answer - 1);
	}
	
	static void dfs(int node, boolean[] visited) {
		visited[node] = true;
		
		for(int i = 0; i < graph.get(node).size(); i++) {
			int next = graph.get(node).get(i);
			if(!visited[next]) {
				answer++;
				dfs(next, visited);
			}
		}
	}
	
	static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			answer++;
			
			for(int next : graph.get(current)) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}
