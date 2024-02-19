import javax.sound.midi.Track;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;
    static boolean[] visited ;
    static int N,total,ans;
    static void Solve(int level,int start,int[]weight) {
        if (1 <= level && level < N && ConnectCheck(level)) {
            int sum =0;
            for (int i = 0; i < N; i++) {
                if(visited[i])sum+=weight[i];
            }
            sum = Math.abs(total-sum*2);
            ans=Math.min(sum,ans);
        }
        for (int i = start; i <N ; i++) {

            visited[i]=true;
            Solve(level+1,i+1,weight);
            visited[i]=false;
        }
    }

    static boolean ConnectCheck(int cnt) {
        int[]team1 = new int[cnt];
        int[]team2 = new int[N-cnt];

        int idx1=0;
        int idx2=0;
        for (int i = 0; i < N; i++) {
            if(visited[i])team1[idx1++]=i;
            else {
                team2[idx2++]=i;
            }
        }
        boolean[] visit = new boolean[N];
        checkteam1(team1[0], visit);
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                if (!visit[i]) {
                    return false;
                }
                visit[i]=false;
            }
        }

        checkteam2(team2[0], visit);
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (!visit[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void checkteam1(int start,boolean[] visit) {
        visit[start]= true;

        for (int now : graph[start]) {
            if(visit[now]||!visited[now])continue;
            checkteam1(now, visit);
        }
    }
    static void checkteam2(int start,boolean[]visit) {
        visit[start] =true;
        for (int now : graph[start]) {
            if(visit[now]||visited[now])continue;
            checkteam2(now,visit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 받기
        N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        st = new StringTokenizer(br.readLine());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
            total+=weight[i];
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int o = Integer.parseInt(st.nextToken())-1;
                graph[i].add(o);
            }
        }
        visited = new boolean[N];
        ans = Integer.MAX_VALUE;
        Solve(0,0,weight);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
}
    /*
        1.변수명 잘 설정하기
        2.전역 변수 최대한 적게 생성하기
        3.기능 메서드화 시키기
        4.주석 적기
     */