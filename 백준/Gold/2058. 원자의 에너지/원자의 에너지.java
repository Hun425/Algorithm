import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree;  // 트리 구조를 저장할 인접 리스트
    static int[][] dp;  // dp[node][state] : node를 선택했을때/안했을때의 최대값
    static int[] energy;  // 각 노드의 에너지값
    static boolean[] visited;  // DFS 방문 체크
    static HashSet<Integer> protonSet;  // 양성자 에너지 집합
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 원자의 에너지 상태 입력받기
        energy = new int[N];
        for(int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(br.readLine());
        }
        
        // 양성자 에너지를 HashSet에 저장 (빠른 검색을 위해)
        protonSet = new HashSet<>();
        for(int i = 0; i < M; i++) {
            protonSet.add(Integer.parseInt(br.readLine()));
        }
        
        // 트리 구조 초기화
        tree = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 양성자로 연결 가능한 노드들을 간선으로 연결
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(protonSet.contains(Math.abs(energy[i] - energy[j]))) {
                    tree.get(i).add(j);
                    tree.get(j).add(i);
                }
            }
        }
        
        // DP 배열과 방문 배열 초기화
        dp = new int[N][2];  // [노드번호][선택여부]
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        visited = new boolean[N];
        
        // 임의의 노드(0)에서 시작하여 최대값 계산
        System.out.println(Math.max(dfs(0, 0), dfs(0, 1)));
    }
    
    // node: 현재 노드, state: 0(미선택) 또는 1(선택)
    static int dfs(int node, int state) {
        // 이미 계산된 값이 있다면 반환
        if(dp[node][state] != -1) return dp[node][state];
        
        // 현재 노드 방문 처리
        visited[node] = true;
        
        // 현재 노드를 선택하지 않는 경우
        if(state == 0) {
            int sum = 0;
            // 자식 노드들을 순회하며 선택하거나 선택하지 않을 수 있음
            for(int next : tree.get(node)) {
                if(!visited[next]) {
                    sum += Math.max(dfs(next, 0), dfs(next, 1));
                }
            }
            dp[node][state] = sum;
        }
        // 현재 노드를 선택하는 경우
        else {
            int sum = energy[node];
            // 자식 노드들은 반드시 선택하지 않아야 함
            for(int next : tree.get(node)) {
                if(!visited[next]) {
                    sum += dfs(next, 0);
                }
            }
            dp[node][state] = sum;
        }
        
        // 방문 해제 (다른 경로에서의 방문을 위해)
        visited[node] = false;
        
        return dp[node][state];
    }
}