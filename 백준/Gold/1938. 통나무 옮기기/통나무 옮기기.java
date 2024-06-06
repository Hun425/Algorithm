import java.io.*;
import java.util.*;
public class Main {
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열 크기

        int[][] arr =new int[N][N];


        int[][] start = new int[3][2];
        int[][] end = new int[3][2];

        int idx_start = 0;
        int idx_end = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if(s.charAt(j)=='B'){
                    arr[i][j]=0;  // 시작점 -1
                     start[idx_start][0]= i;
                     start[idx_start++][1]=j;// 좌표 미리 저장
                }
                else if(s.charAt(j)=='E'){
                    arr[i][j]=0; // 목표지점 -2
                    end[idx_end][0]=i;
                    end[idx_end++][1]=j;// 좌표 미리 저장
                }
                else arr[i][j]=Integer.parseInt(s.charAt(j)+"");
            }
        }


        BFS(start,end,arr);

        System.out.println(ans);

    }

    static void BFS(int[][] start, int[][] end,int[][]arr){
        Queue<Cdn> que = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // 중복체크 방지

        que.add(new Cdn(start,0));
        visited.add(Arrays.toString(start));

        int[][] dx = {{1,0},{-1,0},{0,1},{0,-1}}; // 하, 상, 우 , 좌

        while(!que.isEmpty()){
            Cdn cdn = que.poll();
            int[][] now = cdn.cdn;
            if(Arrays.deepEquals(now,end)){
                ans=cdn.cnt;
                break;
            }
            for (int i = 0; i < 5; i++) {

                int[][] next = new int[3][2];

                boolean check = true;

                if(i<4) {
                    for (int j = 0; j < now.length; j++) {
                        int delY = now[j][0] + dx[i][0];
                        int delX = now[j][1] + dx[i][1];

                        if (delX < 0 || delY < 0 || delX >= arr.length || delY >= arr.length) {
                            check = false;
                            break;
                        }
                        if (arr[delY][delX] == 1) {
                            check = false;
                            break;
                        }
                        next[j][0] = delY;
                        next[j][1] = delX;
                    }
                }else{
                    int firstY = now[0][0];
                    int firstX = now[0][1];

                    int midY = now[1][0];
                    int midX = now[1][1];

                    int lastY = now[2][0];
                    int lastX = now[2][1];

                    int[][] dx2 = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{-1,-1},{1,-1}}; // 8방향 검사

                    for (int j = 0; j < dx2.length; j++) {
                        int delY = midY + dx2[j][0];
                        int delX = midX + dx2[j][1];

                        if(delY < 0 || delX < 0 || delX >= arr.length || delY >= arr.length){
                            check = false;
                            break;
                        }
                        if (arr[delY][delX] == 1) {
                            check = false;
                            break;
                        }
                    }

                    if(check){
                        if(Math.abs(firstY-midY)==1){
                            next[0][0]=firstY+1;
                            next[0][1]=firstX-1;

                            next[1][0] = midY;
                            next[1][1]=midX;

                            next[2][0]=lastY-1;
                            next[2][1]=lastX+1;
                        }else{
                            next[0][0]=firstY-1;
                            next[0][1]=firstX+1;


                            next[1][0] = midY;
                            next[1][1]=midX;

                            next[2][0]=lastY+1;
                            next[2][1]=lastX-1;
                        }
                        int v = cdn.cnt+1;
                        if(visited.contains(Arrays.deepToString(next)))continue;
                        que.add(new Cdn(next,v));
                    }
                }
                if(check){
                    if(visited.contains(Arrays.deepToString(next)))continue; // 2차원 배열은 deepToString 써야함
                    int v = cdn.cnt+1;
                    que.add(new Cdn(next,v));
                    visited.add(Arrays.deepToString(next));
                }
            }
        }
    }

    static class Cdn {
        int[][] cdn;
        int cnt ;

        public Cdn(int[][] cdn, int cnt) {
            this.cdn = cdn;
            this.cnt = cnt;
        }
    }
}