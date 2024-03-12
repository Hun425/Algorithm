
import java.util.*;
import java.io.*;
public class Main {
    static int sheep,wolf,cntsheep,cntwolf,N,M;
    static boolean[][] visited;

    static void check(int y , int x, String[][] arr) {
        if(arr[y][x].equals("v"))wolf++;
        if(arr[y][x].equals("k"))sheep++;
    }
    static void BFS(int y , int x, String[][]arr) {
        Queue<Integer[]>cdn = new LinkedList<>();

        cdn.add(new Integer[]{y,x});
        visited[y][x]=true;
        check(y,x,arr);
        int[][] dx = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!cdn.isEmpty()) {
            Integer[]now = cdn.poll();

            for (int i = 0; i < 4; i++) {
                int del_y = now[0]+dx[i][0];
                int del_x = now[1]+dx[i][1];

                if(del_x<0 || del_x>=M || del_y<0 || del_y>=N)continue;
                if(visited[del_y][del_x])continue;
                if(arr[del_y][del_x].equals("#"))continue;
                visited[del_y][del_x]=true;
                
                check(del_y,del_x,arr);
                cdn.add(new Integer[]{del_y,del_x});
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//세로
        M = Integer.parseInt(st.nextToken());//가로

        visited = new boolean[N][M];

        String[][] arr =new String[N][M];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j])continue;
                if(arr[i][j].equals("#"))continue;
                sheep=0;
                wolf=0;

                BFS(i,j,arr);

                if(sheep>wolf)cntsheep+=sheep;
                else cntwolf+=wolf;
            }
        }

        System.out.println(cntsheep+" "+cntwolf);
    }
}
