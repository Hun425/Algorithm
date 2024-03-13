import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static long cnt,home;

    static void BFS(Integer[]sam) {
        Queue<Integer[]>que = new LinkedList<>();

        HashMap<Integer,Integer>visited = new HashMap<>();
        for (Integer i : sam) {
            que.add(new Integer[]{i,0});
            visited.put(i, visited.getOrDefault(i,0)+1);
        }


        int[]dx = {1,-1};
        while (!que.isEmpty()) {
            Integer[] now = que.poll();
            boolean check = false;
            for (int i = 0; i < 2; i++) {
                Integer cdn = now[0]+dx[i];
                Integer unhappy =now[1]+1;
                visited.put(cdn, visited.getOrDefault(cdn,0)+1);
                if(visited.get(cdn)>=2)continue;

                cnt+=unhappy;
                home++;
                if (home == K) {
                    check=true;
                    break;
                }
                que.add(new Integer[]{cdn,unhappy});
            }
            if(check)break;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//샘터개수
        K = Integer.parseInt(st.nextToken());//집 개수

        st= new StringTokenizer(br.readLine());
        Integer[] sam= new Integer[N];
        for (int i = 0; i < N; i++) {
            sam[i]=Integer.parseInt(st.nextToken());
        }
        cnt=0;
        home=0;
        BFS(sam);

        System.out.println(cnt);

    }
}
