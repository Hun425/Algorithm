

import java.util.*;
import java.io.*;
public class Main{
    static int N,M,Heal,home_x,home_y,ans;
    static int [][]map;
    static boolean[]visited;
    static List<Integer[]>cdn , cdn2;
    static boolean HomeCheck(Integer[] now) {
        int y = now[0];
        int x = now[1];
        int HP = now[2];
        if(HP<0)return false;



        int distance =Math.abs(home_y-y)+Math.abs(home_x-x);
        if(distance>HP)return false;

        return true;
    }
    static void DFS(Integer[]now) {
        if (HomeCheck(now)) {
            ans = Math.max(ans, now[3]);
        }






        for (int i =0; i<cdn2.size();i++) {
            if(visited[i])continue;
            int distance = Math.abs(now[1]-cdn2.get(i)[1])+Math.abs(now[0]-cdn2.get(i)[0]);
            int hp = now[2]-distance;
            if(hp<0)continue;

            visited[i]=true;
            DFS(new Integer[]{cdn2.get(i)[0],cdn2.get(i)[1],hp+Heal,now[3]+1});
            visited[i]=false;
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//마을크기
        M = Integer.parseInt(st.nextToken());//초기체력
        Heal = Integer.parseInt(st.nextToken());//민트초코 체력

        map = new int[N][N];

        cdn = new ArrayList<>();
        cdn2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home_y=i;
                    home_x=j;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    cdn2.add(new Integer[]{i,j,0,1});
                    int distance = Math.abs(home_x-j)+Math.abs(home_y-i);
                    if (distance <= M) {
                        cdn.add(new Integer[]{i,j,0,0});
                    }
                }
            }
        }
        visited= new boolean[11];
        ans =0;

        DFS(new Integer[]{home_y,home_x,M,0});

        System.out.println(ans);
    }
}
/*
1. 메서드화
2. 변수명
3. 주석
 */
